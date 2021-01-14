/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Ahmed Kamal
 */
public class Traveler extends User {

    public int age;
    public String passportExpireDate;
    public int creditAmount;
    public String email;
    public Reservation reservationID;
    public Packages pack;
    private Gson gson = new Gson();

    public Traveler(int age, String passportExpireDate, int creditAmount, String email, int ID, String role, String name, String password) {
        super(ID, role, name, password);
        this.age = age;
        this.passportExpireDate = passportExpireDate;
        this.creditAmount = creditAmount;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportExpireDate() {
        return passportExpireDate;
    }

    public void setPassportExpireDate(String passportExpireDate) {
        this.passportExpireDate = passportExpireDate;
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reservation getReservationID() {
        return reservationID;
    }

    public void setReservationID(Reservation reservationID) {
        this.reservationID = reservationID;
    }

    public void DisplayPackages(Packages pk) {

    }

    public Traveler Login(String Un, String pass) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");

        if (this.getRole() == "Traveler") {
            MongoCollection traveler = TouringSystem.getCollection("Traveler");
            Document tacc = (Document) traveler.find(Filters.eq("name", Un)).first();  // tacc refers to traveler account
            Traveler result = gson.fromJson(tacc.toJson(), Traveler.class);

            if (tacc.containsValue(Un) && tacc.containsValue(pass)) {
                System.out.println("Welcome, " + Un);
                return result;
            }
            else
                System.out.println("Invlaid Login");
             return null;    
        }
        return null;
    }

    public void UpdateAccount(Traveler t, String name, String password) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");

        if (t.getRole() == "Traveler") {
            MongoCollection traveler = TouringSystem.getCollection("Traveler");
            Document tacc = (Document) traveler.find(Filters.eq("ID", t.getID())).first();  // tacc refers to traveler account

            traveler.updateOne(Filters.eq("name", t.getName()), Updates.set("name", name));
            traveler.updateOne(Filters.eq("password", t.getPassword()), Updates.set("password", password));
            System.out.println("Upadte successfull");
        } else {
            System.out.println("Failed To Update");
        }
    }
}
