package classes;

import interfaces.IBranch;

import java.util.ArrayList;

public class Branch implements IBranch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    @Override
    public boolean newCustomer(String nameOfCustomer, double initialTransaction) {
        boolean status = false;
        Customer customer = null;
        try {
            /**
             * Check whether customer exist, if yes return false, if no add customer and initial transaction
             * */

            if (this.findCustomer(nameOfCustomer) == null){
                customer = new Customer(nameOfCustomer);
                customer.addTransaction(initialTransaction);
                status = customers.add(customer);
            }else {
                status = false;
            }

        }catch (Exception e){
            System.out.println("Add new customer failed");
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public boolean addCustomerTransaction(String nameOfCustomer, double transaction) {
        boolean status = false;
        Customer customer = null;
        try{
            customer = this.findCustomer(nameOfCustomer);
            if ( customer != null){
                customer.addTransaction(transaction);
                status = true;
            }else {
                status = false;
            }

        }catch (Exception e){
            System.out.println("Add customer transaction failed");
            System.out.println(e.getMessage());
        }
        return status;
    }


    private Customer findCustomer(String nameOfCustomer) {
        /**
         * Check whether customer exist then returns it or null
         * */
        Customer customer = null;
        try{
            if (!customers.isEmpty()){
                for (Customer c: this.customers) {
                    if (nameOfCustomer.equals(c.getName())){
                        customer = c;
                        break;
                    }else {
                        customer = null;
                    }
                }
            }else{
                customer = null;
            }
        }catch(Exception e){
            System.out.println("Find branch failed");
            System.out.println(e.getMessage());
        }
        return customer;
    }
}
