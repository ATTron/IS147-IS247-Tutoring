import java.util.Scanner;
public class SepName {
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter in your full name");
    String s = input.nextLine();

    int v = s.indexOf(' ');

    String fn = s.substring(0, v);
    String ln = s.substring(v + 1);
    System.out.println("First Name: " + fn + "\n" + "Last Name: " + ln);
  }
}
