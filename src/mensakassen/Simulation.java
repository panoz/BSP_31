/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import mensakassen.Customer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author panos
 */
public class Simulation implements Runnable {

    private static final int NUMBER_OF_CUSTOMERS=10;
    private static final int NUMBER_OF_REGISTERS=3;
    
    public static final int PAYING_TIME_MINIMUM=500;
    public static final int PAYING_TIME_MAXIMUM=2000;
    
    public static final int EATING_TIME_MINIMUM=1000;
    public static final int EATING_TIME_MAXIMUM=5000;

    public static final int DOSOMETHINGELSE_TIME_MINIMUM=1000;
    public static final int DOSOMETHINGELSE_TIME_MAXIMUM=5000;
    
    public static final long WAITING_FOR_PAY_TIMEOUT=20000;
    
    public static void main(String[] args) {
        new Simulation().run();
    }
    
    public void run() {
                Collection<Customer> customers=new HashSet<Customer>();
        Registers registers=Factory.newRegisters(NUMBER_OF_REGISTERS);
        
        for (int i=1; i<=NUMBER_OF_CUSTOMERS; i++) {
            Customer customer=Factory.newCustomer(registers, "C"+i);
            System.out.println("customer "+customer+" created");
            customers.add(customer);
            new Thread(customer, "C"+i).start();
        }

        
        while(true) {
            
        }

    }
}
