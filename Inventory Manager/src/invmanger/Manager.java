package invmanger;

import java.util.Scanner;

public class Manager {


	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		int userInt = 10;
		
		
		while(userInt != 0)
		{
			System.out.println("--------------------");
			System.out.println("Main Menu");
			System.out.println("--------------------\n\n");
			
			
			System.out.println("0)  Shut Down");
			System.out.println("1)  Products");
			System.out.println("2)  Employees");
			System.out.println("3)  Customers");
			System.out.println("4)  Orders");
			System.out.println("5)  System Settings");
			System.out.print("\nInput:  ");
			userInt = input.nextInt();
			input.nextLine();
			System.out.print("\n");
			
			//Products
			if(userInt == 1) {
				while(userInt != 0) {
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
						input.nextLine();
						
						//sets month
						System.out.print("Product ID:  ");
						y = input.nextLine();
						input.nextLine();
						
						//sets day
						System.out.print("Sales Price:  ");
						y = input.nextLine();
						input.nextLine();	
					}
					else if(userInt == 1) {
						System.out.println("--------------------");
						System.out.println("View All Products");
						System.out.println("--------------------\n\n");
						System.out.println("|     Product Name     |Product ID|Sales Price|Stock|");
						System.out.println("|                      |          |           |     |");
						System.out.println("|   Pringles Original  |  294758  |   2.99$   | 80  |\n\n");
					}
					
					
					
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}

			
			//Employees
			else if(userInt == 2) {
				while(userInt != 0) {
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
					System.out.print("\n");
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			
			
			//Customers
			else if(userInt == 3) {
				while(userInt != 0) {
					System.out.println("--------------------");
					System.out.println("Customers");
					System.out.println("--------------------\n\n");
					System.out.println("0) Exit to main menu");
					System.out.println("1) Add Customer");
					System.out.println("2) Edit Customer Details");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					System.out.print("\n");
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			
			//Orders
			else if(userInt == 4) {
				while(userInt != 0) {
					System.out.println("--------------------");
					System.out.println("Orders");
					System.out.println("--------------------\n\n");
					System.out.println("0) Exit to main menu");
					System.out.println("1) Add Order");
					System.out.println("2) Edit Order Details");
					System.out.println("3) View Active Invoices");
					System.out.println("4) View Archived Invoices");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					System.out.print("\n");
				}
				//change variable so program doesnt shut down on userInt = 0
				userInt = 99;
			}
			
			//System settings
			else if(userInt == 5) {
				while(userInt != 0) {
					System.out.println("--------------------");
					System.out.println("System Settings");
					System.out.println("--------------------\n\n");
					System.out.println("0) Exit To Main Menu");
					System.out.println("1) Change Password");
					System.out.print("\nInput:  ");
					
					userInt = input.nextInt();
					input.nextLine();
					System.out.print("\n");
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
