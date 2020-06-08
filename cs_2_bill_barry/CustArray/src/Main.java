import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    /**
     * Main program for a Customer Array example
     * @param args command line parameter
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException { // reading a file in a document and if the file is not found we throw an exception
        // Prepare the program to read a file
        File inFile = new File("CustArray/src/Customer.txt");
        Scanner readThis = new Scanner(inFile);

        // Read count and create array of objects
        int customerCount = readThis.nextInt();
        Customer[] custArray = new Customer[customerCount];

        double balance;
        int age;
        String name;

        // Create objects and store them
        for (int i = 0; i < customerCount; i++) {
            balance = readThis.nextDouble();
            age = readThis.nextInt();
            name = readThis.next() + readThis.nextLine();
            custArray[i] = new Customer(name, age, balance); // Store object in the array, thats cool!
        }
        // Prove we have access to objects
        System.out.print("Customer: ");
        for (int i = 0; i < customerCount; i++) {
            System.out.println(custArray[i]);
        }

        // Close stuff down
        readThis.close();
    }
}