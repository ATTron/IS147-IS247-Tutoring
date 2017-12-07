// Anthony Templeton IS247 File IO & search example
// Teach students how to open file retreive contents and search those contents
// program will search file for an entry and return the entire line
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Search{

  public final static Scanner input = new Scanner(System.in);
  
  public static void main(String args[]) throws FileNotFoundException {
    // define our variables
    List<String> db = new ArrayList<String>();
    String search = "";
    String holder = "";
    // probably a better way to do this
    boolean isFound = false;
    boolean everFound = false;

    // take out file in and iterate through each line and add it to our list
    Scanner file = new Scanner(new FileInputStream("lines.txt"));
    while(file.hasNextLine()){
      holder = file.nextLine();
      db.add(holder);
    }
    file.close();

    System.out.println("Type quit at any point to stop searching.");

    // create iterator to allow seaching multi line files
    while(!search.equals("quit")){
      search = getSearch();
      Iterator<String> searchIterator = db.iterator();
      while(searchIterator.hasNext()){
        everFound = false;
        isFound = true;
        // loop through list and compare line to the searched value
        for (String s:db){
          if (s.toLowerCase().contains(search.toLowerCase())){
            System.out.println(s);
            everFound = true;
            searchIterator.next();
          } else {
            isFound = false;
            searchIterator.next();
          }
        }
        // checking booleans to see if we need to inform the user we couldn't find their search
        if (search.equals("quit")){
          System.out.println("Exiting application . . . ");
        } else if (!isFound && !everFound){
          System.out.println("No records found for " + search + "\n");
        } 
      }
    }
  }

  public static String getSearch(){
    String s = "";
    System.out.print("Search by patient records:  ");
    s = input.nextLine();
    return s;
  }
}
