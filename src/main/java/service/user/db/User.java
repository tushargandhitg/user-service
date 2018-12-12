package service.user.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Integer userid;
	
	private String email;
	private Double credits;
	
	public User() {}
	
	public User(Integer userid, String email, Double credits) {
		super();
		this.userid = userid;
		this.email = email;
		this.credits = credits;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getCredits() {
		return credits;
	}
	public void setCredits(Double credits) {
		this.credits = credits;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", email=" + email + ", credits=" + credits + "]";
	}
	
	
	
}
