
package ihealthnew;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin {
    private String AdminUsername;
    private String AdminPassword;

    public Admin() {
    }

    public Admin(String AdminUsername, String AdminPassword) {
        this.AdminUsername = AdminUsername;
        this.AdminPassword = AdminPassword;
    }

    public String getAdminUsername() {
        String str="";
        try {
            Scanner in = new Scanner(new FileInputStream("admin.txt"));
                str = in.nextLine();

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");

    }
        String []UP=str.split(",");
        return UP[0];
  }
    public void setAdminUsername(String AdminUsername) {
        this.AdminUsername = AdminUsername;
    }

    public String getAdminPassword() {
                String str="";
        try {
            Scanner in = new Scanner(new FileInputStream("admin.txt"));
                str = in.nextLine();

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");

    }
        String []UP=str.split(",");
        return UP[1];
  }


    public void setAdminPassword(String AdminPassword) {
        this.AdminPassword = AdminPassword;
    }
    public void SaveAdmin(String AdminUsername,String AdminPassword){
        setAdminUsername(AdminUsername);
        setAdminPassword(AdminPassword);
        try {
   PrintWriter ToText = new PrintWriter(new FileOutputStream("admin.txt"));
   ToText.println(this.AdminUsername + "," + this.AdminPassword);
   ToText.close();
} catch (IOException e) {
   System.out.println("Problem with file output"); 
}
        
    }
    
}
