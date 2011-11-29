/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import java.util.concurrent.Semaphore;

/**
 *
 * @author panos
 */
public interface Register extends Runnable {

    int numberOfWaitingCustomers();

//    void enqueue(Customer customer);
//    
//    boolean busy();
    Semaphore semaphore();
}
