package gr.codehub.myapp;

public class Ui {
    public void doTest() throws Exception {

        CustomerList custList = new CustomerList();

        Customer c1 = new Customer();
        c1.setLastName("Varsamidis");

       custList.addCustomer(c1);


        System.out.println(custList.getCustomer(2));


        System.out.println("The size of the list is " + custList.getSize());
        System.out.println(custList.getMaxBalance());

    }

}
