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
public class Traveler extends User implements TravelerObserver {

    public int age;
    public String passportExpire;
    public int creditAmount;
    public String email;
    public Reservation reservationID;
    private Gson gson = new Gson();

    //observer variables 
    private int opID;
    private String opname;
    private int opprice;

  public Traveler(int id, String role, String name,String password, int age, String passportExpire, int creditAmount, String email){
        super(id,role,name,password);
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
        MongoCollection TravelerCollection = TouringSystem.getCollection("Traveler");
         Document doc = new Document("role", "Traveler")
                .append("name", name).append("password", password).append("age", age)
                .append("passportExpire", passportExpire).append("creditAmount", creditAmount)
                .append("ID", id).append("email", email);
        TravelerCollection.insertOne(doc);
    }
    public Traveler(){
        super();
    }

    public Traveler(int age, String passportExpire, int creditAmount, String email, int ID, String role, String name, String password) {
        super(ID, role, name, password);
        this.age = age;
        this.passportExpire = passportExpire;
        this.creditAmount = creditAmount;
        this.email = email;
    }
    

    

    public Traveler(int age, String passportExpire, int creditAmount, String email, int ID, String role, String name, String password,MongoCollection TravelerCollection ) {
        super(ID, role, name, password);
        this.age = age;
        this.passportExpire = passportExpire;
        this.creditAmount = creditAmount;
        this.email = email;
                Document doc = new Document("role","Traveler")
                .append("name",name).append("password",password).append("age",age)
                .append("passportExpire",passportExpire).append("creditAmount",creditAmount)
                .append("ID", ID).append("email",email);
                TravelerCollection.insertOne(doc);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportExpireDate() {
        return passportExpire;
    }

    public void setPassportExpireDate(String passportExpire) {
        this.passportExpire = passportExpire;
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

        MongoCollection traveler = TouringSystem.getCollection("Traveler");
        Document tacc = (Document)traveler.find(Filters.eq("name", Un)).first();  // tacc refers to traveler account
        Traveler result = gson.fromJson(tacc.toJson(), Traveler.class);
        if (result.getName().equals(Un) && result.getPassword().equals(pass)) {
            System.out.println("Welcome, " + Un);
            return result;
        } else {
            System.out.println("Invlaid Login");
        }
        return null;

    }

    public void UpdateAccount(Traveler t, String name, String password) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");

        if ("Traveler".equals(t.getRole())) {
            MongoCollection traveler = TouringSystem.getCollection("Traveler");
            Document tacc = (Document) traveler.find(Filters.eq("ID", t.getID())).first();  // tacc refers to traveler account

            traveler.updateOne(Filters.eq("name", t.getName()), Updates.set("name", name));
            traveler.updateOne(Filters.eq("password", t.getPassword()), Updates.set("password", password));
            System.out.println("Upadte successfull");
        } else {
            System.out.println("Failed To Update");
        }
    }

    // Obserer update function 
    @Override
    public void UpdatePackageData(int ID, String name, int price) {
        this.opID = ID;
        this.opname = name;
        this.opprice = price;
    }
}