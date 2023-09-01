import java.util.Scanner;

public class main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);


        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Number: ");
        String number = input.nextLine();

        System.out.print("Address: ");
        String address = input.nextLine();

        Contact contact= new Contact(name, email,number, address);
        System.out.println(contact);
        contact.setNumber("7867170967");
    }
}
