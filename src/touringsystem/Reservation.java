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
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

/**
 *
 * @author pudu1
 */
public class Reservation {

    private int ID;
    private Traveler traveler;
    private String reservationDate;
    private Packages packag;
    private Payment payment;

    // constructors
    public Reservation() {
    }

    public Reservation(int ID, Traveler traveler, String reservationDate, Packages packag, Payment payment) {
        this.ID = ID;
        this.traveler = traveler;
        this.reservationDate = reservationDate;
        this.packag = packag;
        this.payment = payment;
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

    public Payment getPayment() {
        return payment;
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

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    //______________________________________________________________________________
    // functions

    public Reservation reserve(int id, Traveler trav, String reservationDate, Packages packag, Payment payment) {
// database connection
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
        
        // create object of reservation
        Reservation reserve = new Reservation(id, trav, reservationDate, packag, payment);
        // create query 
        Document query = new Document("ID", id)
                .append("traveler.age", trav.getAge())                                     
                .append("traveler.tID", trav.getID())
                .append("traveler.passportExpireDa_", trav.getPassportExpireDate())
                .append("traveler.email", trav.getEmail())
                .append("reservationDate", reservationDate)
                .append("package.ID", packag.getID())
                .append("package.name", packag.getName())
                .append("package.Price", packag.getPrice())
                .append("payment.PaymentID", payment.getID())
                .append("payment.PaymentMethode", payment.getPaymnetMethod());
        //insert into class reservation
        reservartion.insertOne(query);
        return reserve;
    }

    public String CancelReservation(int id) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
        reservartion.deleteOne(Filters.eq("ID", id));// delete from DB based in ID
        Document find = (Document) reservartion.find((Filters.eq("ID", id)));
        if (find == null) {     //check if the delete is successfull
            return "reservation deleted";
        }
        return "reservation not deleted";
    }

//    public void UpdateReservation(int id, Traveler trav, String reservationDate, Packages packag, Payment payment) {
//        MongoClient client = new MongoClient();
//        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
//        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
//        Reservation reserve = new Reservation(id, trav, reservationDate, packag, payment);
//        Document query =new Document();
//    }
}
