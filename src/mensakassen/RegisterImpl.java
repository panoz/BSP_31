/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import mensakassen.Customer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author panos
 */
public class RegisterImpl extends Semaphore implements Register {

    private final String name;
//    private Queue<Customer> queue;
    private Semaphore semaphore;
    
    private RegisterImpl(String name) {
        this.name = name;
//        this.queue = new LinkedList<Customer>();
        this.semaphore=new Semaphore(1);
    }

    public static Register create(String name) {
        return new RegisterImpl(name);
    }

    @Override
    public int numberOfWaitingCustomers() {
        return semaphore.getQueueLength();
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public void enqueue(Customer customer) {
//        semaphore.;
//    }

    @Override
    public void run() {
        while (true) {
            if (!queue.isEmpty()) {
                Customer customer=queue.poll();
                System.out.println("Customer "+customer+ "begins paying at register"+this);
                try {
                    Thread.sleep((long)((Simulation.PAYING_TIME_MAXIMUM-Simulation.PAYING_TIME_MINIMUM)*Math.random()));
                } catch (InterruptedException ex) {
                    Logger.getLogger(RegisterImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Customer "+customer+ "has finished paying at register"+this);
            }
        }
    }
    
//    public boolean busy() {
//        
//    }
}
