package acquafredda.pice.capolavoro2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class SelectAllTransactions
 */
@WebServlet("/selectalltransactions")
public class SelectAllTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		try {
			
			HttpSession session = request.getSession();
			Integer id =(Integer) session.getAttribute("idUser");
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			String query="SELECT * FROM transactions WHERE transaction_usr_id = ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
		
			JSONObject objgran = new JSONObject();
			
			JSONArray array = new JSONArray();
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				
				obj.put("id", rs.getInt(1));
				obj.put("type", rs.getString(2));
				obj.put("date", rs.getString(3));
				obj.put("sender", rs.getString(4));
				obj.put("reason", rs.getString(5));

				array.add(obj);
			}
			
			objgran.put("array", array);
			String risposta = objgran.toString();
			response.getWriter().write(risposta);

			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
