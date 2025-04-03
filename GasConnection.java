package customers;

import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customers{
    public int numberOfCylinders;
    String date;
    static int connectionNumber= 100;
    {
        connectionNumber += 1;
    }
    public Date lastDate= null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String name, String street, String area, String city,
                         String state, String zip, String phone, int numberOfCylinders) {
        super(name, street, area, city, state, zip, phone);
        this.numberOfCylinders = numberOfCylinders;
    }
    public void getLastDate() {
        System.out.println("enter the last date");
         date = new Scanner(System.in).nextLine();

         try{
             lastDate = sdf.parse(date);
         }
         catch(Exception e) {
             System.out.println("error in lastDate" + e);
         }

        }
    }

