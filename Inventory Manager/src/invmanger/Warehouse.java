package invmanger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedList;

public class Warehouse implements Serializable {
/**
 * Represents a warehouse owned by the client, which holds Products.
 * @author Nick Bishop & Alexander Dung
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
	
	/**
	 * Constructor, assumes input ArrayList of Products is all known products, and none are in stock.
	 * @param name      the name of the warehouse
	 * @param address   the location of the warehouse
	 * @param phone     the phone number of the warehouse
	 * @param products  list of all possible products the warehouse can have
	 */
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
	
	/**
	 * Adds a new product ID to the inventory list. Assumes there are none in stock.
	 * @param ID the ID of the product to add to the inventory
	 */
	public void addProduct(int ID) {
		inventory.put(ID, 0);
	}
	
	/**
	 * Adds a new product ID to the inventory list, with the input amount in stock.
	 * @param ID the ID of the product to add to the inventory
	 * @param amount the number of units of the product that are in stock at this warehouse
	 */
	public void addProduct(int ID, int amount) {
		inventory.put(ID, amount);
	}
	
	/**
	 * Returns a String containing the warehouse's information and a list of all products that are low on stock (stock at 5 or less, but not 0).
	 * @return a String containing the warehouse's information and a list of all low-stock products in inventory
	 */
	public String listLowStock() {
		String toReturn = "";
		toReturn = String.format("Warehouse Name: %s%nPhone Number:   %s%nAddress:        %s", this.name, this.phone, this.address);
		toReturn += String.format("%nInventory Stock:%n%-30s|%-15s|%-15s|%-20s|%-15s|%-10s", "Product Name", "Wholesale Cost", "Retail Price", "Product Category", "Quantity Sold", "In Stock");
		LinkedList<HashMap.Entry<Integer, Integer>> entries = new LinkedList<HashMap.Entry<Integer, Integer>>(inventory.entrySet());
		Collections.sort(entries, HashMap.Entry.comparingByValue());
		Iterator<HashMap.Entry<Integer, Integer>> iter = entries.iterator();
		while(iter.hasNext()) {
			HashMap.Entry<Integer, Integer> entry = iter.next();
			if(entry.getValue() > 0 && entry.getValue() <= 5) {
				for(Product p : Data.productArr) {
					if(p.getID() == entry.getKey()) {
						toReturn += "\n" + p.toString() + "|" + entry.getValue();
						break;
					}
				}
			}
		}
		return toReturn;
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
		Data.productArr.add(new Product("prod4", 1.00f, 2.00f, "Radio"));
		Data.productArr.add(new Product("prod5", 1.00f, 2.00f, "Microwave"));
		Data.productArr.add(new Product("prod6", 1.00f, 2.00f, "Radio"));
		Data.productArr.add(new Product("prod7", 100.00f, 20.00f, "Washing Machine"));
		Warehouse wh1 = new Warehouse("Big Warehouse", "555 W. Bellflower Blvd, Long Beach, CA", "555-555-5555", Data.productArr);
		wh1.increaseStock(1, 4);
		wh1.increaseStock(2, 10);
		wh1.increaseStock(3, 1);
		wh1.increaseStock(4, 1);
		wh1.increaseStock(5, 2);
		wh1.increaseStock(6, 5);
		wh1.increaseStock(7, 6);
		System.out.println(wh1.listLowStock());
	}
}
