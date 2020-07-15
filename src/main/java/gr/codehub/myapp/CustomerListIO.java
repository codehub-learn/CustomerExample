package gr.codehub.myapp;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerListIO {

    public List<Customer> readFromExcel(String filename) throws IOException, InvalidFormatException {

         // Creating a Workbook from an Excel file (.xls or .xlsx)
         Workbook workbook = WorkbookFactory.create(new File(filename));


         // Getting the Sheet at index zero
         Sheet sheet = workbook.getSheetAt(0);

         // Create a DataFormatter to format and get each cell's value as String
         DataFormatter dataFormatter = new DataFormatter();



         //   Or you can use a for-each loop to iterate over the rows and columns
         System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
         for (Row row: sheet) {
             for(Cell cell: row) {
                 String cellValue = dataFormatter.formatCellValue(cell);
                 System.out.print(cellValue + "\t");
             }
             System.out.println();
         }



         // Closing the workbook
         workbook.close();

         return null;
     }






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
