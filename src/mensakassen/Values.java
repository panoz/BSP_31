/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import mensakassen.CustomerImpl;
import mensakassen.Customer;

/**
 *
 * @author panos
 */
public final class Values {

    private Values() {
    }
    
    public static Customer newCustomer(String name) {
        return CustomerImpl.create(name);
    }
    
    public static Register newRegister(String name) {
        return RegisterImpl.create(name);
    }

}
