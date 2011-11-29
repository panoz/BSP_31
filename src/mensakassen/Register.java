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
public interface Register {

    int numberOfWaitingCustomers();

    Semaphore semaphore();
}
