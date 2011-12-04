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
final class Register {

    private final String name;
    private final Semaphore semaphore;

    Register(String name) {
        this.name = name;
        this.semaphore = new Semaphore(1);
    }

    static Register create(String name) {
        return new Register(name);
    }

    public int numberOfWaitingCustomers() {
        return semaphore.getQueueLength();
    }

    @Override
    public String toString() {
        return name;
    }

    public Semaphore semaphore() {
        return semaphore;
    }
}
