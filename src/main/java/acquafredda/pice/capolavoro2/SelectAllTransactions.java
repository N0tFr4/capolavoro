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
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			String query="SELECT * FROM transactions";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
		
			JSONObject objgran = new JSONObject();
			
			JSONArray array = new JSONArray();
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				
				obj.put("transactions_id", rs.getInt("transactions_id"));
				obj.put("transactions_type", rs.getString("transactions_type"));
				obj.put("transactions_date", rs.getString("transactions_date"));
				obj.put("transactions_sender", rs.getString("transactions_sender"));
				obj.put("transactions_reason", rs.getString("transactions_reason"));
				obj.put("transactions_usr_id", rs.getString("transactions_usr_id"));

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
