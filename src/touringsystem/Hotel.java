package touringsystem;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;

import org.bson.Document;
import java.util.ArrayList;

import java.util.Iterator;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adnan
 */
public class Hotel {
    private String name;
    private String address;
    private int totalNumberOfRooms;
    private int roomsAvailable;
    public ArrayList<Room> room;

    public Hotel(String name, String address, int totalNumberOfRooms) {
        this.name = name;
        this.address = address;
        this.totalNumberOfRooms = totalNumberOfRooms;
    }

    public Hotel() {
    }
    
    
   public void checkAvailableRoom(ArrayList<Room> room){
       MongoClient mongoClient = new MongoClient("localhost", 27017);
       MongoDatabase database = mongoClient.getDatabase("TouringSystem");
       MongoCollection<Document> collection = database.getCollection("Hotel");
       Document query = new Document();
       query.put("rooms.Available", false);
       FindIterable<Document> iterDoc = collection.find(query);
       Iterator it = iterDoc.iterator();
       while(it.hasNext()){
           System.out.println(it.next());
       }

    }
}
