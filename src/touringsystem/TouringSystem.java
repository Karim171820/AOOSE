/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Kemiaa
 */
public class TouringSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
              MongoClient client = new MongoClient();
              MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
              MongoCollection Traveler  = TouringSystem.getCollection("Traveler ");
              MongoCollection Hotel = TouringSystem.getCollection("Hotel");
//              Document Doc1 = new Document ("role","Traveler").append("name", "Khaled").append("password","2323232").append("age",25);
//              Traveler .insertOne(Doc1);
// comment 1
    }
}
