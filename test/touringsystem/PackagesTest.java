/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.mongodb.client.MongoCollection;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author Ahmed Kamal
 */
public class PackagesTest {

    MongoClient client = new MongoClient();
    MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
    MongoCollection PackageCollection = TouringSystem.getCollection("Packages");

    public PackagesTest() {
    }

    /**
     * Test of getID method, of class Packages.
     */
    @Test
    public void testGetPackagesByName() {
        Packages p = new Packages();
        System.out.println(p.getPackagesByName("Luxury", PackageCollection));
    }

    /**
     * Test of getAllPackages method, of class Packages.
     */
    @Test
    public void testGetAllPackages() {
    }

    /**
     * Test of registerObserver method, of class Packages.
     */
    @Test
    public void testRegisterObserver() {
    }

    /**
     * Test of removeObserver method, of class Packages.
     */
    @Test
    public void testRemoveObserver() {
    }

    /**
     * Test of notifyObserver method, of class Packages.
     */
    @Test
    public void testNotifyObserver() {
    }

}
