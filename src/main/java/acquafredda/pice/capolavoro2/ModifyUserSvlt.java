package acquafredda.pice.capolavoro2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyUserSvlt
 */
@WebServlet("/modifyusersvlt")
public class ModifyUserSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("idUser");
		
		String name=request.getParameter("firstname");
		String surname=request.getParameter("surname");
		String phoneNumber=request.getParameter("phoneNumber");
		
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		try {
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			String query="UPDATE users SET user_name = ?, user_surname = ?, user_phone_number = ? WHERE user_id = ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, phoneNumber);
			ps.setInt(4, id);
			
			ps.executeUpdate();		
			
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
