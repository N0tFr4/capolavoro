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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import acquafredda.pice.capolavoro2.pojo.Transaction;

/**
 * Servlet implementation class SelectAllTransactions
 */
@WebServlet("/selectalltransactionssvlt")
public class SelectAllTransactionsSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllTransactionsSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer id =(Integer) session.getAttribute("idUser");
		
		final String DB_URL=request.getServletContext().getInitParameter("DB_URL");
		final String DB_USER=request.getServletContext().getInitParameter("DB_USER");
		final String DB_PASS=request.getServletContext().getInitParameter("DB_PASS");
		Connection conn;
		
		List<Transaction> transactionsIncome = null;
		try {
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			String query="SELECT * FROM transactions WHERE transaction_usr_id = ? and transaction_type = ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2, "income");
			ResultSet rs = ps.executeQuery();
			
			transactionsIncome = new ArrayList<>();

            while(rs.next()) {
                Transaction transaction=new Transaction();
                transaction.setTransaction_id(rs.getInt("transaction_id"));
                transaction.setTransaction_type(rs.getString("transaction_type"));
                transaction.setTransaction_amount(rs.getInt("transaction_amount"));
                transaction.setTransaction_date(rs.getString("transaction_date"));
                transaction.setTransaction_sender(rs.getString("transaction_sender"));
                transaction.setTransaction_reason(rs.getString("transaction_reason"));
                transactionsIncome.add(transaction);
            }
			
			} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		session.setAttribute("TransactionsListIncome", transactionsIncome);
		
		List<Transaction> transactionsOutcome = null;
		try {
			
			conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			String query="SELECT * FROM transactions WHERE transaction_usr_id = ? and transaction_type = ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2, "outcome");
			ResultSet rs = ps.executeQuery();
			
			transactionsOutcome = new ArrayList<>();

            while(rs.next()) {
                Transaction transaction=new Transaction();
                transaction.setTransaction_id(rs.getInt("transaction_id"));
                transaction.setTransaction_type(rs.getString("transaction_type"));
                transaction.setTransaction_amount(rs.getInt("transaction_amount"));
                transaction.setTransaction_date(rs.getString("transaction_date"));
                transaction.setTransaction_sender(rs.getString("transaction_sender"));
                transaction.setTransaction_reason(rs.getString("transaction_reason"));
                transactionsOutcome.add(transaction);
            }
			
			} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		session.setAttribute("TransactionsListOutcome", transactionsOutcome);
		response.sendRedirect("transactions.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
