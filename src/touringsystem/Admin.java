/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

/**
 *
 * @author Ahmed Kamal
 */
public class Admin extends User {
    
    private static Admin admin = null;

    private Admin(int ID, String role, String name, String password) {
        super(ID, role, name, password);
    }
    
    public static Admin getInstance() {

        if (admin == null) {
            admin = new Admin(1, "admin","Ahmed Kamal","Complex");
            return admin;
        } else
            return admin;
    }

    private void UpdatePackage(Package pack){
        
    }  
}