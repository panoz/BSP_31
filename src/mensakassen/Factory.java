/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

/**
 *
 * @author panos
 */
public final class Factory {

    private Factory() {
    }
    
    public static Customer newCustomer(Registers registers, String name) {
        return CustomerImpl.create(registers, name);
    }
    
    public static Register newRegister(String name) {
        return RegisterImpl.create(name);
    }

    public static Registers newRegisters(int numberOfRegisters) {
        return RegistersImpl.create(numberOfRegisters);
    }
}
