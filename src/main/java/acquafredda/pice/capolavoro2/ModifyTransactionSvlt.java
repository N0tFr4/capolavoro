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
 * Servlet implementation class ModifyTransactionSvlt
 */
@WebServlet("/modifytransactionsvlt")
public class ModifyTransactionSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyTransactionSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id= Integer.valueOf(request.getParameter("id"));
		String amount=request.getParameter("amount");
		String date=request.getParameter("date");
		String type=request.getParameter("typeT");
		
//		System.out.println("amount = "+ amount);
//		System.out.println("dates = "+ date);
//		System.out.println("type = "+ type);
		
		int userId = 0;
		String sender = request.getParameter("sender");
		String reason = request.getParameter("reason");
		
		System.out.println("SENDER = " + sender);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateDate = sdf.parse(date);
		
		int amountInt = Integer.parseInt(amount);
		
		HttpSession session = request.getSession();
		
		if(type == "income") {
			reason = null;
		}else if(type == "outcome") {
			sender = null;
		}
		
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		try {
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//			String query="SELECT user_id FROM users WHERE user_nickname = ?";
//			PreparedStatement ps=conn.prepareStatement(query);
//			ps.setString(1, username);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			
//			
//			if(rs.next()) {
//				userId = rs.getInt("user_id");
//			}
			
			String query2="UPDATE transactions SET transaction_amount = ?, transaction_date = ?, transaction_sender = ?, transaction_reason = ? WHERE transaction_id = ?";
			PreparedStatement ps2=conn.prepareStatement(query2);
			ps2.setInt(1, amountInt);
			ps2.setDate(2, new java.sql.Date(dateDate.getTime()));
			ps2.setString(3, sender);
			ps2.setString(4, reason);
			ps2.setInt(5, id);
			
			int rowInserted2= ps2.executeUpdate();
			System.out.println(rowInserted2);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
