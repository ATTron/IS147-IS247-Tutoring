import java.util.Scanner;
public class Average{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    double total = 0;
    double avg;
    double negCount = 0;
    double posCount = 0;
    double num;

    System.out.println("Enter in numbers and enter 0 to stop: ");
    num = input.nextDouble();
    do {
      if (num > 0 ){
        posCount++;
        total += num;
      } else if (num < 0){
        negCount++;
        total += num;
      }
      num = input.nextDouble();
    } while(num != 0);
    avg = total/(negCount + posCount);
    System.out.println(avg);
  }
}
