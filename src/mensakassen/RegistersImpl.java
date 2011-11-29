/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author panos
 */
final class RegistersImpl implements Registers {

    private final Collection<Register> registers;

    public RegistersImpl(int numberOfRegisters) {
        registers = new ArrayList<Register>();
        for (int i = 1; i <= numberOfRegisters; i++) {
            registers.add(Values.newRegister("register " + i));
        }

    }

    @Override
    public Register registerWithShortestQueue() {
        Register registerWithShortestQueue;
//        if (!registers.isEmpty()) {
        Iterator<Register> i = registers.iterator();
        registerWithShortestQueue = i.next();
        while (i.hasNext()) {
            Register register = i.next();
            if (register.numberOfWaitingCustomers() < registerWithShortestQueue.numberOfWaitingCustomers()) {
                registerWithShortestQueue = register;
            }
        }
//        }
        return registerWithShortestQueue;
    }

//    static class RegisterComparator implements Comparator<Register> {
//
//        @Override
//        public int compare(Register register1, Register register2) {
//            return Integer.valueOf(register1.numberOfWaitingCustomers()).compareTo(register2.numberOfWaitingCustomers());
//        }
//    }
}
