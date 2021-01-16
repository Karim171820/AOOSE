/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Kemiaa
 */
public interface PackageReadOnly {
    
     public void getAllPackages(MongoCollection PackageCollection);
     
}
