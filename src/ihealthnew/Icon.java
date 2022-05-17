/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihealthnew;

/**
 *
 * @author tanka
 */
import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class Icon {

    public static void main(String[] args) throws AWTException {
        if (SystemTray.isSupported()) {
            Icon td = new Icon();
            td.iconDisplay(Notification.getName(),Notification.getDate(),Notification.getTime());
        } else {
            System.err.println("System tray not supported!");
        }
    }

    public void iconDisplay(String Name, String Date,String Time) throws AWTException {
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

        trayIcon.displayMessage(Name + " i-Health appointment","Time :" + Time + "\tDate :" + Date, MessageType.INFO);
    }
}
