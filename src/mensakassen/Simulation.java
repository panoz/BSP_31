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
public class Simulation {

    private static final int NUMBER_OF_CUSTOMERS=10;
    private static final int NUMBER_OF_REGISTERS=3;
    
    public static final int PAYING_TIME_MINIMUM=0;
    public static final int PAYING_TIME_MAXIMUM=1000;
    
    public static final int EATING_TIME_MINIMUM=1000;
    public static final int EATING_TIME_MAXIMUM=5000;

    public static final int DOSOMETHINGELSE_TIME_MINIMUM=3000;
    public static final int DOSOMETHINGELSE_TIME_MAXIMUM=10000;
    
    public static final long WAITING_FOR_PAY_TIMEOUT=20000;
    
    public static void main(String[] args) {
        Collection<Customer> customers=new HashSet<Customer>();
        Collection<Register> registers=new HashSet<Register>();
        
        for (int i=1; i<=NUMBER_OF_CUSTOMERS; i++) {
            customers.add(Values.newCustomer("customer "+i));
        }

        
        while(true) {
            
        }
    }
}
