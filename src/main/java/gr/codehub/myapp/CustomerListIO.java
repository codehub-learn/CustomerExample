package gr.codehub.myapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerListIO {

    public void saveCustomersToFile(CustomerServiceImpl cl, String filename)
            throws FileNotFoundException, BadFileNameException {
        if (filename.equals("dimitris.txt")) {
            throw new BadFileNameException();
        }
        try (PrintWriter pw = new PrintWriter(new File(filename))) {
            cl.getCustomers()
                    .forEach(c -> pw.println(c.getFirstName() +
                            "," + c.getLastName() + "," + c.getBalance()));
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public List<Customer> readFromFile(String filename)
            throws FileNotFoundException,
            IndexOutOfBoundsException,
            NumberFormatException {

        Scanner sc = new Scanner(new File(filename));
        List<Customer> customers = new ArrayList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();

            //  String[]words = new String[10];
            String[] elements = line.split(",");
            Customer c = new Customer()
                    .setFirstName(elements[0])
                    .setLastName(elements[1])
                    .setBalance(Double.parseDouble(elements[2]));

            customers.add(c);
        }
        return customers;
    }
}
