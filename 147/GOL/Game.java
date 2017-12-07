public class Game {

  private char[][] board;
  private char[][] newGen;
  private char[][] glider = {{'.','*','.'},
                            {'.', '.', '*'},
                            {'*' , '*', '*'}};

  private char[][] blinker = {{'.','*','.'},
                            {'.', '*', '.'},
                            {'.' , '*', '.'}};

  public Game(int r, int c) {
    board = new char[r][c];
    newGen = new char[r][c];
  }

  public void fillBoard(int p) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = '.';
      }
    }
    if (p == 1) {
      fillGlider(0, 0);
    } else {
      fillBlinker(0,0);
    }
  }

  public void fillGlider(int r, int c) {
    int p = 0;
    int q = 0;
    for (int i = r; i < glider.length + r; i++){
      for (int j = c; j < glider[p].length + c; j++){
        board[i][j] = glider[p][q];
        q++;
      }
      p++;
      q = 0;
    }
  }

  public void fillBlinker(int r, int c) {
    int p = 0;
    int q = 0;
    for (int i = r; i < blinker.length + r; i++){
      for (int j = c; j < blinker[p].length + c; j++){
        board[i][j] = blinker[p][q];
        q++;
      }
      p++;
      q = 0;
    }
  }

  public int countNeighbors(char[][] world, int i, int j) {
    int count = 0;
    if (j > 0){
          if (world[i][j - 1] == '*'){
            count++;
          }
          // top left
          if (i > 0){
            if (world[i - 1][j - 1] == '*'){
              count++;
            }
          }
          // bottom left
          if (i < world.length - 1){
            if (world[i + 1][j - 1] == '*'){
              count++;
            }
          }
        }// end left
        //right side
        if (j < world[i].length - 1){
          if (world[i][j + 1] == '*'){
            count ++;
          }
          // top right
          if (i > 0){
            if (world[i - 1][j + 1] == '*'){
              count++;
            }
          }
          // bottom right
          if (i < world.length - 1){
            if (world[i + 1][j + 1] == '*'){
              count++;
            }
          }
        }
        // top
        if (i > 0){
          if (world[i - 1][j] == '*'){
            count++;
          }
        }
        // bottom
        if (i < world.length - 1){
          if (world[i + 1][j] == '*'){
            count++;
          }
        }
    return count;
  }

  public char[][] updateGen() {
    char[][] newGen = new char[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        // needs starting board or will get confused
        int count = countNeighbors(board, i, j);

        if (board[i][j] == '*' && (count == 2 || count == 3)) {
          newGen[i][j] = '*';
        } else if (count == 3) {
          newGen[i][j] = '*';
        } else {
          newGen[i][j] = '.';
        }
      }
    }
    return newGen;
  }

  public void showBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    board = updateGen();
  }
}
