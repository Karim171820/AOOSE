/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

/**
 *
 * @author Kemiaa
 */
public class Payment {
    
    private  int ID;
    private String PaymnetMethod;
    private  Traveler TravelerData;
    private Reservation ReservationData;
    private Package packageprice;

    public Payment(int ID, String PaymnetMethod, Traveler TravelerData, Reservation ReservationData, Package packageprice) {
        this.ID = ID;
        this.PaymnetMethod = PaymnetMethod;
        this.TravelerData = TravelerData;
        this.ReservationData = ReservationData;
        this.packageprice = packageprice;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPaymnetMethod() {
        return PaymnetMethod;
    }

    public void setPaymnetMethod(String PaymnetMethod) {
        this.PaymnetMethod = PaymnetMethod;
    }

    public Traveler getTravelerData() {
        return TravelerData;
    }

    public void setTravelerData(Traveler TravelerData) {
        this.TravelerData = TravelerData;
    }

    public Reservation getReservationData() {
        return ReservationData;
    }

    public void setReservationData(Reservation ReservationData) {
        this.ReservationData = ReservationData;
    }

    public Package getPackageprice() {
        return packageprice;
    }

    public void setPackageprice(Package packageprice) {
        this.packageprice = packageprice;
    }
    
    
}
