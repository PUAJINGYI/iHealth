
package ihealthnew;

import java.awt.AWTException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Notification {
     public static String Name;
     public static String Date;
     public static String Time;
    
    Timer timer;

    public static String getName() {
        return Name;
    }

    public static void setName(String Name) {
        Notification.Name = Name;
    }

    public static String getDate() {
        return Date;
    }

    public static void setDate(String Date) {
        Notification.Date = Date;
    }

    public static String getTime() {
        return Time;
    }

    public static void setTime(String Time) {
        Notification.Time = Time;
    }

    public Notification(String Name, String Date,String Time) {
        this.Name=Name;
        this.Date=Date;
        this.Time=Time;
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(2021,0,2,14,50,50);  // year,month(count form zero),day,hour,mins,second
        Date time = calendar.getTime();
        timer = new Timer();
        timer.schedule(new NotificationTask(),time);
	}

    class NotificationTask extends TimerTask {
        public void run() {

             Icon a=new Icon();
            try {
                a.iconDisplay(Name,Date,Time);
            } catch (AWTException ex) {
                Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
            }
            timer.cancel(); //Terminate the timer thread
          

           
        }
    }
}