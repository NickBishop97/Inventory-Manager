package invmanger;
import java.util.Scanner;
/**
 * author: Jaime Alvarenga
 */
public class Controller {
    Scanner sc;

    public void createPassword(String password){
        Data.password = password;
    }

    public void changePassword(String password){
        Data.password = password;
    }

    /**
     * call Controller.login in the start of Manager. If the password is correct it will
     * simply proceed with manager.
     */
    public void login(){
        String password = " ";
        System.out.println("Please enter password: ");
        password = sc.nextLine();

        while(!(password.equals(Data.password))){
            System.out.println("Invalid password. Try again: ");
            password = sc.nextLine();
        }
    }

    public void viewProducts(){

    }

    public void addProduct(Product product){

    }

    public void viewUnderstockedProducts(){

    }

    public void editProductDetails(Product product){


    }
    public void deleteProduct(){

    }

    public void viewEmployeeSales(){

    }

    public void addEmployee(){

    }

    public void removeEmployee(){

    }

    public void editEmployeeDetails(){

    }

    public void addCustomer(){

    }

    public void editCustomerDetails(){

    }

    public void addInvoice(){

    }

    public void editInvoiceDetails(){

    }

    public void viewActiveInvoices(){

    }

    public void viewArchivedInvoices(){

    }



}
