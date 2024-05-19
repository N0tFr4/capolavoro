package acquafredda.pice.capolavoro2;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertSvlt
 */
@WebServlet("/insertsvlt")
public class InsertSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("firstname");
		String surname=request.getParameter("surname");
		String phoneNumber=request.getParameter("phone_number");
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		
		String passwordHash = calcolaHashMD5(password);
		
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		try {
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			String query="INSERT INTO users (user_nickname, user_password, user_name, user_surname, user_phone_number) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, passwordHash);
			ps.setString(3, name);
			ps.setString(4, surname);
			ps.setString(5, phoneNumber);
			
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
	
	private static String calcolaHashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
