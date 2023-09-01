
public class Tester {

    public static void main(String[] args) {
        AddressUSA address = new AddressUSA();
        System.out.println(address);
        address.setAddressLine1("test");
        String line1 = address.getAddressLine1();
        System.out.println(address);
        System.out.println(line1);
        // The purpose of this class is to help us test
        // our AddressUSA implementation as we write it

    }

}
