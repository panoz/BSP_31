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
final class RegistersImpl implements Registers {

    private final Collection<Register> registers;

    private RegistersImpl(int numberOfRegisters) {
        registers = new ArrayList<Register>();
        for (int i = 1; i <= numberOfRegisters; i++) {
            registers.add(Factory.newRegister("R" + i));
            System.out.println("register "+i+ " created");
        }
    }

    static Registers create(int numberOfRegisters) {
        return new RegistersImpl(numberOfRegisters);
    }

    @Override
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
