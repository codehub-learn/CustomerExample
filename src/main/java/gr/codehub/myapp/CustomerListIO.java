package gr.codehub.myapp;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

public class CustomerListIO {

    public List<Customer> readFromExcel(String filename) throws IOException, InvalidFormatException {

        List<Customer> customers = new ArrayList<>();
        File workbookFile = new File(filename);
        FileInputStream file = new FileInputStream(workbookFile);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        boolean firstTime = true;

        for (Row row : sheet) {
            if (firstTime) {
                firstTime = false;
                continue;
            }
            customers.add(new Customer()
                    .setFirstName(row.getCell(0).getStringCellValue())
                    .setLastName(row.getCell(1).getStringCellValue())
                    .setBalance(row.getCell(2).getNumericCellValue())
                    .setDob(row.getCell(3).getDateCellValue()));
         }

        // Closing the workbook
        workbook.close();

        return customers;
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
