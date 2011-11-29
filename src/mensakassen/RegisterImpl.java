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
final class RegisterImpl implements Register {

    private final String name;
    private final Semaphore semaphore;

    private RegisterImpl(String name) {
        this.name = name;
        this.semaphore = new Semaphore(1);
    }

    static Register create(String name) {
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
//    public void run() {
//        while (true) {
//        }
//    }

    @Override
    public Semaphore semaphore() {
        return semaphore;
    }
}
