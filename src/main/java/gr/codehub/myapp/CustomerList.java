package gr.codehub.myapp;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerList {
    private List<Customer> customers;

    public CustomerList(){
        customers = new ArrayList<>();
    }

    //CRUD
    //create read update delete

    public void addCustomer(Customer cust){
        customers.add(cust);
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }

    public void setCustomer(int index, Customer cust){
         customers.set(index, cust);
    }

    public void removeCustomer(int index ){
        customers.remove(index);
    }

    //bulk operations
    // check the case of equal objects
    public void addCustomers(List<Customer> customers){
        this.customers.addAll(customers);
    }



    //Aggregations
    public int getSize(){
        return customers.size();
    }

    //sort with criterion


    //sum balances
    public double getSumBalances(){
        double returnValue =
                customers.stream()
                        .mapToDouble(Customer::getReducedBalance)
                         .sum();
//
//          double  returnValue=0;
//         for(Customer cust: customers){
//           returnValue += cust.getBalance();
//       }


 //  double  returnValue=0;
//        for (int i=0;i<customers.size(); i++)
//            returnValue += customers.get(i).getBalance();

        return returnValue;
    }




    // max balance

    // min balance

}
