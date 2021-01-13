/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Ahmed Kamal
 */
public abstract class User {
    private int ID;
    private String role;
    private String name;
    private String password;

    public User(int ID, String role, String name, String password) {
        this.ID = ID;
        this.role = role;
        this.name = name;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void Login(String username, String pass){
        // Database Connection 
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
        
        if(role == "admin"){
            MongoCollection admin  = TouringSystem.getCollection("Admin");
            
        }
        else if (role == "Traveler"){
            MongoCollection Traveler = TouringSystem.getCollection("Traveler");
        }
    }
    
    public void UpdateAccount(User user){
        
    }
    
}
