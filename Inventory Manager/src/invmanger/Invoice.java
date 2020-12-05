package invmanger;
import java.io.Serializable;
import java.util.*;

/**
 * Represents an invoice which contains a customers purchase and payment information.
 * @author Bailey Norman
 */
public class Invoice implements Serializable {
	private List<Float> receiptList;
	private List<Product> productList;
	private float totalCost;
	private Date dateIssued;
	private Employee salesPerson;
	private boolean delivery;
	private float deliveryCost;
	private String address;
	
	/**
	 * Default constructor
	 * @param receiptList    a list containing all the payments made by the customer to pay off the invoice. 
	 * @param productList    a list containing all the products being pruchased by the customer for this invoice. 
	 * @param totalCost   the total Cost of all products purchased by the customer for this invoice.
	 * @param dateIssued  the date which the invoice was issued to the customer.
	 * @param salesPerson   the salesPerson who made the sale to the customer.
	 * @param delivery    a boolean representing if the products are being delivered to the customer.
	 * @param deliveryCost    a float representing the fee associated with the delivery the products to the customer.
	 * @param deliveryCost    a string representing address which the products are to be deliverd to.
	 */
	public Invoice(List<Float> receiptList, List<Product> productList, float totalCost, Date dateIssued, Employee salesPerson, boolean delivery, float deliveryCost, String address) {
		this.setreceiptList(receiptList);
		this.setProductList(productList);
		this.setTotalCost(totalCost);
		this.setDateIssued(dateIssued);
		this.setSalesPerson(salesPerson);
		this.setDelivery(delivery);
		this.setDeliveryCost(deliveryCost);
		this.setAddress(address);
	}
	
	/**
	 * With-Delivery constructor
	 * @param receiptList    a list containing all the payments made by the customer to pay off the invoice. 
	 * @param productList    a list containing all the products being pruchased by the customer for this invoice. 
	 * @param totalCost   the total Cost of all products purchased by the customer for this invoice.
	 * @param dateIssued  the date which the invoice was issued to the customer.
	 * @param salesPerson   the salesPerson who made the sale to the customer.
	 * @param deliveryCost    a float representing the fee associated with the delivery the products to the customer.
	 * @param adress    a string representing address which the products are to be deliverd to.
	 */
	public Invoice(List<Float> receiptList, List<Product> productList, float totalCost, Date dateIssued, Employee salesPerson, float deliveryCost, String address) {
		this.setreceiptList(receiptList);
		this.setProductList(productList);
		this.setTotalCost(totalCost);
		this.setDateIssued(dateIssued);
		this.setSalesPerson(salesPerson);
		this.setDelivery(true);
		this.setDeliveryCost(deliveryCost);
		this.setAddress(address);
	}
	
	/**
	 * Without-Delivery constructor, 
	 * @param receiptList    a list containing all the payments made by the customer to pay off the invoice. 
	 * @param productList    a list containing all the products being pruchased by the customer for this invoice. 
	 * @param totalCost   the total Cost of all products purchased by the customer for this invoice.
	 * @param dateIssued  the date which the invoice was issued to the customer.
	 * @param salesPerson   the salesPerson who made the sale to the customer.
	 */
	public Invoice(List<Float> receiptList, List<Product> productList, float totalCost, Date dateIssued, Employee salesPerson) {
		this.setreceiptList(receiptList);
		this.setProductList(productList);
		this.setTotalCost(totalCost);
		this.setDateIssued(dateIssued);
		this.setSalesPerson(salesPerson);
		this.setDelivery(false);
		this.setDeliveryCost(0);
		this.setAddress("N/A");
	}


	/**
	 * Returns a List containing all the payments made by the customer to pay off the invoice's total.
	 * @return this Invoice's receipt List
	 */
	public List<Float> getreceiptList() {
		return receiptList;
	}

	/**
	 * Sets the receiptList to the list newreceiptList
	 * @param newreceiptList new List value to set the invoice's receiptList to
	 */
	public void setreceiptList(List<Float> newreceiptList) {
		this.receiptList = newreceiptList;
	}

	/**
	 * Returns a List containg all of the products purchased by the customer for this invoice.
	 * @return the Invoice's product list
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * Sets the productList to the list newproductList
	 * @param newproductList new List value to set invoice's product to
	 */
	public void setProductList(List<Product> newproductList) {
		this.productList = newproductList;
	}

	/**
	 * Returns a float representing the total cost of the invoice.
	 * @return the total cost of the products being purchaed;
	 */
	public float getTotalCost() {
		return totalCost;
	}

	/**
	 * Sets the totalcost to the float newtotalCost
	 * @param newtotalCost new float value to set the invoice's totalCost to
	 */
	public void setTotalCost(float newtotalCost) {
		this.totalCost = newtotalCost;
	}

	/**
	 * Returns a date representing the date in which the invoice was issued.
	 * @return the date in which the invoice was issued.
	 */
	public Date getDateIssued() {
		return dateIssued;
	}

	/**
	 * Sets the dateIssued to the date newdateIssued
	 * @param newdateIssued new date value to set dateIssued to
	 */
	public void setDateIssued(Date newdateIssued) {
		this.dateIssued = newdateIssued;
	}

	/**
	 * Returns the Employee who made the sale.
	 * @return the Employee who made the sale.
	 */
	public Employee getSalesPerson() {
		return salesPerson;
	}

	/**
	 * Sets the salesPerson to the Employee newsalesPerson
	 * @param newsalesPerson new employee to set salesPerson to
	 */
	public void setSalesPerson(Employee newsalesPerson) {
		this.salesPerson = newsalesPerson;
	}

	/**
	 * Returns the boolean for if there is a delivery
	 * @return the boolean for if there is a delivery.
	 */
	public boolean isDelivery() {
		return delivery;
	}

	/**
	 * Sets the delivery to the boolean newDelivery
	 * @param newDelivery new boolean to set the delivery to
	 */
	public void setDelivery(boolean newDelivery) {
		this.delivery = newDelivery;
	}

	/**
	 * Returns the cost of delivery as a float.
	 * @return the cost of the delivery if there is one.
	 */
	public float getDeliveryCost() {
		return deliveryCost;
	}

	/**
	 * Sets the deliveryCost to the float newdeliveryCost
	 * @param newdeliveryCost new deliveryCost to set the deliveryCost to
	 */
	public void setDeliveryCost(float newdeliveryCost) {
		this.deliveryCost = newdeliveryCost;
	}

	/**
	 * Returns the delivery address as a string.
	 * @return the address where the products are to be delivered to
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the Address to the string newAdress
	 * @param newAddress new address to set the adress to
	 */
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	/**
	 * Adds a receipt to the list of receipts for a given invoice.
	 * @param receipt the receipt that will be added to receiptList
	 */
	public void addreceipt(float receipt) {
		receiptList.add(receipt);
	}


}
