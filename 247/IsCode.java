import java.util.Scanner;

public class IsCode{
  public static void main(String args[]){
    System.out.println("Enter in a string");
    Scanner input = new Scanner(System.in);
    String s = input.nextLine();
    BadStringException e = new BadStringException();
    try {
      e.checkString(s);
    } catch (BadStringException ex){
      System.err.println(ex);
    }
  }
}
