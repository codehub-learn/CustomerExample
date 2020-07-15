package gr.codehub.myapp;


import lombok.SneakyThrows;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, InvalidFormatException {
        CustomerListIO cio = new CustomerListIO();
        System.out.println(cio.readFromExcel("customers.xlsx"));


//        Ui ui = new Ui();
//
//        try {
//            ui.testCustomerService();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

    }
}
