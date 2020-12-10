package invmanger;

import java.io.Serializable;

/**
 * Represents a Product in the client's Warehouse or general product inventory.
 * @author Alexander Dung
 */
@SuppressWarnings("serial")
public class Product implements Serializable {
	private String name;
	private float costPrice;
	private float salePrice;
	private static int IDAssign = 0;
	private int ID;
	private String category;
	private int quantitySold;
	
	/**
	 * Default constructor for a Product. Bypasses the automatic ID assignment, which is dangerous.
	 * @param name          name of this Product
	 * @param costPrice     dollar and cent cost of buying this product wholesale.
	 * @param salePrice     dollar and cent cost of retailing this product.
	 * @param ID            string of characters used to uniquely identify this product.
	 * @param category      product archetype that this Product belongs to.
	 * @param quantitySold  count of how many times this Product has been sold.
	 */
	public Product (String name, float costPrice, float salePrice, int ID, String category, int quantitySold) {
		this.name = name;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		this.ID = ID;
		this.category = category;
		this.quantitySold = quantitySold;
	}
	
	/**
	 * General-use constructor for a Product. Assigns an auto-incrementing ID number to the product, and assumes this product has not yet been sold.
	 * @param name          name of this Product
	 * @param costPrice     dollar and cent cost of buying this product wholesale.
	 * @param salePrice     dollar and cent cost of retailing this product.
	 * @param category      product archetype that this Product belongs to.
	 */
	public Product (String name, float costPrice, float salePrice, String category) {
		this.name = name;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		IDAssign++;
		this.ID = IDAssign;
		this.category = category;
		this.quantitySold = 0;
	}

	/**
	 * Returns this Product's name as a String.
	 * @return a String representing this Product's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets this Product's name to the argument String newName.
	 * @param newName the String to set this Product's name to.
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Returns this Product's cost to restock as a float.
	 * @return a float representing the dollar-and-cent price to restock this Product.
	 */
	public float getCostPrice() {
		return costPrice;
	}

	/**
	 * Sets this Product's costPrice to the argument newPrice.
	 * @param newPrice the float to set this Product's costPrice to.
	 */
	public void setCostPrice(float newPrice) {
		this.costPrice = newPrice;
	}

	/**
	 * Returns the cost for a customer to purchase one of this Product.
	 * @return a float representing the dollar-and-cent price to purchase this Product.
	 */
	public float getSalePrice() {
		return salePrice;
	}

	/**
	 * Sets this Product's salePrice to the argument newPrice.
	 * @param newPrice the float to set this Product's salePrice to.
	 */
	public void setSalePrice(float newPrice) {
		this.salePrice = newPrice;
	}

	/**
	 * Returns the ID number assigned to this Product.
	 * @return an integer representing the unique ID number assigned to this Product.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets this Product's ID number to the argument newID
	 * @param newID the new ID number to set this Product's ID number to.
	 */
	public void setID(int newID) {
		ID = newID;
	}

	/**
	 * Returns the category of product that this Product belongs to.
	 * @return a string containing the type that this Product is.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets this Product's category to the argument newCategory.
	 * @param newCategory the String to set this Product's category to
	 */
	public void setCategory(String newCategory) {
		this.category = newCategory;
	}

	/**
	 * Returns the number of times this Product has been successfully sold to a customer.
	 * @return an integer representing the number of times this Product has been sold.
	 */
	public int getQuantitySold() {
		return quantitySold;
	}

	/**
	 * Sets this Product's quantitySold to the argument newQuantity.
	 * @param newQuantity the integer to set this Product's quantitySold to.
	 */
	public void setQuantitySold(int newQuantity) {
		this.quantitySold = newQuantity;
	}
	
	/**
	 * Increments the number of times this Product has been sold by 1.
	 */
	public void incrementQuantitySold() {
		this.quantitySold++;
	}
	
	/**
	 * Returns the current number that the next Product's ID will be assigned to.
	 * @return the IDAssign number
	 */
	@SuppressWarnings("static-access")
	public int getIDCounter() {
		return this.IDAssign;
	}
	
	/**
	 * Sets the number that the next Product's ID will be assigned to.
	 * @param IDA the new ID.
	 */
	@SuppressWarnings("static-access")
	public void setIDCounter(int IDA) {
		this.IDAssign = IDA;
	}
	
	/**
	 * Returns a String containing this Product's:
	 *  ID, padded to 5 characters;
	 *  name, padded to 30 characters;
	 *  costPrice, padded to 8 characters (including period);
	 *  salePrice, padded to 8 characters (including period);
	 *  category, padded to 20 characters;
	 *  and this Product's quantitySold, padded to 5 characters;
	 *  each delimited by a pipe symbol.
	 */
	@Override
	public String toString() {
		String toReturn = "";
		toReturn = String.format("%-30s|%-15.2f|%-15.2f|%-20s|%-15d", this.name, this.costPrice, this.salePrice, this.category, this.quantitySold);
		//toReturn = String.format("%-5d", this.ID);
		return toReturn;
	}
	
	public static void main(String[] args) {
		Product prod1 = new Product("TEst1", 100.00f, 120.00f, 100, "Something", 0);
		System.out.println(prod1);
		Product prod2 = new Product("Test product", 10.00f, 25f, "TV");
		System.out.println(prod2);
		Product prod3 = new Product("Another product", 11.00f, 24f, "Radio");
		prod3.incrementQuantitySold();
		System.out.println(prod3);
	}
}
