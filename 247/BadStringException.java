import java.io.*;
import java.util.*;

public class BadStringException extends Exception {
  public BadStringException() {
    super();
  }

  public void checkString(String s) throws BadStringException{
    for (char c: s.toCharArray()){
      if(!Character.isLetterOrDigit(c)){
        throw new BadStringException();
      }
    }
  }

  @Override
  public String toString(){
    return "You have entered invalid characters!";
  }
}
