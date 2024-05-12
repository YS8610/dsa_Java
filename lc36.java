import java.util.Arrays;

public class lc36 {

  private static boolean isValidSudoku(char[][] board) {
    int[] memo = new int[10];
    int num;
    // check horizontal row
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        if (board[r][c]=='.') continue;
        num = Character.getNumericValue(board[r][c]);
        if (memo[num]==0) memo[num]+=1;
        else return false;
      }
      Arrays.fill(memo, 0);
    }
    // check vertical col
    for (int c = 0; c < 9; c++){
      for (int r=0; r<9;r++){
        if (board[r][c]=='.') continue;
        num = Character.getNumericValue(board[r][c]);
        if (memo[num]==0) memo[num]+=1;
        else return false;
      }
      Arrays.fill(memo, 0);
    }
    // check 3x3 cube
    for (int r=0;r<9;r+=3){
      for (int c=0; c<9;c+=3){
        
        for(int rr=r;rr<r+3;rr++){
          for (int cc=c;cc<c+3;cc++){
            if (board[rr][cc]=='.') continue;
            num = Character.getNumericValue(board[rr][cc]);
            if (memo[num]==0) memo[num]+=1;
            else return false;
          }
        }
        Arrays.fill(memo, 0);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = {
      { '8', '3', '.', '.', '.', '.', '7', '.', '.' },
      { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
      { '.', '9', '.', '.', '.', '.', '.', '6', '.' },
      { '1', '.', '.', '.', '6', '.', '.', '.', '3' },
      { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
      { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
      { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
      { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
      { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
    };

    System.out.println(isValidSudoku(board));
  }
}
