// Anthony Templeton
// Checks if number is evenly divisible by 5 & 6/ 5 or 6/ 5 or 6 but not both
import java.util.Scanner;

class Boo{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    boolean isDiv = false;
    int num;

    System.out.println("Enter a num: ");
    num = input.nextInt();


    if (num % 5 == 0 && num % 6 == 0){
      isDiv = true;
    }
    System.out.println("Is " + num + " divisible by 5 and 6? " + isDiv);
    if (num % 5 == 0 || num % 6 == 0){
      isDiv = true;
    }
    System.out.println("Is " + num + " divisible by 5 or 6? " + isDiv);
    if ((num % 5 == 0 || num % 6 == 0) && (num % 5 == 0 && num % 6 == 0)){
      isDiv = false;
    }
    System.out.println("Is " + num + " divisible by 5 or 6 but not both? " + isDiv);

  }

}
