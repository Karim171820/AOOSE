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
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

/**
 *
 * @author abdelrahman amer
 */
public class Reservation {

    private int ID;
    private Traveler traveler;
    private String reservationDate;
    private Packages packag;
//    private Payment payment;

    // constructors
    public Reservation() {
    }

    public Reservation(int ID, Traveler trav, String reservationDate, Packages packag, MongoCollection ReservationCollection) {
        this.ID = ID;
        this.traveler = trav;
        this.reservationDate = reservationDate;
        this.packag = packag;
        
        Document traveller = new Document();
        traveller.append("tID", trav.getID())
                .append("age", trav.getAge())
                .append("passportExpireDa_", trav.getPassportExpireDate())
                .append("email", trav.getEmail());
        
        Document pkg = new Document();
        pkg.append("ID", packag.getID())
                .append("name", packag.getName())
                .append("Price", packag.getPrice());
        
        Document query = new Document("ID", ID)
                .append("reservationDate", reservationDate)
                .append("traveler", traveller)
                .append("package", pkg);
                
                
        ReservationCollection.insertOne(query);
        
        
    }

//_________________________________________________________________________
    // getters
    public int getID() {
        return ID;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public Packages getPackag() {
        return packag;
    }



//_________________________________________________________________________
    //setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setPackag(Packages packag) {
        this.packag = packag;
    }
    //______________________________________________________________________________
    // functions


    public String CancelReservation(int id) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
        
        
        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
        reservartion.deleteOne(Filters.eq("traveler.tID", id)); // delete from DB based in ID
            return "reservation deleted";
    }

//    public void UpdateReservation(int id, Traveler trav, String reservationDate, Packages packag, Payment payment) {
//        MongoClient client = new MongoClient();
//        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
//        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
//        Reservation reserve = new Reservation(id, trav, reservationDate, packag, payment);
//        Document query =new Document();
//    }
    public void UpdateReservation(Reservation reserve, int n_id, String n_name, int n_price) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
        
        
        Document query = (Document) reservartion.find(Filters.eq("ID", reserve.ID)).first();  // get the desired reservation based on ID
        reservartion.updateOne(Filters.eq("package.ID", reserve.ID), Updates.set("package.ID", n_id));
        reservartion.updateOne(Filters.eq("package.name", reserve.getPackag().getName()), Updates.set("package.name", n_name));
        reservartion.updateOne(Filters.eq("package.Price", reserve.getPackag().getPrice()), Updates.set("package.Price", n_price));
        
    }

}
