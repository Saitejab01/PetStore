package POJO.util;

import java.util.Date;
import java.util.Objects;

public class StorePOJO {
	  private int id;
	  private int petId;
	  private int quantity;
	  private Date shipDate;
	  private String status;
	  private boolean complete;
	  
	  public StorePOJO() {
		super();
	}
	  public StorePOJO(int id, int petId, int quantity, Date shipDate, String status, boolean complete) {
		super();
		this.id = id;
		this.petId = petId;
		this.quantity = quantity;
		this.shipDate = shipDate;
		this.status = status;
		this.complete = complete;
	}
	  public int getId() {
		  return id;
	  }
	  public void setId(int id) {
		  this.id = id;
	  }
	  public int getPetId() {
		  return petId;
	  }
	  public void setPetId(int petId) {
		  this.petId = petId;
	  }
	  public int getQuantity() {
		  return quantity;
	  }
	  public void setQuantity(int quantity) {
		  this.quantity = quantity;
	  }
	  public Date getShipDate() {
		  return shipDate;
	  }
	  public void setShipDate(Date shipDate) {
		  this.shipDate = shipDate;
	  }
	  public String getStatus() {
		  return status;
	  }
	  public void setStatus(String status) {
		  this.status = status;
	  }
	  public boolean isComplete() {
		  return complete;
	  }
	  public void setComplete(boolean complete) {
		  this.complete = complete;
	  }
	  @Override
	  public String toString() {
		return "StorePOJO [id=" + id + ", petId=" + petId + ", quantity=" + quantity + ", shipDate=" + shipDate
				+ ", status=" + status + ", complete=" + complete + "]";
	  }
	  @Override
	  public int hashCode() {
		return Objects.hash(complete, id, petId, quantity, shipDate, status);
	  }
	  @Override
	  public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StorePOJO other = (StorePOJO) obj;
		return complete == other.complete && id == other.id && petId == other.petId && quantity == other.quantity
				&& Objects.equals(shipDate, other.shipDate) && Objects.equals(status, other.status);
	  }
	  
	  
	  
}
