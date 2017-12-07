import java.util.Scanner;

public class GameLife{
  private static char[][] world;
  private static int[][] neighbors;
  private static char [][]glider = {{' ','x',' '},
                            {' ', 'x', 'x'},
                            {'x' , ' ', 'x'}};

  public GameLife(){
    world = new char[15][30];
    neighbors = new int[15][30];
  }

  public GameLife(int row, int col){
    world = new char[row][col];
    neighbors = new int[row][col];
  }

  public static void main(String[] args) throws InterruptedException{
    Scanner input = new Scanner(System.in);

    int count = 0;
    int world_row;
    int world_col;
    world = new char[15][30];
    neighbors = new int[15][30];

    System.out.println("Enter in insertion coordiates for glider. Ex) 3 3");
    world_row = input.nextInt();
    world_col = input.nextInt();

    genWorld(world_row, world_col);
    while(count < 20){
      if (count == 0){
        System.out.println("First Generation");
      }else{
      System.out.println("Generation " + (count + 1));
      }
      showWorld();
      check();
      nextGen();
      count++;
      Thread.sleep(1000);
      System.out.println();
    }
  }
    //for (int i = 0; i < world.length; i++){
      //for (int j = 0; j < world[i].length; j++){
        //if (world[i][j] == '*'){
          //System.out.println("Glider at point [" + i + ", " + j + "] has " + neighbors[i][j] + " neighbors.");
        //}
      //}
    //}

  public static void genWorld(int gr, int gc){
    for (int i = 0; i < world.length; i++){
      for (int j = 0; j < world[i].length; j++){
        world[i][j] = '.';
      }
    }
    populateWorld(gr, gc);
  }

  private static void populateWorld(int r, int c){
    int p = 0;
    int q = 0;
    for (int i = r; i < glider.length + r; i++){
      for (int j = c; j < glider[p].length + c; j++){
        world[i][j] = glider[p][q];
        q++;
      }
      p++;
      q = 0;
    }
  }

  public static void check(){
    int count = 0;
    for (int i = 0; i < world.length; i++){
      for (int j = 0; j < world[i].length; j++){
        //left side
        if (j > 0){
          if (world[i][j - 1] == 'x'){
            count++;
          }
          // top left
          if (i > 0){
            if (world[i - 1][j - 1] == 'x'){
              count++;
            }
          }
          // bottom left
          if (i < world.length - 1){
            if (world[i + 1][j - 1] == 'x'){
              count++;
            }
          }
        }// end left
        //right side
        if (j < world[i].length - 1){
          if (world[i][j + 1] == 'x'){
            count ++;
          }
          // top right
          if (i > 0){
            if (world[i - 1][j + 1] == 'x'){
              count++;
            }
          }
          // bottom right
          if (i < world.length - 1){
            if (world[i + 1][j + 1] == 'x'){
              count++;
            }
          }
        }
        // top
        if (i > 0){
          if (world[i - 1][j] == 'x'){
            count++;
          }
        }
        // bottom
        if (i < world.length - 1){
          if (world[i + 1][j] == 'x'){
            count++;
          }
        }
        // add to neighbor array
        neighbors[i][j] = count;
        count = 0;
      }
    }
  }
  public static void showWorld(){
    for (int i = 0; i < world.length; i++){
      for (int j = 0; j < world[i].length; j++){
        System.out.print(world[i][j]);
      }
      System.out.println();
    }
  }

  public static void nextGen(){
    for (int i = 0; i < world.length; i++){
      for (int j = 0; j < world[i].length; j++){
        if (neighbors[i][j] == 3){
          world[i][j] = 'x';
        } else if ((neighbors[i][j] == 2 || neighbors[i][j] == 3) && world[i][j] == 'x'){
          world[i][j] = 'x';
        } else {
          world[i][j] = '.';
        }
      }
    }
  }
}
