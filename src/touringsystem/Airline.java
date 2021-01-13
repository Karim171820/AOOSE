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
public class Airline {
    private int ID;
    private String AirPortName;
    private int PriceTicket;
    private int planCapacity;
    private String arrivalDate;
    private String returnDate;
    private String destination;
    private String takeOffTime;
    private String landingTime;
    private String flightClass;

    public Airline(int ID, String AirPortName, int PriceTicket, int planCapacity, String arrivalDate, String returnDate, String destination, String takeOffTime, String landingTime, String flightClass) {
        this.ID = ID;
        this.AirPortName = AirPortName;
        this.PriceTicket = PriceTicket;
        this.planCapacity = planCapacity;
        this.arrivalDate = arrivalDate;
        this.returnDate = returnDate;
        this.destination = destination;
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
        this.flightClass = flightClass;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAirPortName() {
        return AirPortName;
    }

    public void setAirPortName(String AirPortName) {
        this.AirPortName = AirPortName;
    }

    public int getPriceTicket() {
        return PriceTicket;
    }

    public void setPriceTicket(int PriceTicket) {
        this.PriceTicket = PriceTicket;
    }

    public int getPlanCapacity() {
        return planCapacity;
    }

    public void setPlanCapacity(int planCapacity) {
        this.planCapacity = planCapacity;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(String takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public String getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(String landingTime) {
        this.landingTime = landingTime;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
    
    
}
