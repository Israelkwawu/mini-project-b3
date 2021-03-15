package classes;

import interfaces.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {
    private String name;
    private ArrayList<Double> transactions;


    public Customer(String name) {
        if (name != null){
            this.name = name;
        } else{
            System.out.println("Please Enter a valid name.");
        }

        this.transactions = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    @Override
    public void addTransaction(double transaction) {
            transactions.add(transaction);

    }
}
