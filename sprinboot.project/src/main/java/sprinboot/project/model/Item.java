package sprinboot.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection= "Item")
public class Item {
	@Id
	private int id;
	private String MedicineName;
	private String Description;
	private int Quantity;
	private float Price;
	private String ExDate;
	
	public Item(int id,String MedicineName,String Description,int Quantity,float Price,String ExDate)
	{
		this.id=id;
		this.MedicineName = MedicineName;
		this.Description = Description;
		this.Quantity = Quantity;
		this.Price = Price;
		this.ExDate = ExDate;
	}
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id=id;
	}
	
	public String getMedicineName() {
		return MedicineName;
	}
	
	public void setMedicineName(String MedicineName) {
		this.MedicineName = MedicineName;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
	
	public float getPrice() {
		return Price;
	}
	
	public void setPrice(float Price) {
		this.Price = Price;
	}
	
	public String getExDate() {
		return ExDate;
	}
	
	public void setExDate(String ExDate) {
		this.ExDate = ExDate;
	}
	
}
