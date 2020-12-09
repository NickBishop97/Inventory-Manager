package invmanger;
import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

/**
 * Represents an invoice which contains a customers purchase and payment information.
 * @author Bailey Norman
 */
public class Invoice implements Serializable {
	private List<Float> receiptAmounts;
	private List<LocalDate> receiptDates;
	private List<Product> productList;
	private float totalCost;
	private LocalDate dateIssued;
	private Employee salesPerson;
	private boolean delivery;
	private float deliveryCost;
	private String address;
	private boolean activeStatus;
	
	/**
	 * Default constructor
	 * @param receiptAmounts    a list containing all the amounts paid by the customer for each receipt. 
	 * @param receiptDates		a list containing all of the dates on which the receipts were made.
	 * @param productList    a list containing all the products being pruchased by the customer for this invoice. 
	 * @param totalCost   the total Cost of all products purchased by the customer for this invoice.
	 * @param dateIssued  the date which the invoice was issued to the customer.
	 * @param salesPerson   the salesPerson who made the sale to the customer.
	 * @param activeStatus		boolean which is true if the invoice is active and false if the invoice is archived.
	 * @param delivery    a boolean representing if the products are being delivered to the customer.
	 * @param deliveryCost    a float representing the fee associated with the delivery the products to the customer.
	 * @param deliveryCost    a string representing address which the products are to be deliverd to.
	 */
	public Invoice(List<Float> receiptAmounts, List<LocalDate> receiptDates, List<Product> productList, float totalCost, LocalDate dateIssued, Employee salesPerson, boolean delivery, boolean activeStatus, float deliveryCost, String address) {
		this.setreceiptAmounts(receiptAmounts);
		this.setreceiptDates(receiptDates);
		this.setProductList(productList);
		this.setTotalCost(totalCost);
		this.setDateIssued(dateIssued);
		this.setSalesPerson(salesPerson);
		this.setActiveStatus(activeStatus);
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
	public Invoice(List<Product> productList, float totalCost, LocalDate dateIssued, Employee salesPerson, float deliveryCost, String address) {
		this.setProductList(productList);
		this.setTotalCost(totalCost);
		this.setDateIssued(dateIssued);
		this.setSalesPerson(salesPerson);
		this.setDelivery(true);
		this.setDeliveryCost(deliveryCost);
		this.setAddress(address);
		this.setActiveStatus(true);
	}
	
	/**
	 * Without-Delivery constructor, 
	 * @param receiptList    a list containing all the payments made by the customer to pay off the invoice. 
	 * @param productList    a list containing all the products being purchased by the customer for this invoice. 
	 * @param totalCost   the total Cost of all products purchased by the customer for this invoice.
	 * @param dateIssued  the date which the invoice was issued to the customer.
	 * @param salesPerson   the salesPerson who made the sale to the customer.
	 */
	public Invoice(List<Product> productList, float totalCost, LocalDate dateIssued, Employee salesPerson) {
		this.setProductList(productList);
		this.setTotalCost(totalCost);
		this.setDateIssued(dateIssued);
		this.setSalesPerson(salesPerson);
		this.setDelivery(false);
		this.setDeliveryCost(0);
		this.setAddress("N/A");
		this.setActiveStatus(true);
	}


	/**
	 * Returns a List containing all the payments made by the customer to pay off the invoice's total.
	 * @return this Invoice's receipt List
	 */
	public List<Float> getreceiptAmounts() {
		return receiptAmounts;
	}

	/**
	 * Sets the receiptList to the list newreceiptList
	 * @param newreceiptList new List value to set the invoice's receiptList to
	 */
	public void setreceiptAmounts(List<Float> newreceiptAmounts) {
		this.receiptAmounts = newreceiptAmounts;
	}
	
	/**
	 * Sets the receiptList to the list newreceiptList
	 * @param newreceiptList new List value to set the invoice's receiptList to
	 */
	public void setreceiptDates(List<LocalDate> newreceiptDates) {
		this.receiptDates = newreceiptDates;
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
	public LocalDate getDateIssued() {
		return dateIssued;
	}

	/**
	 * Sets the dateIssued to the date newdateIssued
	 * @param newdateIssued new date value to set dateIssued to
	 */
	public void setDateIssued(LocalDate newdateIssued) {
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
	 * @param newAddress new address to set the address to
	 */
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	/**
	 * Adds a receipt to the list of receipts for a given invoice.
	 * @param receipt the receipt that will be added to receiptList
	 */
	public void addreceipt(float receiptAmount, LocalDate receiptDate) {
		receiptAmounts.add(receiptAmount);
		receiptDates.add(receiptDate);
	}
	
	public String showreceiptTable() {
		String toReturn = "";
		toReturn = String.format("%nReceipts:%n%-15s|%-15s", "Date", "Amount Paid");
	    for (int i = 0; i < receiptAmounts.size(); i++) {
	    	
	    	toReturn += "\n" + receiptDates.get(i) + "|" + receiptAmounts.get(i);
	    }
		return toReturn;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	public void updateActiveStatus() {
		float totalPaid = 0;
		for(int i = 0; i < receiptAmounts.size(); i++) {
			totalPaid = totalPaid + receiptAmounts.get(i);
		}
		if(totalPaid >= this.totalCost) {
			setActiveStatus(true);
		}
		else {
			setActiveStatus(false);
		}
	}
	public String showproductTable() {
        String toReturn = "";
        toReturn = String.format("%Products:%n%-20s|%-15s|%-15.2f", "Product Name", "Product ID", "Product Price");
        for (int i = 0; i < productList.size(); i++) {

            toReturn += "\n" + productList.get(i).getName() + "|" + productList.get(i).getID() + productList.get(i).getSalePrice();
        }
        return toReturn;
    }
	@Override
	public String toString() {
	    String toReturn = "";
	    toReturn = String.format("%-15.2f|%-15s|%-20s|%-20.2f|%-30s", this.totalCost, this.dateIssued.toString(), this.salesPerson.getName(), this.deliveryCost, this.address);
	    return toReturn;
	}
}
