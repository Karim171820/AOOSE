/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touringsystem;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
/**
 *
 * @author Ahmed Kamal
 */
public class Admin extends User {
    
    private static Admin admin = null;
    private Gson gson = new Gson();

    private Admin(int ID, String role, String name, String password) {
        super(ID, role, name, password);
    }
    
    public static Admin getInstance() {

        if (admin == null) {
            admin = new Admin(1, "admin","Ahmed Kamal","Complex");
            return admin;
        } else
            return admin;
    }

    
    public Admin Login(String Un, String pass) {
        MongoClient client = new MongoClient();
        MongoDatabase TouringSystem = client.getDatabase("TouringSystem");

        if ("admin".equals(this.getRole())) {

            MongoCollection admin = TouringSystem.getCollection("Admin");
            Document Aacc = (Document) admin.find(Filters.eq("name", Un)).first();  // Aacc refers to traveler account
            Admin result = gson.fromJson(Aacc.toJson(), Admin.class);


            if (Aacc.containsValue(Un) && Aacc.containsValue(pass)) {
                System.out.println("Welcome, " + Un);
                return result;
            }
            else
                System.out.println("Invlaid Login");
             return null;    
        }
        return null;
    }
    
    private void UpdatePackage(Package pack){
        
    }  
}
