/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensakassen;

import mensakassen.Customer;

/**
 *
 * @author panos
 */
public class CustomerImpl implements Customer {
    private final String name;
    
    private CustomerImpl(String name) {
        this.name=name;
    }
    
    public static Customer create(String name) {
        return new CustomerImpl(name);
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
        return (this==obj);
    }

    @Override
    public void run() {
        
    }
    

}
