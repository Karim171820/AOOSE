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
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

/**
 *
 * @author Ahmed Kamal
 */
public class Admin extends User {

    private static Admin admin = null;
    private Gson gson = new Gson();

    private Admin(int ID, String role, String name, String password) {
        super(ID, role, name, password);
    }

    public static Admin getInstance() {

        if (admin == null) {
            admin = new Admin(1, "admin", "Ahmed Kamal", "Complex");
            return admin;
        } else {
            return admin;
        }
    }

    public Admin Login(String Un, String pass) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");

        MongoCollection admin = TouringSystem.getCollection("Admin");
        Document tacc = (Document) admin.find(Filters.eq("name", Un)).first();  // tacc refers to traveler account
        Admin result = gson.fromJson(tacc.toJson(), Admin.class);
        if (result.getName().equals(Un) && result.getPassword().equals(pass)) {
            System.out.println("Welcome, " + Un);
            return result;
        } else {
            System.out.println("Invlaid Login");
        }
        return null;
    }

    public void UpdatePackageData(Packages pkg, Packages Newpack,MongoCollection PackageCollection) {

        Document query = (Document) PackageCollection.find(Filters.eq("name", pkg.getName())).first();  // get the desired reservation based on ID
        if (query != null) {
            PackageCollection.updateOne(Filters.eq("ID", pkg.getID()), Updates.set("ID", Newpack.getID()));
            PackageCollection.updateOne(Filters.eq("name", pkg.getName()), Updates.set("name", Newpack.getName()));
            PackageCollection.updateOne(Filters.eq("price", pkg.getPrice()), Updates.set("price", Newpack.getPrice()));

//            PackageCollection.updateOne(Filters.eq("airline.name", pkg.getAirline().getName()), Updates.set("airline.name", NewAirline.getName()));
//            PackageCollection.updateOne(Filters.eq("airline.AirPortName", pkg.getAirline().getAirPortName()), Updates.set("airline.AirPortName", NewAirline.getAirPortName()));
//            PackageCollection.updateOne(Filters.eq("airline.ticketPrice", pkg.getAirline().getPriceTicket()), Updates.set("airline.ticketPrice", NewAirline.getPriceTicket()));
//            PackageCollection.updateOne(Filters.eq("airline.arrivalDate", pkg.getAirline().getArrivalDate()), Updates.set("airline.arrivalDate", NewAirline.getArrivalDate()));
//            PackageCollection.updateOne(Filters.eq("airline.ReturnDate", pkg.getAirline().getReturnDate()), Updates.set("airline.ReturnDate", NewAirline.getReturnDate()));
//            PackageCollection.updateOne(Filters.eq("airline.Destination", pkg.getAirline().getDestination()), Updates.set("airline.Destination", NewAirline.getDestination()));
//            PackageCollection.updateOne(Filters.eq("airline.TakeoffTime", pkg.getAirline().getTakeOffTime()), Updates.set("airline.TakeoffTime", NewAirline.getTakeOffTime()));
//            PackageCollection.updateOne(Filters.eq("airline.LandingTime", pkg.getAirline().getLandingTime()), Updates.set("airline.LandingTime", NewAirline.getLandingTime()));
//            PackageCollection.updateOne(Filters.eq("airline.FlightClass", pkg.getAirline().getFlightClass()), Updates.set("airline.FlightClass", NewAirline.getFlightClass()));
//  
//            PackageCollection.updateOne(Filters.eq("Transportation.TransportationPrice", pkg.getTransportation().getTransportationPrice()), Updates.set("Transportation.TransportationPrice", NewTrans.getTransportationPrice()));
//            PackageCollection.updateOne(Filters.eq("Transportation.PickupLocation", pkg.getTransportation().getPickupLocation()), Updates.set("Transportation.PickupLocation", NewTrans.getPickupLocation()));
        } else {
            System.out.println("Update failed ");
        }
    }
}
