package invmanger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class Warehouse implements Serializable {
/**
 * Represents a warehouse owned by the client, which holds Products.
 * @author Nick Bishop
 */
	private HashMap<Integer, Integer> inventory;
	private String name;
	private String address;
	private String phone;
	
	/**
	 * Standard-use constructor, warehouse has not been created, assume no products exist so far.
	 * @param name	the name of the warehouse
	 * @param address	the location of the warehouse
	 * @param phone		the phone number of the warehouse
	 */
	public Warehouse(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.inventory = new HashMap<Integer, Integer>();
	}
	
	public Warehouse(String name, String address, String phone, ArrayList<Product> products) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.inventory = new HashMap<Integer, Integer>();
		for(Product prod:products) {
			inventory.put(prod.getID(), 0);
		}
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
	
	/**
	 * Given the product ID, increase the product's respective stock count by amt.
	 * @param ID  the ID of the product whose stock will be increased
	 * @param amt the amount by which the product's stock will be increased
	 */
	public void increaseStock(int ID, int amt) {
		inventory.put(ID, inventory.get(ID)+amt);
	}
	
	/**
	 * Given the product ID, reduce the product's respective stock count by amt.
	 * @param ID  the ID of the product whose stock will be reduced
	 * @param amt the amount by which the product's stock will be reduced
	 */
	public void decreaseStock(int ID, int amt) {
		inventory.put(ID, inventory.get(ID)-amt);
	}
	
	//Override toString for Warehouse
	@Override
	public String toString() {
		String toReturn = "";
		toReturn = String.format("Warehouse Name: %s%nPhone Number:   %s%nAddress:        %s", this.name, this.phone, this.address);
		toReturn += String.format("%nInventory Stock:%n%-30s|%-15s|%-15s|%-20s|%-15s|%-10s", "Product Name", "Wholesale Cost", "Retail Price", "Product Category", "Quantity Sold", "In Stock");
		Iterator<Integer> productCodes = inventory.keySet().iterator();
		while(productCodes.hasNext()) {
			int code = productCodes.next();
			int inStock = inventory.get(code);
			if(inStock != 0) {
				for(Product p : Data.productArr) {
					if(p.getID() == code) {
						toReturn += "\n" + p.toString() + "|" + inStock;
						System.out.println("added" + p.toString() + "\n" + p.getID());
						break;
					}
				}
			}
		}
		return toReturn;
	}
		
	public static void main(String[] args) {
		Data.productArr.add(new Product("prod1", 1.00f, 2.00f, "TV"));
		Data.productArr.add(new Product("prod2", 1.00f, 2.00f, "TV"));
		Data.productArr.add(new Product("prod3", 1.00f, 2.00f, "Radio"));
		Warehouse wh1 = new Warehouse("Big Warehouse", "555 W. Bellflower Blvd, Long Beach, CA", "555-555-5555", Data.productArr);
		wh1.increaseStock(1, 4);
		System.out.println(wh1);
	}
}
