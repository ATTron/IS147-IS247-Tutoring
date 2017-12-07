/**
 * Locker Puzzle
 * All lockers are closed on the first day of school. As the students enter,
 * the first student, denoted S1, opens every locker. Then the second student,
 * S2, begins with the second locker, denoted L2, and closes every other locker.
 * Student S3 begins with the third locker and changes every third locker
 * (closes it if it was open, and opens it if it was closed). Student S4 begins
 * with locker L4 and changes every fourth locker. Student S5 starts with L5 and
 * changes every fifth locker, and so on, until student S100 changes L100.
 * After all the students have passed through the building and changed the lockers,
 * which lockers are open? Write a program to find your answer and display all open
 * locker numbers separated by exactly one space.
 * Anthony Templeton
 */

public class LockerPuzzle{
  public static void main(String[] args){
    // create locker array
    boolean[] lockers = new boolean[100];
    // define student starting at student 0
    int student = 0;

    if (student == 0){
      for (int i = 0; i < lockers.length; i++){
        lockers[i] = true;
      }
    }

    // handle all other students seperate from first
    for (student = 1; student < lockers.length; student++){
      lockers[student] = swap(lockers[student]);
      for (int j = 1; j * student < lockers.length; j++){
        lockers[student * j] = swap(lockers[student * j]);
      }
    }

    // display our result
    for (int i = 0; i < lockers.length; i++){
      if (lockers[i] == true){
        System.out.println("Locker " + (i + 1) + " is open.");
      } else {
        //System.out.println("Locker " + (i + 1) + " is closed.");
      }
    }

  }

  // returns the flipped boolean
  public static boolean swap(boolean b){
    if (b){
      b = false;
      return b;
    } else {
      b = true;
      return b;
    }
  }
}

