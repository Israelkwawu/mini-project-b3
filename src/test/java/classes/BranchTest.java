package classes;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

public class BranchTest {
    private static Branch branch ;
    private ArrayList<Customer> list;

    @BeforeClass
    public static void setUp(){

        branch = new Branch("Adelaide") ;
        branch.newCustomer("Tim",74.9);
        branch.newCustomer("Mike",175.34);
        branch.newCustomer("Percy",220.12);
    }

    @Test
    public void getName() {
        assertEquals("Adelaide", branch.getName());
    }


    @Test
    public void newCustomer() {
        assertTrue("Customer added successfully", branch.newCustomer("Timoty",50.05));
        assertTrue("Customer added successfully", branch.newCustomer("Kate",175.34));
        assertTrue("Customer added successfully", branch.newCustomer("Peter",220.12));
    }


    @Test
    public void addCustomerTransaction() {
        assertTrue("Adding customer transaction", branch.addCustomerTransaction("Tim",4.0));
    }

    @Test
    public void getCustomers() {
        assertNotNull("Customer list not null",branch.getCustomers());
        assertEquals(3, branch.getCustomers().size());
    }

}