/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;
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
        MongoCollection TravelerCollection = TouringSystem.getCollection("Traveler");
        MongoCollection AdminCollection = TouringSystem.getCollection("Admin");
        MongoCollection ReservationCollection = TouringSystem.getCollection("Reservation");
        MongoCollection PackageCollection = TouringSystem.getCollection("Packages");
        Traveler TempTraveler= new Traveler(27,"12/12/2024",1500,"Someone@bue.edu.eg",300, "Traveler","Someone","Someone123");
//        Airline TempAirline = new 
//        Package TempPackage = new Package();
//        Traveler trav = new Traveler(30, "Traveler", "sherif","sherif", 32,"24/01/2025" , 200000, "sherif@email.com");
       
              Traveler traveler = new Traveler();
              Packages packages = new Packages();
        Scanner sc=new Scanner(System.in);  

        System.out.println("\t\t\t\tHello to Touring System");
        System.out.println("1)  SignUp" );
        System.out.println("2)   Login");
        System.out.println(" Choose one of them ");
        int num1 = sc.nextInt();
        
        switch (num1) {
            case 1: 
                System.out.println("Enter name: ");
                String name = sc.next();
                System.out.println("Enter age: ");
                int age = sc.nextInt();
                System.out.println("Enter password: ");
                String password = sc.next();
                System.out.println("Enter email: ");
                String email = sc.next();
                System.out.println("Enter passportExpireDate: ");
                String passportExpireDate = sc.next();
                System.out.println("Enter creditAmount: ");
                int creditAmount = sc.nextInt();
                System.out.println("Enter role: ");
                String role = sc.next();
                
                Traveler traveler1 = new Traveler(age,passportExpireDate,creditAmount,email,25,role,name,password,TravelerCollection);
                    break;
            case 2:
                System.out.println("Enter UserName: ");
                String Un = sc.next();
                System.out.println(Un);
                System.out.println("Enter Password : ");
                String pass = sc.next();
                System.out.println(pass);
          
                traveler = traveler.Login(Un, pass);
                System.out.println(traveler.email);
            case 3:
                break;
        }
        System.out.println("Choose on of these Options");
        System.out.println("    1) Display All Packages    ");
        System.out.println("    2) Reserve a Package       ");
        System.out.println("    3) UpdateAccount              ");
        System.out.println("    4) Cancel Reservation       ");
        
            int num2 = sc.nextInt();
        switch (num2) {
        case 1:
            PackageReadOnly PRO = new Packages();
            PRO.getAllPackages(PackageCollection);
        break;
        case 2: 
                        System.out.print("Enter PackageName: ");
                String PackageName = sc.next();
                packages =  packages.getPackagesByName(PackageName, PackageCollection);
                packages.getPackagesByName(PackageName, PackageCollection);
                System.out.println( packages.getID());
            break;
        case 3:
            System.out.println("Enter The New Name:");
            String updatedName = sc.next();
            System.out.println("Enter The New Password");
            String updatedPassword = sc.next();
            traveler.UpdateAccount(traveler, updatedName, updatedPassword);
            break;
        case 4:
                
        }
    }
}
