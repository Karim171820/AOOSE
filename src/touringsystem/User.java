/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

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

    public void Login(String role, String Un, String pass) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");

        if (role == "Traveler") {
            MongoCollection traveler = TouringSystem.getCollection("Traveler");
            Document tacc = (Document) traveler.find(Filters.eq("name", Un)).first();  // tacc refers to traveler account
            if (tacc.containsValue(Un) && tacc.containsValue(pass)) {
                System.out.println("Welcome, " + Un);
            }
        } else if (role == "Admin") {
            MongoCollection admin = TouringSystem.getCollection("Admin");
            Document Aacc = (Document) admin.find(Filters.eq("name", Un)).first();  // Aacc refers to admin account
            if (Aacc.containsValue(Un) && Aacc.containsValue(pass)) {
                System.out.println("Welcome, " + Un);
            }
        } else {
            System.out.println("Invlaid Login");
        }
    }
    
    public void UpdateAccount(int Uid, String role,User user) {
        
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");

        if (role == "Traveler") {
            MongoCollection traveler = TouringSystem.getCollection("Traveler");
            Document tacc = (Document) traveler.find(Filters.eq("ID", Uid)).first();  // tacc refers to traveler account
            
        }
        else if (role == "Admin") {
            MongoCollection admin = TouringSystem.getCollection("Admin");
            Document Aacc = (Document) admin.find(Filters.eq("ID", Uid)).first();  // Aacc refers to admin account
            
        } else {
            System.out.println("Invlaid Login");
        }  
    }
}
