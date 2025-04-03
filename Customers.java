package customers;
import gasSupplier.gasAgency;

public class Customers {
    public String name;
    public String street;
    public String area;
    public String city;
    public String state;
    public String zip;
    public String phone;

    //constructor
    public Customers(String name, String street, String area, String city,String state,String zip,
                     String phone) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }
}
