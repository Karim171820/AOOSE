/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kemiaa
 */
public class TouringSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//Connection MongoDb
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");
        MongoCollection TravelerCollection = TouringSystem.getCollection("Traveler");
        MongoCollection AdminCollection = TouringSystem.getCollection("Admin");
        MongoCollection ReservationCollection = TouringSystem.getCollection("Reservation");
        MongoCollection PackageCollection = TouringSystem.getCollection("Packages");
//

        Traveler traveler = new Traveler();
        Packages pkg = new Packages();
        Admin admin = Admin.getInstance();
        Reservation Defaultreservation = new Reservation();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\t\t\t\tHello to Touring System");
        System.out.println("1)  SignUp");
        System.out.println("2)  Login As traveler ");
        System.out.println("3)  Login As Admin");
        System.out.println(" Choose one of them ");
        int num1 = sc.nextInt();
        String r = null;

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
                r = role;

                Traveler traveler1 = new Traveler(age, passportExpireDate, creditAmount, email, random.nextInt(1000), role, name, password, TravelerCollection);
                traveler = traveler1;
                break;
            case 2:
                r = "traveler";
                System.out.println("Enter UserName: ");
                String Un = sc.next();
                System.out.println("Enter Password : ");
                String pass = sc.next();
                System.out.println(pass);

                traveler = traveler.Login(Un, pass);
                System.out.println(traveler.email);
                break;
            case 3:
                r = "Admin";
                System.out.println("Enter UserName: ");
                String AdminUn = sc.next();
                System.out.println("Enter Password : ");
                String Adminpass = sc.next();
                System.out.println(Adminpass);
                admin.Login(AdminUn, Adminpass);
                break;
        }

        if (r == "traveler") {
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
                    Reservation reservation = new Reservation(random.nextInt(1000), traveler, "20/10/2020", pkg, ReservationCollection);
                    Defaultreservation = reservation;
                    System.out.println("IF You Want to Update Packge Press 1");
                    System.out.println("conintue Press 0");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("Choose A New package Name:  ");
                        String NewPackageName = sc.next();
                        Packages NewPackage = new Packages();
                        NewPackage = NewPackage.getPackagesByName(NewPackageName, PackageCollection);
                        Defaultreservation.UpdateReservation(Defaultreservation, NewPackage, ReservationCollection);

                    } else if (choice == 0) {
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Enter The New Name:");
                    String updatedName = sc.next();
                    System.out.println("Enter The New Password");
                    String updatedPassword = sc.next();
                    traveler.UpdateAccount(traveler, updatedName, updatedPassword);
                    break;
                case 4:
                    Defaultreservation.CancelReservation(traveler.getID());
                    break;

            }
        } else if (r == "Admin") {

            System.out.println("Choose on of these Options");
            System.out.println("    1) Update a Package    ");
            System.out.println("    2) Quit       ");

            int num3 = sc.nextInt();
            switch (num3) {
                case 1:
                    System.out.println("Enter a package name ");
                    String pkName = sc.next();
                    System.out.println("Enter new package ID ");
                    int NewpkID = sc.nextInt();
                    System.out.println("Enter new package name ");
                    String NewpkName = sc.next();
                    System.out.println("Enter new package price ");
                    int Newpkprice = sc.nextInt();

//                    System.out.println("Enter new Airline name ");
//                    String NewAirlinName = sc.next();
//                    System.out.println("Enter new Airport name ");
//                    String NewAirportName = sc.next();
//                    System.out.println("Enter new Ticket Price ");
//                    int NewTicketPrice = sc.nextInt();
//                    System.out.println("Enter new Arrival Date ");
//                    String NewArriavlDate = sc.next();
//                    System.out.println("Enter new Return Date ");
//                    String NewReturnDate = sc.next();
//                    System.out.println("Enter new Destination ");
//                    String NewDEstination = sc.next();
//                    System.out.println("Enter new Take off Time ");
//                    String NewTakeOff = sc.next();
//                    System.out.println("Enter new Landing Time  ");
//                    String NewLandinTime = sc.next();
//                    System.out.println("Enter new Flight Class");
//                    String NewFlightClass = sc.next();
//                    System.out.println("Enter new Transportation Price ");
//                    int Newtprice = sc.nextInt();
//                    System.out.println("Enter new  PickUp Location ");
//                    String NewPL = sc.next();

                    Packages DefaultPackage = new Packages();
                    DefaultPackage = DefaultPackage.getPackagesByName(pkName, PackageCollection);
                    
//                    Airline Newairline = new Airline(NewAirlinName, NewAirportName, NewTicketPrice, NewArriavlDate, NewReturnDate, NewDEstination, NewTakeOff, NewLandinTime, NewFlightClass);
//                    Hotel NewHotel = new Hotel();
//                    Transportation Newtrans = new Transportation(Newtprice, NewPL);

                    Packages Newpk = new Packages(NewpkID, NewpkName, Newpkprice);
                    admin.UpdatePackageData(DefaultPackage, Newpk, PackageCollection);
                    System.out.println("Press Q to Quit");
                    String quit = sc.next();
                    if ("q".equals(quit) || "Q".equals(quit)) {
                        System.exit(0);
                    }
                    break;

                case 2:
                    System.exit(0);
            }

        }
    }
}
