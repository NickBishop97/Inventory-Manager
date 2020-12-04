package invmanger;

import java.io.Serializable;

public class Warehouse implements Serializable {
/**
 * Represents a warehouse owned by the client, which holds Products.
 * @author Nick Bishop
 */
	//private List<int> productlist;
	private String name;
	private String address;
	private String phone;
	
	/**
	 * Standard-use constructor, warehouse has not been created
	 * @param name	the name of the warehouse
	 * @param address	the location of the warehouse
	 * @param phone		the phone number of the warehouse
	 */
	public Warehouse(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	/**
	 * Sets this warehouse ID name to the String newName
	 * @param newName new string value for the warehouse.
	 */
	public void setWarehouseID(String newName) {
		this.name = newName;
	}
	//public void addStock()
	//public void removeStock()
	/**
	 * Returns the warehouse's ID number
	 * @return this warehouse's ID number
	 */
	public String getWarehouseID() {
		return this.name;
	}
	/**
	 * Sets the phone number for the warehouse
	 * @param newPhone Sets the phone number for the warehouse
	 */
	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}
	/**
	 * Returns the warehouse phone number
	 * @return this warehouse phone number
	 */
	public String getPhone() {
		return this.phone;
	}
	/**
	 * Sets the address for the warehouse
	 * @param newAddress sets address for warehouse
	 */
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	/**
	 * Returns the address for the warehouse
	 * @return the address of the warehouse
	 */
	public String getAddress() {
		return this.address;
	}
	//Override toString for Warehouse
		public String toString() {
			String toReturn = "";
			toReturn = String.format("%-30s|%-11s|%-50", this.name, this.phone, this.address);
			return toReturn;
		}
}
