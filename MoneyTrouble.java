import java.util.Scanner;

public class MoneyTrouble {

   
   public static int moneyToPennies(){
      int total = dollars_to_pennies * 100;

      return total;
   }
   
   
   
   public static void main(String[] args) {

      Scanner console = new Scanner(System.in);

      System.out.println("Money to Pennies: ");
      double dollars_to_pennies = console.nextLine();
      System.out.println("Dollars: ")
      int dollars = console.nextLine();
      System.out.println("Cents: ")
      int cents = console.nextLine();
      System.out.println(dollars_to_pennies(double dollars_to_pennies));
      System.out.println(dollarsAndCentsToPennies(int dollars, int cents));
      
   }

}
