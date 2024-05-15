package acquafredda.pice.capolavoro2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertTransactionSvlt
 */
@WebServlet("/inserttransactionsvlt")
public class InsertTransactionSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTransactionSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amount=request.getParameter("amount");
		String date=request.getParameter("date");
		String type=request.getParameter("type");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDate = sdf.parse(date);
		int amountInt = Integer.parseInt(amount);
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(type == "income") {
			String sender=request.getParameter("sender");
			String reason = null;
		}else {
			String reason=request.getParameter("reason");
			String sender = null;
		}
		
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		try {
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			String query="SELECT user_id FROM users WHERE user_nickname = ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//prendi l'id dalla query
			}
			
			String query2="INSERT INTO transactions (transaction_type,transaction_amount,transaction_date,transaction_sender,transaction_reason,transaction_usr_id) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps2=conn.prepareStatement(query2);
			ps2.setString(1, type);
			ps2.setInt(2, amountInt);
			ps2.setDate(3, new java.sql.Date(dateDate.getTime()));
			
			
			
			int rowInserted2= ps2.executeUpdate();
			System.out.println(rowInserted2);
			
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
