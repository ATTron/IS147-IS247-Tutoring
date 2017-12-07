// import scanner class
import java.util.Scanner;
// class has same name as the filename
class hi{
  // declare main method
	public static void main(String args[]){

    // initalize our scanner
		Scanner input = new Scanner(System.in);
		// boolean means true/false
    boolean fits_rectangle;
    // declare our coord variables
		double x;
		double y;
		
    // Ask for both numbers
		System.out.print("Enter x and y coordinates: ");
    // We are storing values using our scanner object
    // We store the values in the variables we defined on lines 13-14
		x = input.nextDouble();
		y = input.nextDouble();

    // if solution
    if (x <= (10/2) && y <= (5/2)){
      System.out.println("The point (" + x + ", " + y + ") is inside the rectangle!");
    }

    // boolean solution + if solution
    fits_rectangle = (x <= (10/2) && y <= (5/2));
    if (fits_rectangle){
      System.out.println("The point (" + x + ", " + y + ") is inside the rectangle!");
    }
    //System.out.println(fits_rectangle);

	}// close out main method

}// close out hi class
