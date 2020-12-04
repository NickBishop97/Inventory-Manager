package invmanger;

import java.io.IOException;
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
		
		while(userInt != 0)
		{
			clrscr();
			System.out.println("--------------------");
			System.out.println("Main Menu");
			System.out.println("--------------------\n\n");
			
			
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
					System.out.println("--------------------\n\n");
					
					System.out.println("0) Exit to main menu");
					System.out.println("1) View All Products");
					System.out.println("2) View Understocked Products");
					System.out.println("3) Add Products");
					System.out.println("4) Edit Product Details");
					System.out.println("5) Delete Product");
					System.out.println("6) Add Warehouse");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					System.out.print("\n");
					String y = "";
					if(userInt == 3) {
						//sets year
						System.out.print("Product Name:  ");
						y = input.nextLine();
						
						//sets month
						System.out.print("Product ID:  ");
						y = input.nextLine();
						
						//sets day
						System.out.print("Sales Price:  ");
						y = input.nextLine();
					}
					else if(userInt == 1) {
						clrscr();
						System.out.println("--------------------");
						System.out.println("View All Products");
						System.out.println("--------------------\n\n");
						System.out.println("|     Product Name     |Product ID|Sales Price|Stock|");
						System.out.println("|                      |          |           |     |");
						System.out.println("|   Pringles Original  |  294758  |   2.99$   | 80  |\n\n");
					}
					
					//TODO finish/cleanup this UI element
					
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
					System.out.println("--------------------\n\n");
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
						input.nextLine();
						//TODO add connection to filesystem for all 3 of these enteries
						System.out.print("\nPlease enter Employee's Phone#\nPhone Number: ");
						input.nextLine();
						System.out.print("\nPlease enter Employee's Comissions.\nComissions: ");
						input.nextLine();
						//TODO add confirmation to see if all the info is correct, if we have time.
						System.out.println("New Employee has been created in the database.");
					}
					else if(userInt == 2 ) {
						clrscr();
						System.out.println("--------------------");
						System.out.println("Removing Employee");
						System.out.println("--------------------\n");
						System.out.print("Please enter the Employee's Name.\nName: ");
						input.nextLine();
						System.out.print("\nAre you sure you want to delete this Employee?(Y/N)  ");
						String y = input.nextLine();
						if(y.equals("Y")) {
							//TODO Command to delete Employee
							System.out.println("\nEmployee has been deleted from the database.");
							Thread.sleep(4000);
						}
					}
					else if(userInt == 3) {
						clrscr();
						System.out.println("--------------------");
						System.out.println("Employee's Sales");
						System.out.println("--------------------\n");
						System.out.print("Please enter the Employee's Name.\nName: ");
						input.nextLine();
						//TODO displys info about employee's sales
					}
					else if(userInt == 4) {
						clrscr();
						System.out.print("Please enter the Employee's Name that you want to edit.\nName: ");
						String Name = input.nextLine();
						//TODO Add connection to filesystem
						while(userInt != 3) {
							clrscr();
							System.out.println("--------------------");
							System.out.println("Choose an Option to edit");
							System.out.println("--------------------\n");
							//TODO add feture where you can see what your going to edit before selecting
							System.out.println("0) Name: ");
							System.out.println("1) Phone: ");
							System.out.println("2) Commission: ");
							System.out.println("3) Finish editing");
							System.out.println("\nInput:  ");
							input.nextLine();
							if(userInt == 0) {
								clrscr();
								System.out.print("What is the new Name for this Employee: ");
								input.nextLine();
								//TODO add connection to filesystem
								System.out.println("\nEmployee Name has been changed in the database.");
								Thread.sleep(4000);
							}
							else if(userInt == 1) {
								clrscr();
								System.out.print("What is the new Phone# for this Employee");
								input.nextLine();
								//TODO add connection to filesystem
								System.out.println("\nEmployee Phone# has been changed in the database.");
								Thread.sleep(4000);
							}
							else if(userInt == 2) {
								clrscr();
								System.out.print("What is the new Commission fo this Employee");
								input.nextLine();
								//TODO add connection to filesystem
								System.out.println("\nEmployee Commission has been changed in the database.");
								Thread.sleep(4000);
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
					System.out.println("--------------------\n\n");
					System.out.println("0) Exit to main menu");
					System.out.println("1) Add Customer");
					System.out.println("2) Edit Customer Details");
					System.out.println("3) View Active Invoices");
					System.out.println("4) View Archived Invoices");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					if(userInt == 1) {
						clrscr();
						System.out.println("--------------------");
						System.out.println("Adding New Customer");
						System.out.println("--------------------\n");
						System.out.print("What is the Customer's Name?\nName: ");
						input.nextLine();
						//TODO connect to filesystem
						System.out.print("What is the Customer's Phone#?\nName: ");
						input.nextLine();
						//TODO connect to filesystem
					}
					else if(userInt == 2) {
						clrscr();
						System.out.print("Please enter the Customer's Name that you want to edit.\nName: ");
						String Name = input.nextLine();
						//TODO Add connection to filesystem
						while(userInt != 4) {
							clrscr();
							System.out.println("--------------------");
							System.out.println("Choose an Option to edit");
							System.out.println("--------------------\n");
							//TODO add feture where you can see what your going to edit before selecting
							System.out.println("0) Name: ");
							System.out.println("1) Phone: ");
							System.out.println("2) Suspension Status: ");
							System.out.println("3) Active Status: ");
							System.out.println("4) Finished editing");
							System.out.println("\nInput:  ");
							input.nextLine();
						}
					}
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			
			//cut content
			//else if(userInt == 85) {
				//while(userInt != 0) {
					//clrscr();
					//System.out.println("--------------------");
					//System.out.println("Orders");
					//System.out.println("--------------------\n\n");
					//System.out.println("0) Exit to main menu");
					//System.out.println("1) Add Order");
					//System.out.println("2) Edit Order Details");
					//System.out.println("3) View Active Invoices");
					//System.out.println("4) View Archived Invoices");
					//System.out.print("\nInput:  ");
					
					//userInt = input.nextInt();
					//input.nextLine();
					//System.out.print("\n");
				//}
				//change variable so program doesnt shut down on userInt = 0
				//userInt = 99;
			//}
			
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
						System.out.print("Current Password: ");
						input.nextLine();
						//TODO check password to see if it's correct
						System.out.print("/nNew Password: ");
						input.nextLine();
						System.out.print("/nConfirmation: ");
						input.nextLine();
						//TODO compare new password and confirmation to see if they are the same,
						// then save the password to password.java
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
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
}
