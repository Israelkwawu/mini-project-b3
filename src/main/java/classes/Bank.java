package classes;

import interfaces.IBank;

import java.util.ArrayList;

public class Bank implements IBank {
    private String name;
    private ArrayList<Branch>  branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    @Override
    public boolean addBranch(String nameOfBranch) {
        /**
         * 1) Handle null value of name
         * 2) Add branch if it does not exist
        * */
        boolean status = false;

        try{
            if (this.findBranch(nameOfBranch) == null){
                status = branches.add(new Branch(nameOfBranch));
            }else {
                status = false;
            }
        }catch (Exception e){
            System.out.println("Add branch failed");
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction) {
        boolean status = false;
        try {
            /**
             * Check whether branch exist before assigning customer
            * */
            Branch findBranch = this.findBranch(nameOfBranch);
            if ( findBranch != null){

                status = findBranch.newCustomer(nameOfCustomer,initialTransaction);
            }else{
                status = false;
            }

        }catch (Exception e){
            System.out.println("Add customer failed");
            System.out.println(e.getMessage());
        }

        return status;
    }

    @Override
    public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction) {
        boolean status = false;
        try{

            /**
             * Check whether branch exist before assigning customer and transaction
             * */
            Branch findBranch = this.findBranch(nameOfBranch);
            if (findBranch != null){
                status = findBranch.addCustomerTransaction(nameOfCustomer,transaction);
            }else{
                status = false;
            }

        }catch (Exception e){
            System.out.println("Add customer transaction failed");
            System.out.println(e.getMessage());
        }
        return status;
    }


    private Branch findBranch(String nameOfBranch) {

        /**
         * Check whether branch exist then returns it or null
         * */

        Branch branch = null;
        try{
            if (!branches.isEmpty()){
                for (Branch b: this.branches) {
                    if (nameOfBranch.equals(b.getName())){
                        branch = b;
                        break;
                    }else {
                        branch = null;
                    }
                }
            }else{
                branch = null;
            }
        }catch(Exception e){
            System.out.println("Find branch failed");
            System.out.println(e.getMessage());
        }
        return branch;
    }

    @Override
    public boolean listCustomers(String nameOfBranch, boolean printTransactions) {

        System.out.println("Customer details for branch "+nameOfBranch);
        boolean status = false;
        try{

            /**
             * Check whether branch exists
             * */
            Branch findBranch = this.findBranch(nameOfBranch);
            int countCustomer = 0;
            if (findBranch != null){

                /**
                 * If branch exists get it customer and their transactions
                 * */
                ArrayList<Customer> customers = findBranch.getCustomers();

                for (Customer customer: customers) {
                    int countTransaction = 0;
                    if (printTransactions){
                        System.out.println("Customer: "+ customer.getName()+"["+ ++countCustomer +"]");
                        System.out.println("Transactions");
                        for (int i = 0; i < customer.getTransactions().size(); i++) {
                            System.out.println("["+ ++countTransaction+"] Amount "+ customer.getTransactions().get(i));
                        }
                    }else{
                        System.out.println("Customer: "+ customer.getName()+"["+ ++countCustomer +"]");
                    }
                }
                status = true;
            }else{

                /**
                 * return false, if there is no matching branch
                 * */
                status = false;
            }

        }catch (Exception e){
            System.out.println("List all customers failed");
            System.out.println(e.getMessage());
        }
        return status;
    }
}
