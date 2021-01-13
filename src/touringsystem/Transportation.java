package touringsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adnan
 */
public class Transportation {
    private TransportationLeader transportationLeader;
    private int TransportationPrice;
    private String PickupLocation;

    public Transportation(TransportationLeader transportationLeader, int TransportationPrice, String PickupLocation) {
        this.transportationLeader = transportationLeader;
        this.TransportationPrice = TransportationPrice;
        this.PickupLocation = PickupLocation;
    }

    public TransportationLeader getTransportationLeader() {
        return transportationLeader;
    }

    public void setTransportationLeader(TransportationLeader transportationLeader) {
        this.transportationLeader = transportationLeader;
    }

    public int getTransportationPrice() {
        return TransportationPrice;
    }

    public void setTransportationPrice(int TransportationPrice) {
        this.TransportationPrice = TransportationPrice;
    }

    public String getPickupLocation() {
        return PickupLocation;
    }

    public void setPickupLocation(String PickupLocation) {
        this.PickupLocation = PickupLocation;
    }
    
}
