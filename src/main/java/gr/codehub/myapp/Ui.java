package gr.codehub.myapp;

import java.util.List;

public class Ui {

    public void testCustomerService(){

        CustomerService cs = new RetailCustomerServiceImpl();
        Customer c = new Customer();
        cs.addCustomer(c);
        System.out.println(cs.countCustomers());


    }




    public void doTestOld() throws Exception {


        ImmutableCustomer ic = new ImmutableCustomer(2, "dimitris",
                true, 100);

        CustomerServiceImpl custList = new CustomerServiceImpl();

        CustomerListIO cio = new CustomerListIO();

        List<Customer> cl = cio.readFromFile("customers.txt");
        custList.addCustomers(cl);
        List<Customer> cl1 = custList.getCustomers();
        cl1.clear();
        System.out.println("the list contains " + cl1.size() + " customers");
        System.out.println("the list contains " + custList.getCustomers().size() + " customers");

        cio.saveCustomersToFile(custList, "mycustomers.txt");


    }

}
