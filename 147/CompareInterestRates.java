import java.util.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;


public class CompareInterestRates
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);//a scanner for amounts
      Scanner again = new Scanner(System.in);// a scanner for the do again string
      
      int loanAmount = 0;
      int numOfYears = 0;
      double annualInterestRate;

      
      //create objects to format % and $ output later
      NumberFormat percent= NumberFormat.getPercentInstance();
      percent.setMaximumFractionDigits(3);
      NumberFormat dollars= NumberFormat.getCurrencyInstance();
      String another="";// to hold the while condition later
      //create a do loop so the user can redo their loans
      do
      {
      
       // Prompt for and accept the user's loan amount
       System.out.print("Enter your loan amount: ");
       loanAmount = input.nextInt();
       // Prompt for and accept the number of years for the loan
       System.out.print("Enter in the number of years to pay back your loan: ");
       numOfYears = input.nextInt();
   
       // Print the header to include "Interest Rate", "Monthly Payment", "Total Payment"
       System.out.println("Interest Rate\t  Monthly Payment\t\tTotal Payment");
       // for loop to step through the annualInterestRate from 5.0-8.0 by 1/8
       for (annualInterestRate = 5.0; annualInterestRate <= 8.0; annualInterestRate += (1/8.0))
        {
         // Obtain monthly interest rate
         double monthlyInterestRate = annualInterestRate / 1200;
         // Compute mortgage
         double monthlyPayment = loanAmount * monthlyInterestRate /
           (1 - (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
         double totalPayment = monthlyPayment * numOfYears * 12;
   
         // Display results annualInterestRate %, monthlyPayment $, totalPayment $);
         System.out.println(annualInterestRate+"%\t\t\t"+dollars.format(monthlyPayment)+"\t\t\t"+
         dollars.format(totalPayment));
         }//end of for loop
       //Prompt for another loan 
       System.out.print("Would you like to enter another loan: ");
       another = again.nextLine();// use the again scanner object to grab the user's nextLine
       another = another.toLowerCase();
         }//end of do-while
          while (another.equals("yes"));// make sure to another.equals not another==
    
   }
}