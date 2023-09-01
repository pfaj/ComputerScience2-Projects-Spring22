import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Contact {
    private  String name;
    private String email;
    private String number;

    private String address;
    public Contact(String name,String email, String number, String address){
        setName(name);
        setEmail(email);
        setNumber(number);
        setAddress(address);
    }

    public Contact(){
        this("","","","");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        if(number.length() > 10) {
            this.number = "Invalid Number";
        }else{
            String areaCode = number.substring(0,3);
            String middle = number.substring(3,6);
            String end = number.substring(6, 10);
            number = "(" + areaCode + ")-"+ middle + "-" + end;
            this.number = number;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String format = "Contact=[name=%s, email=%s, number=%s, address=%s]";
        String str = String.format(format,name,email,number,address);
        return str;
    }
}
