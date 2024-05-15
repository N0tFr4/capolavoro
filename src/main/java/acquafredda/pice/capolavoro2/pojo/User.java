package acquafredda.pice.capolavoro2.pojo;

import java.util.Objects;

public class User {
	
	private Integer user_id;
	private String user_nickname;
	private String user_password;
	private String user_name;
	private String user_surname;
	private String user_phone_number;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_surname() {
		return user_surname;
	}
	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}
	public String getUser_phone_number() {
		return user_phone_number;
	}
	public void setUser_phone_number(String user_phone_number) {
		this.user_phone_number = user_phone_number;
	}
	@Override
	public int hashCode() {
		return Objects.hash(user_id, user_name, user_nickname, user_password, user_phone_number, user_surname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(user_id, other.user_id) && Objects.equals(user_name, other.user_name)
				&& Objects.equals(user_nickname, other.user_nickname)
				&& Objects.equals(user_password, other.user_password)
				&& Objects.equals(user_phone_number, other.user_phone_number)
				&& Objects.equals(user_surname, other.user_surname);
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_nickname=" + user_nickname + ", user_password=" + user_password
				+ ", user_name=" + user_name + ", user_surname=" + user_surname + ", user_phone_number="
				+ user_phone_number + "]";
	}

}
