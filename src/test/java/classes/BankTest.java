package classes;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BankTest {
    private static Bank bank ;
    private ArrayList<Customer> list;

    @BeforeClass
    public static void setUp(){

        bank = new Bank("National Australia Bank") ;

    }

    @Test
    public void addBranch() {
        assertTrue("Added Branch",bank.addBranch("Adelaide"));

    }

    @Test
    public void addCustomer() {
        assertTrue("Added Customer",bank.addCustomer("Adelaide","Tim",67.90));
    }

    @Test
    public void addCustomerTransaction() {
        assertTrue("Added customer transaction",bank.addCustomerTransaction("Adelaide","Tim",54.45));
    }

    @Test
    public void listCustomers() {
        assertTrue("All Customer List",bank.listCustomers("Adelaide",true));

    }
}