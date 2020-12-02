package invmanger;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Jaime Alvarenga
 */

public class Data implements Serializable
{
    static ArrayList<Invoice> invoiceArr = new ArrayList<Invoice>();
   static ArrayList<Product> productArr = new ArrayList<Product>();
    static ArrayList<Warehouse> warehouseArr = new ArrayList<Warehouse>();
    static ArrayList<Customer> customerArr = new ArrayList<Customer>();
    /**
     * These ArrayLists are where every new Object gets stored. Saved from and loaded into.
     */

    public static void saveCustomer(){
        /**
         * Used to save Customer ArrayList to a file.
         */
        try {
            FileOutputStream fileOut = new FileOutputStream("customer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customerArr);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static void loadCustomer(){
        /**
         * Loads saved Objects into customer Array
         */

        try{
            FileInputStream fileIn = new FileInputStream("customer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            customerArr = (ArrayList<Customer>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i){
            i.printStackTrace();
        }
    }
    public static void saveInvoice(){
        /**
         * Used to save Invoice ArrayList to a file.
         */
        try {
            FileOutputStream fileOut = new FileOutputStream("invoice.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(invoiceArr);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static void loadInvoice(){
        /**
         * Loads saved Objects into invoice Array
         */
        try{
            FileInputStream fileIn = new FileInputStream("invoice.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            invoiceArr = (ArrayList<Invoice>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i){
            i.printStackTrace();
        }
    }
    public static void saveWareHouse(){
        /**
         * Used to save Warehouse ArrayList to a file.
         */
        try {
            FileOutputStream fileOut = new FileOutputStream("warehouse.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(warehouseArr);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static void loadWarehouse(){
        /**
         * Loads saved Objects into warehouse Array
         */
        try{
            FileInputStream fileIn = new FileInputStream("warehouse.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            warehouseArr = (ArrayList<Warehouse>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i){
            i.printStackTrace();
        }
    }
    public static void saveProduct(){
        /**
         * Used to save Product ArrayList to a file.
         */
        try {
            FileOutputStream fileOut = new FileOutputStream("product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(productArr);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static void loadProduct(){
        /**
         * Loads saved Objects into product Array
         */
        try{
            FileInputStream fileIn = new FileInputStream("product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            productArr = (ArrayList<Product>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i){
            i.printStackTrace();
        }
    }


}
