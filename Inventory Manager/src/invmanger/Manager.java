package invmanger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
		clrscr();
		checkPassword();
		while(userInt != 0)
		{
			clrscr();
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
					clrscr();
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
					if(userInt == 1) {
						clrscr();
						if(Data.productArr.isEmpty()) {
							System.out.println("You must add a Product before you can view them");
							pressAny();
						}
						else {
							System.out.println("--------------------");
							System.out.println("View All Products");
							System.out.println("--------------------\n");
							displayTablenonum(Data.warehouseArr);
							pressAny();
						}
					}
					else if(userInt == 2) {
						clrscr();
						if(Data.productArr.isEmpty()) {
							System.out.println("You must add a Product before you can view understocked products");
							pressAny();
						}
						else {
							System.out.println("--------------------");
							System.out.println("Understocked Products");
							System.out.println("--------------------\n");
							for (int i = 0; i < Data.warehouseArr.size(); i++) {
								Data.warehouseArr.get(i).listLowStock();
								System.out.print("\n");
							}
							pressAny();
						}
					}
					else if(userInt == 3) {
						clrscr();
						if(Data.warehouseArr.isEmpty()) {
							System.out.println("You must add a Warehouse before you can add a Product.");
							pressAny();
						}
						else {
							System.out.println("--------------------");
							System.out.println("Adding New Products");
							System.out.println("--------------------\n");
							System.out.print("Please enter Product's Name.\nName: ");
							String pname = input.nextLine();
							System.out.print("\nPlease enter Cost Price\nCost Price: ");
							Float pcost = input.nextFloat();
							input.nextLine();
							System.out.print("\nPlease enter Sale Price\nSale Price: ");
							Float psale = input.nextFloat();
							input.nextLine();
							System.out.print("\nPlease enter Category Name?\nCategory:  ");
							String pcat = input.nextLine();
							System.out.print("\nPlease enter Avaliabe Stock.\nStock:  ");
							Integer stock = input.nextInt();
							System.out.print("\n");
							displayTable(Data.warehouseArr);
							System.out.print("\n");
							System.out.print("\nPlease select the Warehouse that this product is located at.\nNumber:  ");
							Integer ware = input.nextInt();
							System.out.print("\n");
							Product prod = new Product(pname, pcost, psale, pcat);
							System.out.printf("%-30s|%-15s|%-15s|%-20s|%-15s|%-15s","Name","Cost","Price","Category","Amount Sold", "Warehouse");
							System.out.print("\n");
							System.out.println(prod + "|" + Data.warehouseArr.get(ware).getWarehouseID());
							System.out.print("\nDoes this information look correct? (Y/N)  ");
							String h = input.next();
							if(h.equals("Y") || h.equals("y")) {
								Data.productArr.add(prod);
								Data.warehouseArr.get(ware).addProduct(Data.productArr.size()-1);
								Data.warehouseArr.get(ware).increaseStock(Data.productArr.size()-1, stock);
								System.out.println("New Product has been added to the file system.");
								pressAny();
							}
						}
					}
					else if(userInt == 4) {
						clrscr();
						if(Data.productArr.isEmpty()) {
							System.out.println("You need to add a Product before you can edit it's details.");
							pressAny();
						}
						else {
							System.out.printf("%-33s|%-15s|%-15s|%-20s|%-15s","   Name","Cost","Price","Category","Amount Sold");
							System.out.print("\n");
							displayTable(Data.productArr);
							System.out.print("\nPlease select a Product you would like to edit.\nNumber: ");
							Integer num = input.nextInt();
							while(userInt != 5) {
								clrscr();
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
								if(userInt == 0) {
									clrscr();
									System.out.print("Please enter the new name for this Product:  ");
									String newname = input.next();
									Data.productArr.get(num).setName(newname);
									System.out.println("Name has successfully been changed to " + newname + "\n");
									System.out.printf("%-30s|%-15s|%-15s|%-20s|%-15s","Name","Cost","Price","Category","Amount Sold");
									System.out.print("\n");
									System.out.println(Data.productArr.get(num) + "\n");
									pressAny();
								}
								if(userInt == 1) {
									clrscr();
									System.out.print("Please enter the new Cost Price for this Product");
									Float newcost = input.nextFloat();
									Data.productArr.get(num).setCostPrice(newcost);
									System.out.println("Cost Price has successfully been changed to " + newcost + "\n");
									System.out.printf("%-30s|%-15s|%-15s|%-20s|%-15s","Name","Cost","Price","Category","Amount Sold");
									System.out.print("\n");
									System.out.println(Data.productArr.get(num) + "\n");
									pressAny();
								}
								if(userInt == 2) {
									clrscr();
									System.out.print("Please enter the new Sale Price for this Product");
									Float newsale = input.nextFloat();
									Data.productArr.get(num).setSalePrice(newsale);
									System.out.println("Sale Price has successfully been changed to " + newsale + "\n");
									System.out.printf("%-30s|%-15s|%-15s|%-20s|%-15s","Name","Cost","Price","Category","Amount Sold");
									System.out.print("\n");
									System.out.println(Data.productArr.get(num) + "\n");
									pressAny();
								}
								if(userInt == 3) {
									clrscr();
									System.out.print("Please enter the new Category for this Product");
									String newcat = input.next();
									Data.productArr.get(num).setCategory(newcat);;
									System.out.println("Category has successfully been changed to " + newcat + "\n");
									System.out.printf("%-30s|%-15s|%-15s|%-20s|%-15s","Name","Cost","Price","Category","Amount Sold");
									System.out.print("\n");
									System.out.println(Data.productArr.get(num) + "\n");
									pressAny();
								}
								if(userInt == 4) {
									clrscr();
									System.out.print("Please enter the new Quanity Sold for this Product");
									Integer newquan = input.nextInt();
									Data.productArr.get(num).setQuantitySold(newquan);
									System.out.println("Quanity Sold has successfully been changed to " + newquan + "\n");
									System.out.printf("%-30s|%-15s|%-15s|%-20s|%-15s","Name","Cost","Price","Category","Amount Sold");
									System.out.print("\n");
									System.out.println(Data.productArr.get(num) + "\n");
									pressAny();
								}
							}
						}
					}
					else if(userInt == 5) {
						clrscr();
						if(Data.productArr.isEmpty()) {
							System.out.println("You must add a Product before you can delete them");
							pressAny();
						}
						else {
							while(userInt != 0) {
								clrscr();
								System.out.println("--------------------");
								System.out.println("Delete Products");
								System.out.println("--------------------\n");
								displayTable(Data.productArr);
								System.out.print("\nPlease select an Number from the list to remove.\nNumber: ");
								Integer num = input.nextInt();
								System.out.print("\nAre you sure you want to delete this Employee?(Y/N)  ");
								String z = input.next();
								if(z.equals("Y") || z.equals("y")) {
									remove(Data.productArr, num);
									System.out.println("Product has been deleted from the File System.");
									pressAny();
								}
							}
						}
					}
					else if(userInt == 6) {
						while(userInt != 2) {
							clrscr();
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
								clrscr();
								System.out.println("--------------------");
								System.out.println("Adding Warehouse");
								System.out.println("--------------------\n");
								System.out.print("What is the warehouse's Name?\nName:  ");
								String wname = input.nextLine();
								System.out.print("\nWhat is the warehouse's Phone#?\nPhone#:  ");
								String wphone = input.nextLine();
								System.out.print("\nWhats is the warehouse's Address?\nAddress:  ");
								String waddress = input.nextLine();
								Warehouse ware = new Warehouse(wname, waddress, wphone);
								Data.warehouseArr.add(ware);
								System.out.println("The Warehouse has been added to the filesystem.");
								pressAny();
							}
							else if(userInt == 1) {
								clrscr();
								System.out.println("--------------------");
								System.out.println("Adding Stock");
								System.out.println("--------------------\n");
								for (int i = 0; i < Data.warehouseArr.size(); i++) {
									System.out.print(i + ") ");
									System.out.print(Data.warehouseArr.get(i).getWarehouseID());
									System.out.print("\n");
								}
								System.out.print("What Warehouse is this product located at.\nNumber:  ");
								Integer ware = input.nextInt();
								clrscr();
								displayTable(Data.productArr);
								System.out.print("\nPlease select the Product you would like to add stock to.\nNumber:  ");
								Integer num = input.nextInt();
								input.nextLine();
								System.out.print("\nHow much stock would you like to add.\nAmount:  ");
								Integer stock = input.nextInt();
								input.nextLine();
								Data.warehouseArr.get(ware).increaseStock(num, stock);
								pressAny();
							}
						}
					}					
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}

			
			//Employees
			else if(userInt == 2) {
				while(userInt != 0) {
					clrscr();
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
					
					if(userInt == 1) {
						clrscr();
						System.out.println("--------------------");
						System.out.println("Adding New Employee");
						System.out.println("--------------------\n");
						System.out.print("Please enter Employee's Name.\nName: ");
						String ename = input.nextLine();
						System.out.print("\nPlease enter Employee's Phone#\nPhone Number: ");
						String ephone = input.nextLine();
						System.out.print("\nPlease enter Employee's Commissions.\nCommissions: ");
						Float commission = input.nextFloat();
						input.nextLine();
						Employee emplo = new Employee(commission, ename, ephone, 0);
						clrscr();
						System.out.printf("%-30s|%-11s|%-10s|%-1s","Name","Phone","Commi.","Total Sales");
						System.out.print("\n");
						System.out.println(emplo);
						System.out.print("\nDoes this information look correct? (Y/N)  ");
						String h = input.next();
						if(h.equals("Y") || h.equals("y")) {
							Data.employeeArr.add(emplo);
							System.out.println("New Employee has been added to the filesystem.");
							pressAny();
						}
						
					}
					else if(userInt == 2 ) {
						clrscr();
						if(Data.employeeArr.isEmpty()) {
							System.out.println("You need to add a Employee before you can Remove one.");
							pressAny();
						}
						else {
							System.out.println("--------------------");
							System.out.println("Removing Employee");
							System.out.println("--------------------\n");
							System.out.printf("%-30s|%-11s|%-10s|%-1s","Name","Phone","Commi.","Total Sales");
							System.out.print("\n");
							displayTable(Data.employeeArr);
							System.out.print("\nPlease select an Number from the list to remove.\nNumber: ");
							Integer num = input.nextInt();
							System.out.print("\nAre you sure you want to delete this Employee?(Y/N)  ");
							String y = input.next();
							if(y.equals("Y") || y.equals("y")) {
								remove(Data.employeeArr, num);
								System.out.println("Employee has been deleted from the File System.");
								pressAny();
							}
						}
					}
					else if(userInt == 3) {
						clrscr();
						if(Data.employeeArr.isEmpty()) {
							System.out.println("You need to add a Employee before you can view their sales.");
							pressAny();
						}
						else {
							System.out.println("--------------------");
							System.out.println("Employee's Sales");
							System.out.println("--------------------\n");
							System.out.printf("%-30s|%-11s","Name","Total Sales");
							System.out.print("\n");
							for (int i = 0; i < Data.employeeArr.size(); i++) {
								System.out.printf("%-30s|%-11s", Data.employeeArr.get(i).getName() ,Data.employeeArr.get(i).getSales());
								System.out.print("\n");
							}
							System.out.print("\n");
							pressAny();
						}
					}
					else if(userInt == 4) {
						clrscr();
						if(Data.employeeArr.isEmpty()) {
							System.out.println("You need to add a Employee before you can edit their details.");
							pressAny();
						}
						else {
							System.out.printf("%-32s|%-11s|%-10s|%-1s","Name","Phone","Commi.","Total Sales");
							System.out.print("\n");
							displayTable(Data.employeeArr);
							System.out.print("\nPlease select a Employee you would like to edit.\nNumber: ");
							Integer num = input.nextInt();
							while(userInt != 3) {
								clrscr();
								System.out.println("--------------------");
								System.out.println("Choose an Option to edit");
								System.out.println("--------------------\n");
								System.out.println("0) Current Name:  "+ Data.employeeArr.get(num).getName());
								System.out.println("1) Current Phone:  " + Data.employeeArr.get(num).getPhone());
								System.out.println("2) Current Commission:  " + Data.employeeArr.get(num).getCommission());
								System.out.println("3) Finish editing");
								System.out.println("\nInput:  ");
								userInt = input.nextInt();
								if(userInt == 0) {
									clrscr();
									System.out.print("Please enter the new name for this Employee:  ");
									String newname = input.nextLine();
									Data.employeeArr.get(num).setName(newname);
									System.out.println("Name has successfully been changed to " + newname + "\n");
									System.out.printf("%-30s|%-11s|%-10s|%-1s","Name","Phone","Commi.","Total Sales");
									System.out.print("\n");
									System.out.println(Data.employeeArr.get(num) + "\n");
									pressAny();
								}
								else if(userInt == 1) {
									clrscr();
									System.out.print("Please enter the new Phone Number for this Employee:  ");
									String newPhone = input.next();
									Data.employeeArr.get(num).setPhone(newPhone);
									System.out.println("Phone Number has successfully been changed to " + newPhone + "\n");
									System.out.printf("%-30s|%-11s|%-10s|%-1s","Name","Phone","Commi.","Total Sales");
									System.out.print("\n");
									System.out.println(Data.employeeArr.get(num) + "\n");
									pressAny();
								}
								else if(userInt == 2) {
									clrscr();
									System.out.print("Please enter the new Commission Number for this Employee:  ");
									Float newcom = input.nextFloat();
									Data.employeeArr.get(num).setCommission(newcom);
									System.out.println("Employee's Commission has successfully been changed to " + newcom + "\n");
									System.out.printf("%-30s|%-11s|%-10s|%-1s","Name","Phone","Commi.","Total Sales");
									System.out.print("\n");
									System.out.println(Data.employeeArr.get(num) + "\n");
									pressAny();
								}
							}
						}
					}
					}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			
			
			//Customers
			else if(userInt == 3) {
				while(userInt != 0) {
					clrscr();
					System.out.println("--------------------");
					System.out.println("Customers");
					System.out.println("--------------------\n");
					System.out.println("0) Exit to main menu");
					System.out.println("1) Add Customer");
					System.out.println("2) Edit Customer Details");
					System.out.println("3) Create Invoice");
					System.out.println("4) View Active Invoices");
					System.out.println("5) View Archived Invoices");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					if(userInt == 1) {
						clrscr();
						System.out.println("--------------------");
						System.out.println("Adding New Customer");
						System.out.println("--------------------\n");
						System.out.print("What is the Customer's Name?\nName: ");
						String cname = input.nextLine();
						System.out.print("What is the Customer's Phone#?\nPhone: ");
						String cphone = input.nextLine();
						Customer cust = new Customer(5, cname, cphone, false, true);
						Data.customerArr.add(cust);
						System.out.println("Customer has successfully been added to the file system.");
						pressAny();
					}
					else if(userInt == 2) {
						clrscr();
						if (Data.customerArr.isEmpty()) {
							System.out.println("You need to add a Customer before you can edit one.");
							pressAny();
						}
						else {
							System.out.printf("%-33s|%-11s|%-1s|%-5s|%-5s","Name","Phone","Sales Tax.", "Suspension Status", "Active Status");
							System.out.print("\n");
							displayTable(Data.customerArr);
							System.out.print("\nPlease select a Customer you would like to edit.\nNumber: ");
							Integer num = input.nextInt();
							while(userInt != 4) {
								clrscr();
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
								if(userInt == 0) {
									clrscr();
									System.out.print("Please enter the new name for this customer:  ");
									String newname = input.nextLine();
									Data.customerArr.get(num).setName(newname);
									System.out.println("Name has successfully been changed to " + newname + "\n");
									System.out.printf("%-30s|%-11s|%-1s|%-5s|%-5s","Name","Phone","Sales Tax.", "Suspension Status", "Active Status");
									System.out.print("\n");
									System.out.println(Data.customerArr.get(num) + "\n");
									pressAny();
								}
								if(userInt == 1) {
									clrscr();
									System.out.print("Please enter the new Phone Number for this customer:  ");
									String newphone = input.next();
									Data.customerArr.get(num).setPhone(newphone);
									System.out.println("Phone Number has successfully been changed to " + newphone + "\n");
									System.out.printf("%-30s|%-11s|%-1s|%-5s|%-5s","Name","Phone","Sales Tax.", "Suspension Status", "Active Status");
									System.out.print("\n");
									System.out.println(Data.customerArr.get(num) + "\n");
									pressAny();
								}
								if(userInt == 2) {
									clrscr();
									System.out.print("Would you like to flip the Suspension Status(Y/N):  ");
									String newsus = input.next();
									if(newsus.equals("y") || newsus.equals("Y")) {
										Data.customerArr.get(num).flipSuspensionStatus();
										System.out.println("SuspensionStatus is now set to " + Data.customerArr.get(num).getSuspensionStatus());
										pressAny();
									}
								}
								if(userInt == 3) {
									clrscr();
									System.out.print("Would you like to flip the Active Status(Y/N):  ");
									String newsus = input.next();
									if(newsus.equals("y") || newsus.equals("Y")) {
										Data.customerArr.get(num).flipActiveStatus();;
										System.out.println("SuspensionStatus is now set to " + Data.customerArr.get(num).getActiveStatus());
										pressAny();
									}
								}
							}
						}
					}
					else if(userInt == 3) {
						clrscr();
						System.out.println("--------------------");
						System.out.println("Creating Invoice");
						System.out.println("--------------------\n");
						List<Product> product =new LinkedList<Product>();
						float cost = 0;
						while(userInt == 4) {
							clrscr();
							System.out.println("Please select a product from the list to add to the invoice");
							displayTable(Data.productArr);
							System.out.println("Enter " + Data.productArr.size() + " to finish entering Products.");
							Integer num = input.nextInt();
							if(userInt < Data.productArr.size()) {
								product.add(Data.productArr.get(num));
								cost = cost + Data.productArr.get(num).getSalePrice();
							}
							else if(userInt == Data.productArr.size()) {
								break;
							}
							else if(userInt > Data.productArr.size()){
								clrscr();
								System.out.println("Invaild input, please enter a Product number.");
								pressAny();
							}
						}
						clrscr();
						System.out.print("Please enter the Month, Day and Year(ex. 01/01/20).\nMonth:  ");
						Integer month = input.nextInt();
						System.out.print("\nDay:  ");
						Integer day = input.nextInt();
						System.out.print("\nYear:  ");
						Integer year = input.nextInt();
						LocalDate date1 = LocalDate.of(year, month, day);
						clrscr();
						displayTable(Data.employeeArr);
						System.out.print("Please select a employee to attach to the Invoice.\nNumber:  ");
						Employee employee = Data.employeeArr.get(input.nextInt());
						Invoice in = new Invoice(product, cost, date1, employee);
						Data.invoiceArr.add(in);
						System.out.print("Invoice has succsusfully been added to the file system.");
						pressAny();
					}
					if(userInt == 4) {
						if(Data.invoiceArr.isEmpty()) {
							System.out.println("You need to create an Invoice before you can view them.");
							pressAny();
						}
						else {
							clrscr();
							System.out.println("--------------------");
							System.out.println("Viewing Active Invoices");
							System.out.println("--------------------\n");
							System.out.print("Showing All Active invoice in File System.");
							displayActiveInvoices();
							pressAny();
						}
					}
					if(userInt == 5) {
						if(Data.invoiceArr.isEmpty()) {
							System.out.println("You need to create an Invoice before you can view them.");
							pressAny();
						}
						else {
							clrscr();
							System.out.println("--------------------");
							System.out.println("Viewing Archived Invoices");
							System.out.println("--------------------\n");
							System.out.print("Showing All Active invoice in File System.");
							displayArchivedInvoices();
							pressAny();
						}
					}
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			//System settings
			else if(userInt == 4) {
				while(userInt != 0) {
					clrscr();
					System.out.println("--------------------");
					System.out.println("System Settings");
					System.out.println("--------------------\n\n");
					System.out.println("0) Exit To Main Menu");
					System.out.println("1) Change Password");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					if(userInt == 1) {
						clrscr();
						Boolean in = false;
						while(in != true) {
							System.out.print("Please enter your Current Password:  ");
							String pass = input.next();
							in = passwordValidation(pass);
						}
						System.out.print("/nNew Password: ");
						System.out.print("Please enter a new password:  ");
						String newpass = input.next();
						setPassword(newpass);
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
	//TODO Move these over to the controller class when its made.
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	public static void displayTable(ArrayList<?> x) {
        for (int i = 0; i < x.size(); i++) {
        	System.out.print(i + ") ");
			System.out.println(x.get(i));
        }
    }
	public static void displayTablenonum(ArrayList<?> x) {
		 for (int i = 0; i < x.size(); i++) {
				System.out.println(x.get(i));
				System.out.print("\n");
	        }
	}
	public static void remove(ArrayList<?> x, int i) {
		x.remove(i);
	}
	 public static void pressAny()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	 public static void checkPassword() {
	        Scanner input = new Scanner(System.in);
	        String inputPassword = "";
	        if(Data.password == "") {

	            System.out.print("Enter a new Password:  ");
	            Data.password = input.nextLine();
	        }
	        else{
	            while(inputPassword != Data.password) {
	                System.out.print("Enter Password:  ");
	                inputPassword = input.nextLine();
	            }
	        }
	    }
	 public static boolean passwordValidation(String inputPassword) {
         if(inputPassword == Data.password) {
             return true;
         }else {
             return false;
         }
     }
     public static void setPassword(String newPassword) {
         Data.password = newPassword;
     }
	 public static void displayActiveInvoices() {
	        ArrayList<Invoice> invoiceList = Data.invoiceArr; 
	        int x = 0;
	        for (int i = 0; i < invoiceList.size(); i++) {
	            if(invoiceList.get(i).isActiveStatus()) //if the invoice is active
	            System.out.print(x + ") ");
	            System.out.println(invoiceList.get(i));
	            x++;
	        }
	    }
	    public static void displayArchivedInvoices() {
	        ArrayList<Invoice> invoiceList = Data.invoiceArr; 
	        int x = 0;
	        for (int i = 0; i < invoiceList.size(); i++) {
	            if(!invoiceList.get(i).isActiveStatus()) //if the invoice is not active
	            System.out.print(x + ") ");
	            System.out.println(invoiceList.get(i));
	            x++;
	        }
	    }
}
