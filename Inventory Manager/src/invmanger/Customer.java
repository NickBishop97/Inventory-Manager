package invmanger;

/**
 * Represents a Customer buying from the client's store.
 * @author Alexander Dung
 */
/**
 * @author Us3r
 *
 */
public class Customer {
	private float salesTax;
	private String name;
	private String phone;
	private boolean suspensionStatus;
	private boolean activeStatus;
	
	/**
	 * Default constructor, requires specification of suspension and activity status.
	 * @param tax    a decimal representing the sales tax that should be applied to this Customer's purchases. 
	 * @param name   the name of this Customer.
	 * @param phone  the phone number used to contact this Customer remotely.
	 * @param susp   a boolean representing whether this Customer has been suspended for delinquency.
	 * @param act    a boolean representing whether this Customer is an active customer.
	 */
	public Customer(float tax, String name, String phone, boolean susp, boolean act) {
		this.salesTax = tax;
		this.name = name;
		this.phone = phone;
		this.suspensionStatus = susp;
		this.activeStatus = act;
	}

	/**
	 * Standard-use constructor, assumes that the Customer is not suspended and is active.
	 * @param tax    a decimal representing the sales tax that should be applied to this Customer's purchases. 
	 * @param name   the name of this Customer.
	 * @param phone  the phone number used to contact this Customer remotely.
	 */
	public Customer(float tax, String name, String phone) {
		this.salesTax = tax;
		this.name = name;
		this.phone = phone;
		this.suspensionStatus = false;
		this.activeStatus = true;
	}
	
	/**
	 * Sets this Customer's salesTax to the float newTax.
	 * @param newTax new float value to set the Customer's salesTax to.
	 */
	public void setSalesTax(float newTax) {
		this.salesTax = newTax;
	}
	
	/**
	 * Returns this Customer's salesTax as a float.
	 * @return this Customer's sales tax percentage as a decimal value.
	 */
	public float getSalesTax() {
		return this.salesTax;
	}
	
	/**
	 * Sets this Customer's name to the String newName.
	 * @param newName new String value to set the Customer's name to.
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Returns this Customer's name as a String.
	 * @return this Customer's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets this Customer's phone to the String newPhone.
	 * @param newPhone new String value to set the Customer's phone to.
	 */
	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}
	
	/**
	 * Returns this Customer's phone number as a String
	 * @return this Customer's phone.
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Inverts this Customer's suspensionStatus.
	 */
	public void flipSuspensionStatus() {
		this.suspensionStatus = !this.suspensionStatus;
	}
	
	/**
	 * Returns a boolean representing whether this Customer is suspended or not.
	 * @return this Customer's suspensionStatus.
	 */
	public boolean getSuspensionStatus() {
		return this.suspensionStatus;
	}
	
	/**
	 * Inverts this Customer's activeStatus.
	 */
	public void flipActiveStatus() {
		this.activeStatus = !this.activeStatus;
	}
	
	/**
	 * Returns a boolean representing whether this Customer is active or not.
	 * @return this Customer's activeStatus.
	 */
	public boolean getActiveStatus() {
		return this.activeStatus;
	}
	
	public String toString() {
		String toReturn = "";
		toReturn = String.format("%-30s|%-11s|%-1.3f|%-5b|%-5b", this.name, this.phone, this.salesTax, this.suspensionStatus, this.activeStatus);
		return toReturn;
	}
	
	public static void main(String[] args) {
		Customer test = new Customer(0.01f, "Customer1", "1111111111", true, false);
		System.out.println(test);
		Customer test1 = new Customer(0.2f, "Customer1aaaaaaaaaaaaaaaaa", "1111111111");
		System.out.println(test1);
		Customer test2 = new Customer(0.001f, "Customer", "5555555555");
		System.out.println(test2);
		test2.flipActiveStatus();
		test2.flipSuspensionStatus();
		test2.setSalesTax(1.01f);
		test2.setName("Leroy Jenkins");
		test2.setPhone("8885558888");
		System.out.println(test2);
		System.out.println(test2.getActiveStatus());
		System.out.println(test2.getSuspensionStatus());
	}
}
