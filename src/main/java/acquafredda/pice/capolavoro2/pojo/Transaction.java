package acquafredda.pice.capolavoro2.pojo;

import java.util.Objects;

public class Transaction {
	
	private Integer transaction_id;
	private String transaction_type;
	private Integer transaction_amount;
	private String transaction_date;
	private String transaction_sender;
	private String transaction_reason;
	private Integer transaction_urs_id;
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public Integer getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(Integer transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getTransaction_sender() {
		return transaction_sender;
	}
	public void setTransaction_sender(String transaction_sender) {
		this.transaction_sender = transaction_sender;
	}
	public String getTransaction_reason() {
		return transaction_reason;
	}
	public void setTransaction_reason(String transaction_reason) {
		this.transaction_reason = transaction_reason;
	}
	public Integer getTransaction_urs_id() {
		return transaction_urs_id;
	}
	public void setTransaction_urs_id(Integer transaction_urs_id) {
		this.transaction_urs_id = transaction_urs_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(transaction_amount, transaction_date, transaction_id, transaction_reason,
				transaction_sender, transaction_type, transaction_urs_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(transaction_amount, other.transaction_amount)
				&& Objects.equals(transaction_date, other.transaction_date)
				&& Objects.equals(transaction_id, other.transaction_id)
				&& Objects.equals(transaction_reason, other.transaction_reason)
				&& Objects.equals(transaction_sender, other.transaction_sender)
				&& Objects.equals(transaction_type, other.transaction_type)
				&& Objects.equals(transaction_urs_id, other.transaction_urs_id);
	}
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", transaction_type=" + transaction_type
				+ ", transaction_amount=" + transaction_amount + ", transaction_date=" + transaction_date
				+ ", transaction_sender=" + transaction_sender + ", transaction_reason=" + transaction_reason
				+ ", transaction_urs_id=" + transaction_urs_id + "]";
	}

}
