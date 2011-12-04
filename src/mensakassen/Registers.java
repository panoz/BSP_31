/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author panos
 */
final class Registers {

    private final Collection<Register> registers;

    Registers(int numberOfRegisters) {
        registers = new ArrayList<Register>();
        for (int i = 1; i <= numberOfRegisters; i++) {
            registers.add(new Register("R" + i));
            if (Simulation.DEBUG) {
                System.out.println("register " + i + " created");
            }
        }
    }

    public Register registerWithShortestQueue() {
        Register registerWithShortestQueue;
        Iterator<Register> i = registers.iterator();
        registerWithShortestQueue = i.next();
        while (i.hasNext()) {
            Register register = i.next();
            if (register.numberOfWaitingCustomers() < registerWithShortestQueue.numberOfWaitingCustomers()) {
                registerWithShortestQueue = register;
            }
        }
        return registerWithShortestQueue;
    }
}
