
package ihealthnew;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Patient {
    private String FullName;
    private String IC;
    private String Phone;
    private int AppointmentHour;
    private int AppointmentMinute;

    public Patient(String FullName, String IC, String Phone) {
        this.FullName = FullName;
        this.IC = IC;
        this.Phone = Phone;
    }

    public Patient(String FullName, String IC) {
        this.FullName = FullName;
        this.IC = IC;
    }

    public Patient() {
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getIC() {
        return IC;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getAppointmentHour() {
        return AppointmentHour;
    }

    public void setAppointmentHour(int AppointmentHour) {
        this.AppointmentHour = AppointmentHour;
    }

    public int getAppointmentMinute() {
        return AppointmentMinute;
    }

    public void setAppointmentMinute(int AppointmentMinute) {
        this.AppointmentMinute = AppointmentMinute;
    }
    public boolean CheckPatientDuplicate(String FullName, String IC){
        String str;
        String [] Str=new String [3];
        try {
            Scanner in = new Scanner(new FileInputStream("Patient.txt"));
            while(in.hasNextLine()){
                str=in.nextLine();
                Str=str.split(",");
                if(Str[0].equals(FullName) && Str[1].equals(IC)){
                return true;
                }
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");

    }
       return false;
    }
                public void iconDisplay(String Name, String OfferTime, String OfferDate) throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray iconTray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        iconTray.add(trayIcon);

        trayIcon.displayMessage(Name + " I-Health appointment", OfferTime + " " + OfferDate, TrayIcon.MessageType.INFO);
    }
    public void SavePatient(){ 
        try {
   PrintWriter ToText = new PrintWriter(new FileOutputStream("Patient.txt",true));
   ToText.println(FullName + "," + IC + "," + Phone);
   ToText.close();
} catch (IOException e) {
   System.out.println("Problem with file output"); 
}
}

}