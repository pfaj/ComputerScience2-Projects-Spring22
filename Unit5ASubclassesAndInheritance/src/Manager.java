import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) {

        // 1. Check out the basics of PhoneContact class:
        //    - fields
        //    - toString
        //    - default constructor
        //    - setters
        //    - getters
        //    - secondary getters

        PhoneContact pc = new PhoneContact();
        System.out.println("pc (default constructor): " + pc);

        pc.setName("Zoe");
        System.out.println("pc (setName): " + pc);

        pc.setHome("202-827-2021");
        System.out.println("pc (setHome): " + pc);

        pc.setWork("716-350-1875");
        System.out.println("pc (setWork): " + pc);

        boolean[] abbrs = {true, false};
        for (boolean abbr : abbrs) {
            String nums = pc.getNumbers(abbr);
            System.out.printf("getNumbers(%s): %s\n", abbr, nums);
        }

        System.out.println("getInfo(): " + pc.getInfo());
        System.out.println();


		// 2. Check out the SmartContact class bit by bit

		//    - extends PhoneContact
		//    - default constructor implicitly uses PhoneContact() default
		//      constructor (use debug mode to observe this)
		SmartContact sc = new SmartContact();
		System.out.println("sc (default constructor): " + sc);


		//    - observe that the PhoneContact setters can be called
		//      but don't appear in the SmartContact class
		sc.setCell("652-921-3227");
		System.out.println("sc (setCell): " + sc);

		sc.setName("Yama");
		System.out.println("sc (setName): " + sc);

		sc.setHome("253-382-7918");
		System.out.println("sc (setHome): " + sc);

		sc.setWork("312-412-7996");
		System.out.println("sc (setWork): " + sc);

		//    - observe that the getNumbers() method includes all fields via
		//      overriding and use of the keyword super
		for (boolean abbr : abbrs) {
			String nums = sc.getNumbers(abbr);
			System.out.printf("getNumbers(%s): %s\n", abbr, nums);
		}

		//    - observe that the getInfo() method also uses all fields, but
		//      is not overridden in SmartContact!  How does this happen?
		System.out.println("getInfo(): " + sc.getInfo());

		//    - observe that the custom constructor includes the user of
		//      super in order to involve the PhoneContact custom constructor
		sc = new SmartContact("Yis", "", "540-954-6541", "540-888-1510");
		System.out.println("sc (custom constructor): " + sc);
		System.out.println();


		// review of inheritance concepts:
		// - extending a class (subclass/superclass or child/parent)
		// - overriding a method and using super to access parent method
		//   - example in getNumbers
		//   - example in toString
		// - using super to explicitly invoke parent custom constructor
		// - getInfo(): actual object type dictates which method to run


		// 3. @Override is used for toString() in SmartContact
		//    but why is @Override used for toString() in PhoneContact?


		// 3b. 3 different ways to construct a SmartContact object
		sc = new SmartContact();
		pc = new SmartContact();
		Object obj = new SmartContact();


		// 3c. only 2 different ways to create a PhoneContact object
		pc = new PhoneContact();
		obj = new PhoneContact();
		// sc = new PhoneContact(); // this doesn't work


		// 3d. only 1 way to make an Object object
		obj = new Object();
		// pc = new Object(); // this doesn't work
		// sc = new Object(); // this doesn't work


		// 3e. Casting can be used when a superclass reference is to a
		//     subclass type *and* we want access to the subclass methods.
		pc = new SmartContact("Xan", "336-633-1234", "336-222-1111", "336-555-5555");
		System.out.println(pc);
		// System.out.println(pc.getCell()); // this doesn't work
		// sc = pc; // this doesn't work
		sc = (SmartContact)(pc);
		System.out.println(sc.getCell());
		System.out.println();



		// 4. An ArrayList<PhoneContact> can store 2 types of objects:
		//    - Actual PhoneContact objects
		//    - Objects of a type that is a subclass of PhoneContact

		ArrayList<PhoneContact> myContacts = new ArrayList<PhoneContact>();

		PhoneContact contact;

		contact = new PhoneContact("Ali", "", "336-278-1234");
		myContacts.add(contact);

		contact = new PhoneContact("Bob");
		myContacts.add(contact);

		contact = new PhoneContact("Cat", "336-265-5768", "");
		myContacts.add(contact);

		contact = new PhoneContact("Dan", "585-742-9203", "419-778-9090");
		myContacts.add(contact);

		System.out.println("\nMy Contacts");
		printEach(myContacts);

		contact = new SmartContact("Eli", "404-808-1616");
		myContacts.add(contact);

		System.out.println("\nMy Contacts");
		printEach(myContacts);

		// Notice!
		// The printEach method calls getInfo on a PhoneContact reference,
		// but when the *actual* object type is SmartContact, cell prints.
		// No code needs to change to get the cell number to print!
		// Another example of **polymorphism**

		contact = new SmartContact("Fan", "252-314-1592", "252-924-3330", "252-867-5309");
		myContacts.add(contact);

		contact = new SmartContact("Guy", "", "363-235-4341", "363-756-0146");
		myContacts.add(contact);

		contact = new SmartContact("Hal", "363-346-5452", "", "363-978-1460");
		myContacts.add(contact);

		contact = new SmartContact("Ian", "363-457-6563", "363-978-6410", "");
		myContacts.add(contact);

		contact = new SmartContact("Jax", "", "", "363-401-9743");
		myContacts.add(contact);

		contact = new SmartContact("Kai", "", "363-390-8632", "");
		myContacts.add(contact);

		contact = new SmartContact("Lee", "363-289-7521", "", "");
		myContacts.add(contact);

		contact = new SmartContact("Moe");
		myContacts.add(contact);

		System.out.println("\nMy Contacts");
		printEach(myContacts);

    }



    public static void printEach(ArrayList<PhoneContact> contacts) {
        for (PhoneContact pc : contacts) {
            String info = pc.getInfo();
            System.out.println("- " + info);
        }
    }

}
