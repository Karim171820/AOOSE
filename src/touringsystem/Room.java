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
public class Room {
   private int roomNo;
   private String accom;
   private String PricePerNight;
   private boolean Avaliable;
   private int roomCapacity;

    public Room(int roomNo, String accom, String PricePerNight, boolean Avaliable, int roomCapacity) {
        this.roomNo = roomNo;
        this.accom = accom;
        this.PricePerNight = PricePerNight;
        this.Avaliable = Avaliable;
        this.roomCapacity = roomCapacity;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getAccom() {
        return accom;
    }

    public void setAccom(String accom) {
        this.accom = accom;
    }

    public String getPricePerNight() {
        return PricePerNight;
    }

    public void setPricePerNight(String PricePerNight) {
        this.PricePerNight = PricePerNight;
    }

    public boolean isAvaliable() {
        return Avaliable;
    }

    public void setAvaliable(boolean Avaliable) {
        this.Avaliable = Avaliable;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }
   
}
