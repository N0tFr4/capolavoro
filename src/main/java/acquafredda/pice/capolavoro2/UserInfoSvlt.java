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
import acquafredda.pice.capolavoro2.pojo.User;

/**
 * Servlet implementation class UserInfoSvlt
 */
@WebServlet("/userinfosvlt")
public class UserInfoSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		HttpSession session = request.getSession();
		Integer id =(Integer) session.getAttribute("idUser");
		User user = null;
		try {
			
			String query="SELECT * FROM users WHERE user_id = ?";
			
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			user = new User();

            while(rs.next()) {
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_nickname(rs.getString("user_nickname"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_surname(rs.getString("user_surname"));
                user.setUser_phone_number(rs.getString("user_phone_number"));
            }
			
			} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		session.setAttribute("user", user);
		response.sendRedirect("info.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
