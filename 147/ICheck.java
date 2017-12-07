import java.util.Scanner;
class ICheck{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);

    System.out.print("Enter in Characters: ");
    String s = input.nextLine();
    System.out.println("The number is: ");
    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      //System.out.print(c + ", ");
      int val = (int) c;
      System.out.print(Integer.toHexString(val));
    }
    System.out.println();
  }
}
