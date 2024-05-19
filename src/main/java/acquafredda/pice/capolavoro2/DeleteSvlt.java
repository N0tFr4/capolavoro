package acquafredda.pice.capolavoro2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acquafredda.pice.capolavoro2.pojo.Transaction;

/**
 * Servlet implementation class DeleteSvlt
 */
@WebServlet("/deletesvlt")
public class DeleteSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		Integer idValue=Integer.valueOf(id);

        final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
        final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
        final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
        Connection conn;

        try {
            conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            String query="DELETE FROM transactions WHERE transaction_id = ?";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, idValue);

            ps.executeUpdate();

            response.sendRedirect("selectalltransactionssvlt");
            
            }catch(SQLException e) {}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
