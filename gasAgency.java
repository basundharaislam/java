package gasSupplier;

public interface gasAgency {
    public String agencyName = "BHARAT GAS";
    public int agencyCode = 12345;
    public int phNo = 123456789;
    public int pincode = 700010;

    default void agencyDisplay(){
        System.out.println("the agency name is: "+agencyName);
        System.out.println("the agency code is: "+agencyCode);
        System.out.println("the agency phone number is: "+phNo);
    }
}
