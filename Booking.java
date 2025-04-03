package gasBooking;
import customers.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {

    public double otp= 1234, amount= 990, refund=0;
    public String delDate, status,delMobileNo= "9061795610",dt;
    public Date  dt_1 , dt_2;

    public Booking(String name, String street, String area, String city, String state, String zip, String phone, int numberOfCylinders) {
        super(name, street, area, city, state, zip, phone, numberOfCylinders);
    }

    public void getDates() {
        System.out.println("enter booking date");
        dt = new Scanner(System.in).next();
        dt_1 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (Exception e) {
            System.out.println(" the error in getDates function" + e);
        }

        //delivery details
        System.out.println("enter delivery date");
        delDate = new Scanner(System.in).nextLine();
        try {
            dt_2 = dateFormat.parse(delDate);
        } catch (Exception e) {
            System.out.println("error parsing second date" + e);
        }

        //find the difference between two dates
        try {
            long difference = dt_2.getTime() - dt_1.getTime();

            //difference in days
            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
            if (newDifference > 7) {
                status = "p";//pending
            }
        } catch (Exception e) {
            System.out.println("error while finding the difference  " + e);
        }
    }

        public void validate() {
            //get the diff btwn two dates
             long elapsedms= dt_1.getTime() - lastDate.getTime();
             long diff= TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);

             System.out.println("diff btwn two date is: "+ diff);
             if(numberOfCylinders==1){
                 if(diff<30){
                     System.out.println("cannot book");
                     status= "c";
                 }
                 else{
                     // System.out.println("status: booked");
                     status= "b";
                     lastDate= dt_1;
                 }
             }else if(numberOfCylinders==2){
                 if(diff<50){
                     System.out.println("cannot book");
                     //numberOfCylinders=0;
                     status ="c";
                 }
                 else{
                     status= "b";
                     lastDate= dt_1;
                 }

            }

        }
    }

