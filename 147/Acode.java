import java.util.Scanner;
public class Acode {
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter in value between 0 - 127");
    int val = input.nextInt();
    char c = (char) val;
    System.out.println(c);
  }
}
