// Anthony Templeton
// Allows user to input endless numbers until 0
// Then finds the largest value and displays how many times it was given
import java.util.Scanner;

class FindMax{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter in numbers: ");
    int num;
    int max = 0;
    int numCount = 0;
    int total = 0;
    // start of our loop
    do{
      // send each number into our variable and compare it to current max value
      num = input.nextInt();
      // must reset count back to 1
      if (num > max){
        max = num;
        numCount = 1;
      } else if (num == max) {
        numCount ++;
      }
    } while (num != 0); // exit loop when our condiditon is met

    // display our results
    System.out.println("The largest value in the set is: " + max);
    System.out.println("The largest value is inputted " + numCount + " times");
  }
}
