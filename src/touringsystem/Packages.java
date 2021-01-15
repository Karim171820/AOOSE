/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

import java.util.ArrayList; 
import java.util.Iterator;
/**
 *
 * @author Kemiaa
 */
public class Packages implements TravelerSubject {
    
    private int ID;
    private String name;
    private Airline airline;
    private Transportation transportation;
    private Hotel hotel;
    private int price;
    private ArrayList<TravelerObserver> observerList;

    public Packages(int ID, String name, Airline airline, Transportation transportation, Hotel hotel, int price) {
        this.ID = ID;
        this.name = name;
        this.airline = airline;
        this.transportation = transportation;
        this.hotel = hotel;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    
    @Override
    public void registerObserver(TravelerObserver o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(TravelerObserver o) {
       observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObserver() {
        for(Iterator<TravelerObserver> it = observerList.iterator(); it.hasNext();){
            TravelerObserver o = it.next();
            o.UpdatePackageData(ID, name, price);
        }
    }
    
    
}
