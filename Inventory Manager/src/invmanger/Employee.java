package invmanger;

public class Employee {
	private float commission;
	private String name;
	private String phone;
	private float totalSales;
	
	/**
	 * Default constructor, requires specification of sales.
	 * @param comission    a decimal representing the comission percentage that an employee will recieve on a sale.
	 * @param name   the name of this Employee.
	 * @param phone  the phone number used to contact this Employee remotely.
	 * @param totalSales   a float representing the sales total made by this Employee.
	 */
	public Employee(float commission, String name, String phone, float totalSales) {
		this.commission = commission;
		this.name = name;
		this.phone = phone;
		this.totalSales = totalSales;
	}

	/**
	 * Standard-use constructor, assumes that the Employee has not made any sales.
	 * @param commision    a decimal representing the comission percentage that an employee will recieve on a sale.
	 * @param name   the name of this Employee.
	 * @param phone  the phone number used to contact this Employee remotely.
	 */
	public Employee(float commission, String name, String phone) {
		this.commission = commission;
		this.name = name;
		this.phone = phone;
		this.totalSales = 0;
	}
	
	/**
	 * Sets this Employee's commission to the float newCommission.
	 * @param newCommission new float value for the Employee's commission.
	 */
	public void setCommission(float newCommission) {
		this.commission = newCommission;
	}
	
	/**
	 * Returns this Employee's commission as a float.
	 * @return this Employee's commission as a decimal value.
	 */
	public float getCommission() {
		return this.commission;
	}
	
	/**
	 * Sets this Employee's name to the String newName.
	 * @param newName new String value to set the Employee's name to.
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Returns this Employee's name as a String.
	 * @return this Employee's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets this Employee's phone to the String newPhone.
	 * @param newPhone new String value to set the Employee's phone to.
	 */
	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}
	
	/**
	 * Returns this Employee's phone number as a String
	 * @return this Employee's phone.
	 */
	public String getPhone() {
		return this.phone;
	}
	
	
	/**
	 * Sets this Employee's total sales to the float newSales.
	 * @param newSales new float value to set the Employee's commision to.
	 */
	public void setSales(float newSales) {
		this.totalSales = newSales;
	}
	
	/**
	 * Returns this Employee's total sales as a float
	 * @return this Employee's total sales.
	 */
	public float getSales() {
		return this.totalSales;
	}
	
	//Override toString for Employee
	public String toString() {
		String toReturn = "";
		toReturn = String.format("%-30s|%-11s|%-1.3f|%-1.3f", this.name, this.phone, this.commission, this.totalSales);
		return toReturn;
	}
}
