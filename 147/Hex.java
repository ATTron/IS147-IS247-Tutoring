import java.util.Scanner;
public class Hex {
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);

    System.out.println("Enter in a number 0 - 15");
    int val = input.nextInt();
    if (val >= 0 && val <= 15){
      String s = Integer.toHexString(val);
      System.out.println(s.toUpperCase());
    } else {
      System.out.println("Error! Must enter value between 0 and 15");
    }
  }
}
