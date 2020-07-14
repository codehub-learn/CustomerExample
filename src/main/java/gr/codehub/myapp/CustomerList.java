package gr.codehub.myapp;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerList {
    private List<Customer> customers;



    public CustomerList() {
        customers = new ArrayList<>();
    }

    //CRUD     operations on a certain element
    //create read update delete

    public void addCustomer(Customer cust) {
        customers.add(cust);
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public void setCustomer(int index, Customer cust) {
        customers.set(index, cust);
    }

    public void removeCustomer(int index) {
        customers.remove(index);
    }


    //bulk operations
    // check the case of equal objects
    public void addCustomers(List<Customer> customers) {
        this.customers.addAll(customers);
    }

    public void removeCustomersWithPositiveBalance() {
        customers.removeIf(c -> c.getBalance() > 0);
    }

    //algorithms
//sort with criterion
    //mutates the list
    public void sortByBalanceReversed() {

        customers.sort(Comparator
                .comparing(Customer::getBalance)
                .reversed()
                .thenComparing(Customer::getLastName)
                );
    }
    public void sortByBalance() {

        customers.sort(Comparator
                .comparing(Customer::getBalance)
                 );
    }


    // sublists
    public List<Customer> getCustomersWithCriterion(
            double balanceGreaterThan) {
        return customers.stream()
                .filter(c -> c.getBalance() > balanceGreaterThan)
                .collect(Collectors.toList());
    }

    public List<Double> getListOfReducedBalances() {
        return customers.stream()
                .mapToDouble(Customer::getReducedBalance)
                .boxed()
                .collect(Collectors.toList());

    }

    public void addDebitToAllCustomers(double amount) {
        customers
                .forEach(c -> c.setBalance(c.getBalance() + amount));
    }


    //Aggregations      operations that produce a summative result


    public int getSize() {
        return customers.size();
    }

    //sum balances
    public double getSumOfReducedBalances() {
        double returnValue =
                customers.stream()
                        .mapToDouble(Customer::getReducedBalance)
                        .sum();
        return returnValue;
    }


    // max balance
    public double getMaxBalance() throws Exception {
        return customers
                .stream()
                .max(Comparator.comparing(Customer::getBalance))
                .get()
                .getBalance();

    }

    // min balance
    public Customer getCustomerWithMinimumReducedBalance() {
        return customers
                .stream()
                .min(Comparator.comparing(Customer::getReducedBalance))
                .orElseGet(Customer::new);

    }

}
