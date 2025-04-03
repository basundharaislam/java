import customers.*;
import gasBooking.*;
import gasSupplier.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static gasSupplier.gasAgency.*;

public class Main {
    static int count;
    static int bcount=0, ccount=0, dcount=0, pcount=0;
    static String dpname;
    public static void cylinderCount(Delivery[] obj){
        String[] months= new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug",
        "sep", "oct", "nov", "dec"};

        for(Delivery delivery: obj){
            count=0;
            System.out.println("in the month of"+ (months[delivery.dt_2.getMonth()])+ ":");
            System.out.println("* in "+ delivery.area);
            if(delivery.status.equals("d")){
                count+=delivery.numberOfCylinders;
            }
            System.out.println(" - "+count+" cylinders delivered");
        }
        System.out.println("\n");

    }

    public static void checkLateDelivery(Delivery[] obj){
        String[] months= new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug",
                "sep", "oct", "nov", "dec"};
        int[] month= new int[12];

        for(Delivery delivery: obj){
            if(delivery.status.equals("d")&& delivery.amount==759.7){
                month[delivery.dt_2.getMonth()]++;

            }
        }
        System.out.println(" -----------------late delivery------------------- ");
        for (int i=0; i<12; i++){
            if(month[i]!=0){
                System.out.println("in "+ months[i] + "there are" + month[i]);
            }
        }
        System.out.println("\n");

    }

    public static void numOfCylinders(Delivery[] obj) {
        System.out.println(" ----single cylinder holders---- ");
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].numberOfCylinders == 1) {
                System.out.println(" customer name:  " + obj[i].name);
                System.out.println(" mobile number: " + obj[i].phone);
                System.out.println(" gas connection number: " + (i + 101));
            }
        }
        System.out.println("\n");
    }

    public static void deliveryDetails(Delivery[] obj){
        System.out.println(" -----delivery details---- ");
        System.out.println(" enter name of delivery person ");
        dpname= new Scanner(System.in).next();
        for (Delivery delivery: obj) {
            if(delivery.status.equals("d")&& delivery.name.equals(dpname)){
                System.out.println(" customer name: " + delivery.name);
                System.out.println(" - " + delivery.street+","+delivery.area+"," +delivery.city +","+delivery.state+ ","+
                        delivery.zip);
            }
        }
        System.out.println("\n");
    }

    public static void printReport(Delivery[] obj){
        System.out.println(" ------delivery report---- ");
        for(int i=0; i<obj.length; i++){
            if(obj[i].status.equals("d")){
                dcount++;
            }
            else if(obj[i].status.equals("p")){
                pcount++;
            }
            else if(obj[i].status.equals("c")){
                ccount++;
            }
            else if(obj[i].status.equals("b")){
                bcount++;
            }
            else
                System.out.println("status invalid");
        }
        System.out.println("booked");
        System.out.println("-"+ bcount+ "booked");
        System.out.println("delivered");
        System.out.println("-"+ dcount+ "delivered");
        System.out.println("cancelled");
        System.out.println("-"+ ccount+ "cancelled");
        System.out.println("pending");
        System.out.println("-"+ pcount+ "pending");
        System.out.println("\n");
    }

    public static void printInvoice(Delivery[] obj){
        Date d= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate= sdf.format(d);
        for(int i=0; i<obj.length; i++){
            if(obj[i].status.equals("d")){
                System.out.println("------------------------------------------");
                System.out.println(" INVOICE ");
                System.out.println("------------------------------------------");
                System.out.println("Gas Agency Code: "+ agencyCode + "\t\t\t" + "Date Of Invoice: "+ invoiceDate);
                System.out.println("Gas Agency Name: "+ agencyName + "\t\t\t" + "Agency Phone Number: "+ phNo);
                System.out.println("Gas Connection Number: "+(i+101)+ "\t\t\t"+ "Customer Name" + obj[i].name);
                System.out.println("Booking Date: "+ sdf.format(obj[i].dt_1)+ "\t\t\t"+ " Customer Mobile No: "+obj[i].phone);
                System.out.println("------------------------------------------");
                System.out.println("Amount: "+ obj[i].amount);
                System.out.println("Refund: "+obj[i].refund);
                System.out.println("Total Amount: "+ (obj[i].amount-obj[i].refund));
                System.out.println("------------------------------------------");
                System.out.println("Delivery Person Name: "+ obj[i].delPersonName + "Delivery Person Mobile: "+ obj[i].delMobileNo);
                System.out.println("Delivery Date: "+ sdf.format(obj[i].dt_2));
                System.out.println(" ------------------------------------------");
                System.out.println("\n\n");

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("*********************************************************");
        System.out.println(" GAS AGENCY ");
        System.out.println("*********************************************************");
        Delivery[] deliveryObject = new Delivery[6];
        deliveryObject[0] = new Delivery("ARUNDHATI", "21 B ", "KUDGHAT", "KOLKATA", "WB", "700123",
                "9999888810", 1);
        deliveryObject[1] = new Delivery("ANUSHUA", "144 A", "HOWRAH", "HOWRAH", "WB", "700013", "9000344523", 2);
        deliveryObject[2] = new Delivery("BASUNDHARA", "14/1", "PARK CIRCUS", "KOLKATA", "WB", "700019", "9051705910", 1);
        deliveryObject[3] = new Delivery("AVIKA", "12 B", "OPD", "LUCKNOW", "UP", "200122", "9003224768", 1);
        deliveryObject[4] = new Delivery("ASTHA", "31 C", "RAMGARH", "BANARAS", "UP", "2000322", "8905432100",1);
        deliveryObject[5] = new Delivery("ANUSHKA", "11A", "GOPALPUR", "SILIGURI", "WB", "600019", "7789882645",2);

        for (Delivery delivery : deliveryObject) {
            delivery.delPersonDetails();
            delivery.getLastDate();
            delivery.getDates();
            delivery.validate();
            delivery.amtCalc();
            delivery.verifyOtp();
        }

        System.out.println();
        cylinderCount(deliveryObject);
        checkLateDelivery(deliveryObject);
        numOfCylinders(deliveryObject);
        deliveryDetails(deliveryObject);
        printReport(deliveryObject);
        printInvoice(deliveryObject);



    }
}
