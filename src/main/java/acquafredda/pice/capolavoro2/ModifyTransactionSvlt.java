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
		
		Integer id= Integer.valueOf(request.getParameter("id"));
		String amount=request.getParameter("amount");
		String date=request.getParameter("date");
		String type=request.getParameter("typeT");
		String sender = request.getParameter("sender");
		String reason = request.getParameter("reason");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateDate = sdf.parse(date);
		
			int amountInt = Integer.parseInt(amount);
	
			
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
				
				String query="UPDATE transactions SET transaction_amount = ?, transaction_date = ?, transaction_sender = ?, transaction_reason = ? WHERE transaction_id = ?";
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setInt(1, amountInt);
				ps.setDate(2, new java.sql.Date(dateDate.getTime()));
				ps.setString(3, sender);
				ps.setString(4, reason);
				ps.setInt(5, id);
				
				ps.executeUpdate();
				
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
