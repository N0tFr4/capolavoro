package acquafredda.pice.capolavoro2;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthSvlt
 */
@WebServlet("/authsvlt")
public class AuthSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Integer idUser = null;
		
		String passwordHash = calcolaHashMD5(password);
		
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		
		try {
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement statement = conn.createStatement();
			ResultSet set=statement.executeQuery("SELECT * FROM users");
			boolean flag = false;
			while(set.next()) {
				if(username.equals(set.getString(2)) && passwordHash.equals(set.getString(3))) {
					flag=true;
					idUser = set.getInt(1);
					break;
				}
			}
			
			if(flag) {
				response.getWriter().write("trovato");
				HttpSession session = request.getSession();
	            session.setAttribute("idUser", idUser);
			}else {
				response.getWriter().write("non trovato");
			}
		
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
