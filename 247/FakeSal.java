import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.lang.NullPointerException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class FakeSal{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(System.in);
    int totalEmployees = 100;

    System.out.println("What is the name of the new file?");
    String fname = input.nextLine();

    File file = null;
    try{
      file = new File(fname);
    } catch(NullPointerException e) {
      System.err.println(e);
    } finally{
      System.out.println("Generating file with name: " + fname);
    }

    PrintWriter output = null;
    try{
      output = new PrintWriter(file);
    } catch (FileNotFoundException e){
      System.err.println(e);
    }
    output.println("PrintWriter Example");
    output.println("");
    output.println("Anthony Templeton");
    output.println("");
    output.println(file.getAbsolutePath());
    output.println("");

    output.println("First Name\tLast Name\tTitle\t\tSalary");
    output.println("");

    for (int i = 1; i <= totalEmployees; i++){
      output.println(i + "FirstName\t" + i + "LastName\t" + empInfo());
    }
    output.close();
  }

  public static String empInfo(){
    Random rand = new Random();
    DecimalFormat df = new DecimalFormat("#.00");

    int choice = rand.nextInt(3) + 1;
    double salary = 0.0;

    String name = "";
    String sending = "";

    switch(choice){
      case 1: name = "Associate";
              salary = 25000 + (45000 - 25000) * rand.nextDouble();
              break;
      case 2: name = "Manager ";
              salary = 50000 + (80000 - 50000) * rand.nextDouble();
              break;
      case 3: name = "Executive";
              salary = 90000 + (300000 - 90000) * rand.nextDouble();
              break;
      default: System.out.println("Error registering employee\nSkipping line.");
               break;
    }
    sending = name + "\t$" + df.format(salary);
    return sending;
  }
}
