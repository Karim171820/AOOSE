/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ahmed Kamal
 */
public class TravelerTest {
    
    public TravelerTest() {
    }

    /**
     * Test of getAge method, of class Traveler.
     */
    @Test
    public void testLogin() {
        Traveler trav = new Traveler();
        assertNotNull(trav.Login("Ahmed","Ahmed"));
    }

    /**
     * Test of UpdateAccount method, of class Traveler.
     */
    @Test
    public void testUpdateAccount() {
        Traveler trav = new Traveler();
        Traveler trav2 = trav.Login("Ahmed","Ahmed");
        trav.UpdateAccount(trav2 , "ahmed", "123");
    }

    /**
     * Test of UpdatePackageData method, of class Traveler.
     */
}
