package invmanger;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * 
 * @author Nick Bishop & Bailey Norman
 *
 */

public class Manager {

	public static void main(String[] args) throws InterruptedException
	{
		Scanner input = new Scanner(System.in);
		int userInt = 10;
		Controller.loadeverything();
		Controller.compoundTotal();
		Controller.clrscr();
		System.out.println("--------------------");
		System.out.println("Inventory Manager");
		System.out.println("--------------------\n");
		Controller.login();
		while(userInt != 0)
		{
			Controller.clrscr();
			System.out.println("--------------------");
			System.out.println("Main Menu");
			System.out.println("--------------------\n");
			
			
			System.out.println("0)  Shut Down");
			System.out.println("1)  Products");
			System.out.println("2)  Employees");
			System.out.println("3)  Customers");
			System.out.println("4)  System Settings");
			System.out.print("\nInput:  ");
			userInt = input.nextInt();
			input.nextLine();
			System.out.print("\n");
			
			//Products
			if(userInt == 1) {
				while(userInt != 0) {
					Controller.clrscr();
					System.out.println("--------------------");
					System.out.println("Products");
					System.out.println("--------------------\n");
					System.out.println("0) Exit to main menu");
					System.out.println("1) View All Products");
					System.out.println("2) View Understocked Products");
					System.out.println("3) Add Products");
					System.out.println("4) Edit Product Details");
					System.out.println("5) Delete Products");
					System.out.println("6) Warehouse");
					System.out.print("\nInput:  ");
					userInt = input.nextInt();
					input.nextLine();
					//VIEW ALL PRODUCTS ------------------------------------------------------------------------
					if(userInt == 1) {
						Controller.viewProducts();
					}
					//VIEW UNDERSTOCKED PRODUCTS ------------------------------------------------------------------------
					else if(userInt == 2) {
						Controller.viewUnderstockedProducts();
					}
					//ADD NEW PRODUCT ------------------------------------------------------------------------
					else if(userInt == 3) {
						Controller.addProduct();
						Data.saveProduct();
						Data.saveIDCounter(Data.productArr.size()-1);
						Data.saveWareHouse();
					}
					//EDIT PRODUCT ------------------------------------------------------------------------
					else if(userInt == 4) {
						Controller.clrscr();
						if(Data.productArr.isEmpty()) {
							System.out.println("You need to add a Product before you can edit it's details.");
							Controller.pressAny();
						}
						else {
							System.out.printf("%-33s|%-15s|%-15s|%-20s|%-15s","   Name","Cost","Price","Category","Amount Sold");
							System.out.print("\n");
							Controller.displayTable(Data.productArr);
							System.out.print("\nPlease select a Product you would like to edit.\nNumber: ");
							Integer num = input.nextInt();
							while(userInt != 5) {
								Controller.clrscr();
								System.out.println("--------------------");
								System.out.println("Choose an Option to edit");
								System.out.println("--------------------\n");
								System.out.println("0) Current Name:  "+ Data.productArr.get(num).getName());
								System.out.println("1) Current Cost Price:  " + Data.productArr.get(num).getCostPrice());
								System.out.println("2) Current Sale Price:  " + Data.productArr.get(num).getSalePrice());
								System.out.println("3) Current Category:  " + Data.productArr.get(num).getCategory());
								System.out.println("4) Current Quanity Sold:  " + Data.productArr.get(num).getQuantitySold());
								System.out.println("5) Finish editing");
								System.out.println("\nInput:  ");
								userInt = input.nextInt();
								Controller.editProductDetails(userInt, num);
							}
							Data.saveProduct();
						}
					}
					//DELETE PRODUCTS ------------------------------------------------------------------------
					else if(userInt == 5) {
						Controller.deleteProduct(userInt);
						Data.saveProduct();
						Data.saveIDCounter(Data.productArr.size()-1);
					}
					//WAREHOUSES ------------------------------------------------------------------------
					else if(userInt == 6) {
						while(userInt != 2) {
							Controller.clrscr();
							System.out.println("--------------------");
							System.out.println("Warehouse");
							System.out.println("--------------------\n");
							System.out.println("0) Add Warehouse");
							System.out.println("1) Add Stock");
							System.out.println("2) Return to Products menu");
							System.out.print("\nInput:  ");
							userInt = input.nextInt();
							input.nextLine();
							if(userInt == 0) {
								Controller.clrscr();
								System.out.println("--------------------");
								System.out.println("Adding Warehouse");
								System.out.println("--------------------\n");
								Controller.addWarehouse();
								Data.saveWareHouse();
							}
							else if(userInt == 1) {
								Controller.clrscr();
								System.out.println("--------------------");
								System.out.println("Adding Stock");
								System.out.println("--------------------\n");
								Controller.addStock();
								Data.saveWareHouse();
							}
						}
					}					
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}

			
			//Employees-------------------------------------------------------------------------------
			else if(userInt == 2) {
				while(userInt != 0) {
					Controller.clrscr();
					System.out.println("--------------------");
					System.out.println("Employees");
					System.out.println("--------------------\n");
					System.out.println("0) Exit to main menu");
					System.out.println("1) Add Employee");
					System.out.println("2) Remove Employee");
					System.out.println("3) View Employee Sales");
					System.out.println("4) Edit Employee Details");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					
					//Add new employee--------------------------------------------------------------------------------------
					if(userInt == 1) {
						Controller.clrscr();
						System.out.println("--------------------");
						System.out.println("Adding New Employee");
						System.out.println("--------------------\n");
						Controller.addEmployee();
						Data.saveEmployee();
					}
					//Remove employee --------------------------------------------------------------------------------------
					else if(userInt == 2 ) {
						Controller.clrscr();
						if(Data.employeeArr.isEmpty()) {
							System.out.println("You need to add a Employee before you can Remove one.");
							Controller.pressAny();
						}
						else {
							System.out.println("--------------------");
							System.out.println("Removing Employee");
							System.out.println("--------------------\n");
							Controller.deleteEmployee();
							Data.saveEmployee();
						}
					}
					//Employee Sales -------------------------------------------------------------------------------------------
					else if(userInt == 3) {
						Controller.clrscr();
						if(Data.employeeArr.isEmpty()) {
							System.out.println("You need to add a Employee before you can view their sales.");
							Controller.pressAny();
						}
						else {
							System.out.println("--------------------");
							System.out.println("Employee's Sales");
							System.out.println("--------------------\n");
							Controller.viewEmployeeSales();
						}
					}
					//Edit Employee -------------------------------------------------------------------------------------------------
					else if(userInt == 4) {
						Controller.clrscr();
						if(Data.employeeArr.isEmpty()) {
							System.out.println("You need to add a Employee before you can edit their details.");
							Controller.pressAny();
						}
						else {
							System.out.printf("%-32s|%-11s|%-10s|%-1s","Name","Phone","Commi.","Total Sales");
							System.out.print("\n");
							Controller.displayTable(Data.employeeArr);
							System.out.print("\nPlease select a Employee you would like to edit.\nNumber: ");
							Integer num = input.nextInt();
							while(userInt != 3) {
								Controller.clrscr();
								System.out.println("--------------------");
								System.out.println("Choose an Option to edit");
								System.out.println("--------------------\n");
								System.out.println("0) Current Name:  "+ Data.employeeArr.get(num).getName());
								System.out.println("1) Current Phone:  " + Data.employeeArr.get(num).getPhone());
								System.out.println("2) Current Commission:  " + Data.employeeArr.get(num).getCommission());
								System.out.println("3) Finish editing");
								System.out.println("\nInput:  ");
								userInt = input.nextInt();
								Controller.editEmployeeDetails(userInt, num);
								Data.saveEmployee();
							}
						}
					}
					}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			
			
			//Customers-----------------------------------------------------------------------------
			else if(userInt == 3) {
				while(userInt != 0) {
					Controller.clrscr();
					System.out.println("--------------------");
					System.out.println("Customers");
					System.out.println("--------------------\n");
					System.out.println("0) Exit to main menu");
					System.out.println("1) Add Customer");
					System.out.println("2) Edit Customer Details");
					System.out.println("3) Create Invoice");
					System.out.println("4) View Invoice");
					System.out.println("5) View Active Invoices");
					System.out.println("6) View Archived Invoices");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					
					//Add New Customer--------------------------------------------------------------------------------
					if(userInt == 1) {
						Controller.clrscr();
						System.out.println("--------------------");
						System.out.println("Adding New Customer");
						System.out.println("--------------------\n");
						System.out.print("What is the Customer's Name?\nName: ");
						Controller.addCustomer();
						Data.saveCustomer();
					}
					//Edit Customer-------------------------------------------------------------------------------------------
					else if(userInt == 2) {
						Controller.clrscr();
						if (Data.customerArr.isEmpty()) {
							System.out.println("You need to add a Customer before you can edit one.");
							Controller.pressAny();
						}
						else {
							System.out.printf("%-33s|%-11s|%-1s|%-5s|%-5s","Name","Phone","Sales Tax.", "Suspension Status", "Active Status");
							System.out.print("\n");
							Controller.displayTable(Data.customerArr);
							System.out.print("\nPlease select a Customer you would like to edit.\nNumber: ");
							Integer num = input.nextInt();
							while(userInt != 4) {
								Controller.clrscr();
								System.out.println("--------------------");
								System.out.println("Choose an Option to change");
								System.out.println("--------------------\n");
								System.out.println("0) Current Name:  " + Data.customerArr.get(num).getName());
								System.out.println("1) Current Phone:  " + Data.customerArr.get(num).getPhone());
								System.out.println("2) Current Suspension Status:  " + Data.customerArr.get(num).getSuspensionStatus());
								System.out.println("3) Current Active Status:  " + Data.customerArr.get(num).getActiveStatus());
								System.out.println("4) Finished editing");
								System.out.println("\nInput:  ");
								userInt = input.nextInt();
								Controller.editCustomerDetails(userInt, num);
								Data.saveCustomer();
							}
						}
					}
					//Create Invoice---------------------------------------------------------------------------------------------
					else if(userInt == 3) {
						Controller.clrscr();
						if(Data.productArr.isEmpty()) {
							System.out.println("You must create a Product before you can create an Invoice");
							Controller.pressAny();
						}
						else if(Data.employeeArr.isEmpty()) {
							System.out.println("You must create a Employee before you can create an Invoice");
							Controller.pressAny();
						}
						else if(Data.customerArr.isEmpty()) {
							System.out.println("You must create a Customer before you can create an Invoice");
							Controller.pressAny();
						}
						else {
							Controller.clrscr();
							System.out.println("--------------------");
							System.out.println("Creating Invoice");
							System.out.println("--------------------\n");
							Controller.addInvoice(userInt);
							Data.saveInvoice();							
						}
					}
					//viewing invoices---------------------------------------------------------------------------
					else if(userInt == 4) {
						Controller.clrscr();
						if(Data.invoiceArr.isEmpty()){
							System.out.println("You must create an Invoice before you can view one.");
						}
						System.out.println("--------------------");
						System.out.println("Viewing Invoices");
						System.out.println("--------------------\n");
						System.out.println("Invoices---------------------------------------------");
						String n = "";
						Controller.displayTable(Data.invoiceArr);
						System.out.print("Please select an invoice to view\nNumber:  ");
						Integer num = input.nextInt();
						while(!n.equals("n") || !n.equals("N"))
						{
							n = "";
							Controller.clrscr();
							System.out.printf("%-15s|%-15s|%-20s|%-20s|%-20s|%-30s", "Total Cost", "Date Issued", "customer", "Sales Person", "DeliveryCost", "Address");
							System.out.print("\n" +Data.invoiceArr.get(num));
							System.out.println("\nAttached Products");
							Controller.printinvoicePTable(num);
							System.out.println("\nAttacked Recipts");
							Controller.printinvoiceRTable(num);
							if(n.equals("Y") || n.equals("y")) {
								while(userInt != 0) {
									System.out.println("--------------------");
									System.out.println("Adding Product/Receipt");
									System.out.println("--------------------\n");
									System.out.println("0) Return to Invoice");
									System.out.println("1) Add Product");
									System.out.println("2) Add Receipt");
									input.nextInt();
									if(userInt == 1) {
										float cost = 0;
										while(userInt != Data.productArr.size()) {
											Controller.clrscr();
											System.out.println("Please select a product from the list to add to the invoice");
											System.out.println("Products-----------------------------------------------\n");
											System.out.printf("%-30s|%-15s|%-15s|%-20s|%-15s","Name","Cost","Price","Category","Amount Sold");
											Controller.displayTable(Data.productArr);
											System.out.println("-------------------------------------------------------");
											System.out.println("Enter " + Data.productArr.size() + " to finish adding Products.\nNumber:  ");
											Integer one = input.nextInt();
											if(userInt >= Data.productArr.size() && userInt < Data.productArr.size()) {
												Data.invoiceArr.get(num).addProduct(Data.productArr.get(one));
												cost = cost + Data.productArr.get(one).getSalePrice();
											}
											else{
												Data.invoiceArr.get(num).setTotalCost(Data.invoiceArr.get(num).getCurrentCost() + cost);
												Controller.clrscr();
												System.out.println("Invaild input, please enter a Product number.");
												Controller.pressAny();
											}
										}
									}
									if(userInt == 2) {
										Controller.clrscr();
										LocalDate currentDate = LocalDate.now();
										System.out.println("What is the total for this receipt:  ");
										Float total = input.nextFloat();
										Data.invoiceArr.get(num).addreceipt(total, currentDate);
									}
								}
							}
							else if(n.equals("") || n.equals("")) {
								System.out.print("\nWould you like to add a receipt or product?\n(Y/N):  ");
								n = input.next();
								input.nextLine();
							}
							else {
								Controller.clrscr();
								System.out.println("Invalid Input");
								Controller.pressAny();
							}
						}
					}
					//View Active Invoices------------------------------------------------------------------------
					else if(userInt == 5) {
						if(Data.invoiceArr.isEmpty()) {
							System.out.println("You need to create an Invoice before you can view them.");
							Controller.pressAny();
						}
						else {
							Controller.clrscr();
							System.out.println("--------------------");
							System.out.println("Viewing Active Invoices");
							System.out.println("--------------------\n");
							System.out.println("Showing All Active invoice in File System.");
							Controller.viewActiveInvoices();
						}
					}
					//Viewing Archived Invoices--------------------------------------------------------------------
					else if(userInt == 6) {
						if(Data.invoiceArr.isEmpty()) {
							System.out.println("You need to create an Invoice before you can view them.");
							Controller.pressAny();
						}
						else {
							Controller.clrscr();
							System.out.println("--------------------");
							System.out.println("Viewing Archived Invoices");
							System.out.println("--------------------\n");
							System.out.println("Showing All Active invoice in File System.");
							Controller.viewArchivedInvoices();
						}
					}
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			//System settings-----------------------------------------------------------------------------------------
			else if(userInt == 4) {
				while(userInt != 0) {
					Controller.clrscr();
					System.out.println("--------------------");
					System.out.println("System Settings");
					System.out.println("--------------------\n\n");
					System.out.println("0) Exit To Main Menu");
					System.out.println("1) Change Password");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					if(userInt == 1) {
						Controller.clrscr();
						Boolean in = false;
						while(in != true) {
							System.out.print("Please enter your Current Password:  ");
							String pass = input.next();
							in = Controller.passwordValidation(pass);
						}
						System.out.print("/nNew Password: ");
						System.out.print("Please enter a new password:  ");
						String newpass = input.next();
						Controller.setPassword(newpass);
					}
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			
			//closing program
			else if(userInt == 0) 
			{
				System.out.println("Shutting Down");
				
			}
			//invalid command
			else 
			{
				System.out.println("Invalid command\n");
			}
			
		}
		
		
		input.close();	
	}
}