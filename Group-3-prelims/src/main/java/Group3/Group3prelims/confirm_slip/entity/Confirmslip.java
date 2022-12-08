package Group3.Group3prelims.confirm_slip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Confirmslip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer confirmID;
	@Column(name = "user_id")
	private Integer userID;
	private Integer confirmTicket;
	private String confirmDate;
	private String confirmDesc;
	private String confirmSignatures;
	private String confirmAmount;
	
	public Integer getConfirmID() {
		return confirmID;
	}
	public void setConfirmID(Integer confirmID) {
		this.confirmID = confirmID;
	}
	
	public Integer getConfirmTicket() {
		return confirmTicket;
	}
	public void setConfirmTicket(Integer confirmTicket) {
		this.confirmTicket = confirmTicket;
	}
	public Integer getConfirmUser() {
		return userID;
	}
	public void setConfirmUser(Integer confirmUser) {
		this.userID = confirmUser;
	}
	public String getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getConfirmDesc() {
		return confirmDesc;
	}
	public void setConfirmDesc(String confirmDesc) {
		this.confirmDesc = confirmDesc;
	}
	public String getConfirmSignatures() {
		return confirmSignatures;
	}
	public void setConfirmSignatures(String confirmSignatures) {
		this.confirmSignatures = confirmSignatures;
	}
	public String getConfirmAmount() {
		return confirmAmount;
	}
	public void setConfirmAmount(String confirmAmount) {
		this.confirmAmount = confirmAmount;
	}
	
	
	
	

}
