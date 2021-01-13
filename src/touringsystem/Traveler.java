/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;

/**
 *
 * @author Ahmed Kamal
 */
public class Traveler extends User {
    public int age;
    public String passportExpireDate;
    public int creditAmount;
    public String email;
//    public Reservation reservationID;

    public Traveler(int age, String passportExpireDate, int creditAmount, String email, int ID, String role, String name, String password) {
        super(ID, role, name, password);
        this.age = age;
        this.passportExpireDate = passportExpireDate;
        this.creditAmount = creditAmount;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportExpireDate() {
        return passportExpireDate;
    }

    public void setPassportExpireDate(String passportExpireDate) {
        this.passportExpireDate = passportExpireDate;
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void Login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
