///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package touringsystem;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Filters;
//import com.mongodb.client.result.DeleteResult;
//import org.bson.Document;
//
///**
// *
// * @author pudu1
// */
//public class Reservation {
//
//    private int ID;
//    private String reservationDate;
////  private Traveler traveler;
////  private Hotel hotel;
////  private Airline airline;
////  private Transporation transportation;
////  private Packages package;
////    private Payment payment;
//
//  public Reservation(int id, String date,Traveler trav)
//  {
//      
//  }
//    public Reservation reserve(int id, Traveler trav,String reservationDate, Packages package) {
////database connection
//        MongoClient client = new MongoClient();
//        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
//        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
//        Document reservation = new Document("ID", id).
//    }
//    }
//    public String CancelReservation(int id) {
//        MongoClient client = new MongoClient();
//        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
//        MongoCollection reservartion = TouringSystem.getCollection("Reservation");
//        reservartion.deleteOne(Filters.eq("ID", id));
//        if (reservartion.find(Filters.eq("ID", id)).first()) {
//            return "reservation deleted";
//        }
//        return "reservation not deleted";
//
//    }
//}
