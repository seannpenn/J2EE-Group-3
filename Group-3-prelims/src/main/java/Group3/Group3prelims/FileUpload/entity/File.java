package Group3.Group3prelims.FileUpload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id")
	private Integer fileID;
	
	@Column(name = "ticket_id")
	private Integer ticketID;
	
	private String type;
	private String path;
	
	public Integer getFileID() {
		return fileID;
	}
	public void setFileID(Integer fileID) {
		this.fileID = fileID;
	}
	
	public Integer getTicketID() {
		return ticketID;
	}
	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
