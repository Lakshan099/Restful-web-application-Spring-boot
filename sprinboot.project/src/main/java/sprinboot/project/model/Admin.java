package sprinboot.project.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection= "Admin")

public class Admin {
	
	@Id
	private int id;
	@Field("AdminName")
	private String AdminName;
	private String Password;
	
	Admin(int id, String AdminName, String Password) {
		
		this.id = id;
		this.AdminName = AdminName;
		this.Password = Password;
	}

	public int getid() {
		return id;
	}

	public void setAdminID(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String AdminName) {
		this.AdminName = AdminName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	
	

}
