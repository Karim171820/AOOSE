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
//        Dummy Data
        Traveler TempTraveler = new Traveler(27, "12/12/2024", 1500, "Someone@bue.edu.eg", 300, "Traveler", "Someone", "Someone123");
        Airline TempAirline = new Airline(30, "EGY", 400, 350, "11/10/2020", "22/10/2020", "Spain", "22:00", "03:00", "A-Class");
        Hotel TempHotel = new Hotel("Grand", "Aswan", 100);
        TransportationLeader TempTransportationLeader = new TransportationLeader(30, "Amer", "Amer123@bue", "010123323546");
        Transportation TempTransportation = new Transportation(TempTransportationLeader, 250, "Bus Stop");
        Packages TempPackage = new Packages(30, "Package Number1", TempAirline, TempTransportation, TempHotel, 2500);
//        Reservation TempReservation = new Reservation(30,TempTraveler,"10/10/2020",TempPackage,ReservationCollection);
// 

        Traveler traveler = new Traveler();
        Packages pkg = new Packages();
        Admin admin = Admin.getInstance();
        Reservation Defaultreservation = new Reservation();
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\t\t\tHello to Touring System");
        System.out.println("1)  SignUp");
        System.out.println("2)  Login As traveler ");
        System.out.println("3)  Login As Admin");
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

                Traveler traveler1 = new Traveler(age, passportExpireDate, creditAmount, email, 25, role, name, password, TravelerCollection);
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
                break;
            case 3:
                System.out.println("Enter UserName: ");
                String AdminUn = sc.next();
                System.out.println(AdminUn);
                System.out.println("Enter Password : ");
                String Adminpass = sc.next();
                System.out.println(Adminpass);
                admin.Login(AdminUn, Adminpass);
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
                pkg = pkg.getPackagesByName(PackageName, PackageCollection);
                pkg.getPackagesByName(PackageName, PackageCollection);
                System.out.println(pkg.getID());
                Reservation reservation = new Reservation(40, traveler, "20/10/2020", pkg, ReservationCollection);
                Defaultreservation= reservation;

                break;
            case 3:
                System.out.println("Enter The New Name:");
                String updatedName = sc.next();
                System.out.println("Enter The New Password");
                String updatedPassword = sc.next();
                traveler.UpdateAccount(traveler, updatedName, updatedPassword);
                break;
            case 4:
                Defaultreservation.CancelReservation(25);
                break;

        }
    }
}
