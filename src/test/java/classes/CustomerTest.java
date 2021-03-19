package classes;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;

import static org.hamcrest.MatcherAssert.assertThat;


import static org.junit.Assert.*;

public class CustomerTest {

    private ArrayList<Double> list;
    private static Customer customer ;

    @BeforeClass
    public static void setUp(){

        customer = new Customer("Tim") ;
    }


    @Test
    public void getName() {
        assertEquals("Tim", customer.getName());
    }


    @Test
    public void addTransaction() {
        customer.addTransaction(50.05);
        customer.addTransaction(175.34);
        customer.addTransaction(220.12);

    }

    @Test
    public void getTransactions() {
        list = new ArrayList<Double>(Arrays.asList(50.05,175.34,220.12));
        assertEquals("Checking size of List",list.size() , customer.getTransactions().size());
        //1. Test equal.
        assertThat(list, is(customer.getTransactions()));
        //3. Check List Size
        assertThat(list, hasSize(3));

        assertThat(list.size(), is(3));
    }
}