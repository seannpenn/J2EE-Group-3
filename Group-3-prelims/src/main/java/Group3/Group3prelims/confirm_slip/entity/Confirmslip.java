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
	@Column(name = "confirm_ID")
	private Integer confirmID;
	@Column(name = "user_id")
	private Integer userID;
	@Column(name = "confirm_ticket")
	private Integer confirmTicket;
	@Column(name = "confirm_date")
	private String confirmDate;
	@Column(name = "confirm_desc")
	private String confirmDesc;
	@Column(name = "confirm_signatures")
	private String confirmSignatures;
	
	@Column(name = "confirm_amount_path")
	private String confirmAmountPath;
	
	@Column(name = "confirm_amount_int")
	private Integer confirm_amount_int;
	
	
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
	
	
	
	
	public Integer getConfirmAmountInt() {
		return confirm_amount_int;
	}
	public void setConfirmAmountInt(Integer confirmAmount) {
		this.confirm_amount_int = confirmAmount;
	}
	public String getConfirmAmountPath() {
		return confirmAmountPath;
	}
	public void setConfirmAmountPath(String confirmAmountPath) {
		this.confirmAmountPath = confirmAmountPath;
	}
	
	
	

}
