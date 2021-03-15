package interfaces;

import classes.Branch;

public interface IBank {
    boolean addBranch(String nameOfBranch);
    boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction);
    boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction);
    boolean listCustomers(String nameOfBranch, boolean printTransactions);
}
