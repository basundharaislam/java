package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking {

    public String delPersonName;
    int customerOtp;


    public Delivery(String name, String street, String area, String city, String state, String zip, String phone, int numberOfCylinders) {
        super(name, street, area, city, state, zip, phone, numberOfCylinders);
    }
    public void amtCalc(){
        long dayDiff= dt_2.getTime() - dt_1.getTime();
        long newDiff= TimeUnit.DAYS.convert(dayDiff, TimeUnit.MILLISECONDS);

        if(newDiff>7){
            refund= 40.3;
            amount=amount-refund;
        }
    }
    public void verifyOtp(){
        if(status.equals("b")){
            System.out.println("enter Otp");
            customerOtp=new Scanner(System.in).nextInt();

            if(customerOtp!=0){
                status="c";//cancelled
            }else{
                status="d";//delivered
            }
        }else{
            System.out.println("no booking found");
        }
    }
    public void delPersonDetails(){
        System.out.println("enter person name");
        delPersonName=new Scanner(System.in).nextLine();
    }
}
