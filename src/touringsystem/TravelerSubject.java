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
public interface TravelerSubject {
    
  public void registerObserver(TravelerObserver o);
  public void removeObserver(TravelerObserver o);
  public void notifyObserver();
}
