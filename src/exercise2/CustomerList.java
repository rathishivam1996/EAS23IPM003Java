package exercise2;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerList {
   private ArrayList<Customer> customers;
   private static CustomerList Instance = null;

    private CustomerList(){
        customers=new ArrayList<>();
    }

    public static CustomerList getCustomers() {
        if (Instance==null) Instance = new CustomerList();

        return Instance;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void createRandomCustomers(int num){
        for (int i=0; i <=num; i++){
            String name = "Customer "+i;
            String email = "customer"+i+"@gmail.com";
            customers.add(new Customer(name, email));
        }
    }

    public Customer findCustomerByName(String name){
        for (Customer customer : customers) {
            if (Objects.equals(customer.getName(), name)) return customer;
        }
        return null;
    }

    public void displayCustomers(){
        for (Customer customer : customers){
            System.out.println(customer);
        }
        System.out.println("Done !!!");
    }
}
