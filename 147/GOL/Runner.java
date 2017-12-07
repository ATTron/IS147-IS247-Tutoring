import java.io.*;
import java.util.*;
public class Runner {
  public static void main(String[] args) throws InterruptedException{
    Game g = new Game(20, 20);

    int gen = 1;
    Scanner input = new Scanner(System.in);

    System.out.println("Choose Pattern\n1) Glider\n2) Blinker");
    int s = input.nextInt();
    g.fillBoard(s);

    while (gen <= 30) {
      System.out.println("Generation " + gen);
      g.showBoard();
      gen++;
      Thread.sleep(500);
    }
  }
}
