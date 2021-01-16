/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import org.junit.Test;
import static org.junit.Assert.*;
import static touringsystem.Admin.getInstance;

/**
 *
 * @author Ahmed Kamal
 */
public class AdminTest {
    
    public AdminTest() {
    }

    /**
     * Test of getInstance method, of class Admin.
     */
    @Test
    public void testGetInstance() {
    }

    /**
     * Test of Login method, of class Admin.
     */
    @Test
    public void testLogin() {
        Admin admin = getInstance();
        System.out.println(admin);
        assertNotNull(admin);
    }
    
}
