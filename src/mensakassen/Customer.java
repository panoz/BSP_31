/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author panos
 */
final class Customer implements Runnable {

    private final String name;
    private final Registers registers;

    Customer(Registers registers, String name) {
        this.registers = registers;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    @Override
    public void run() {
        if (Simulation.DEBUG) {
            System.out.println("start running " + this);
        }
        while (true) {
            paying();
            eating();
            doingSomethingElse();
        }
    }

    private void paying() {
        Register register = registers.registerWithShortestQueue();
        try {
            register.semaphore().acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer " + this + " begins paying at register " + register);
        try {
            Thread.sleep((long) ((Simulation.PAYING_TIME_MAXIMUM - Simulation.PAYING_TIME_MINIMUM) * Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer " + this + " has finished paying at register " + register);
        register.semaphore().release();
    }

    private void eating() {
        System.out.println("Customer " + this + " begins eating");
        try {
            Thread.sleep((long) ((Simulation.EATING_TIME_MAXIMUM - Simulation.EATING_TIME_MINIMUM) * Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer " + this + " has finished eating");
    }

    private void doingSomethingElse() {
        System.out.println("Customer " + this + " begins doing something else");
        try {
            Thread.sleep((long) ((Simulation.DOSOMETHINGELSE_TIME_MAXIMUM - Simulation.DOSOMETHINGELSE_TIME_MINIMUM) * Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer " + this + " has finished doing something else");
    }
}
