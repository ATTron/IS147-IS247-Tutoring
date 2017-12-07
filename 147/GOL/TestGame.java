public class TestGame{
  private static char[][] board = new char[15][40];
  private static int[][] neighbors = new int[15][40];

  public static void main(String[] args) throws InterruptedException{
    int count = 0;
    createWorld();
    //check how many neighbors each glider point has has
    // neighborCheck();
    // for (int i = 0; i < board.length; i++){
    //   for (int j = 0; j < board[i].length; j++){
    //    if (board[i][j] == '*'){
    //      System.out.println("Glider at point [" + i + ", " + j + "] has " + neighbors[i][j] + " neighbors");
    //     }
    //   }
    // }
    while(count < 35){
      System.out.println("Generation " + (count + 1));
      printWorld();
      neighborCheck();
      updateSurvival();
      count ++;
      Thread.sleep(500);
      System.out.println();
    }
  }// main()

  public static void createWorld(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        board[i][j] = '.';
      }// j for
    }// i for
    dumpGlider();
  }// initalGrid()

  public static void neighborCheck(){
    int numNeighbors = 0;
    //r
    for (int i = 0; i < board.length; i++){
      //c
      for (int j = 0; j < board[i].length; j++){
        //checking left side
        if (j >0){
          // left
          if (board[i][j-1] == '*'){
            numNeighbors ++;
          }
          //top left
          if (i > 0){
            if (board[i - 1][j - 1] == '*'){
              numNeighbors ++;
            }
          }
          // bottom left
          if (i < board.length - 1){
            if (board[i + 1][j - 1] == '*'){
              numNeighbors ++;
            }
          }
        }// left
        //checking right side
        if (j < board[i].length -1){
          // right
          if (board[i][j + 1] == '*'){
            numNeighbors ++;
          }
          // top right
          if (i > 0){
            if (board[i - 1][j + 1] == '*'){
              numNeighbors ++;
            }
          }
          // bottom right
          if (i < board.length - 1){
            if (board[i + 1][j + 1] == '*'){
              numNeighbors ++;
            }
          }
        }// right
        // top
        if (i > 0){
          if (board[i - 1][j] == '*'){
            numNeighbors ++;
          }
        }// top
        //botttom
        if (i < board.length - 1){
          if (board[i + 1][j] == '*'){
            numNeighbors ++;
          }
        }// bottom
        // add to neighbor array
        neighbors[i][j] = numNeighbors;
        numNeighbors = 0;
      }// for
    }// for
  }// neighborCheck

  public static void updateSurvival(){
    for (int i = 0; i < neighbors.length; i++){
      for (int j = 0; j < neighbors[i].length; j++){
        if (neighbors[i][j] == 3){
          board[i][j] = '*';
        } else if ((neighbors[i][j] == 2 || neighbors[i][j] == 3) && board[i][j] == '*'){
          board[i][j] = '*';
        } else {
          board[i][j] = '.';
        }
      }// for
    }// for
  }// updateSurvival

  public static void printWorld(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        System.out.print(board[i][j]);
      }//for
      System.out.println();
    }//for
  }//printWorld

  // modified gosper gun glider
  private static void dumpGlider(){
    board[5][1] = '*';
    board[5][2] = '*';
    board[6][1] = '*';
    board[6][2] = '*';
    // board[7][1] = '*';
    // board[7][2] = '*';
    board[5][11] = '*';
    board[6][11] = '*';
    board[7][11] = '*';
    board[4][12] = '*';
    board[3][13] = '*';
    board[3][14] = '*';
    board[8][12] = '*';
    board[9][13] = '*';
    board[9][14] = '*';
    board[6][15] = '*';
    board[4][16] = '*';
    board[5][17] = '*';
    board[6][17] = '*';
    board[7][17] = '*';
    board[6][18] = '*';
    board[8][16] = '*';
    board[3][21] = '*';
    board[4][21] = '*';
    board[5][21] = '*';
    board[3][22] = '*';
    board[4][22] = '*';
    board[5][22] = '*';
    board[2][23] = '*';
    board[6][23] = '*';
    board[1][25] = '*';
    board[2][25] = '*';
    board[6][25] = '*';
    board[7][25] = '*';
    board[3][35] = '*';
    board[4][35] = '*';
    board[3][36] = '*';
    board[4][36] = '*';
  }// dumpGlider
}// TestGame
