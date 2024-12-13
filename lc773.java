import java.util.LinkedList;
import java.util.Queue;

public class lc773 {
  private static boolean done(int[][] board){
    return board[0][0] == 1 && board[0][1] == 2 &&
           board[0][2] == 3 && board[1][0] == 4 &&
           board[1][1] == 5 && board[0][1] == 0;
  }
  
  private static int slidingPuzzle(int[][] board) {
    int r=0, c=0;
    int lr = board.length;
    int lc = board[0].length;
    for (int i=0;i<lr;i++)
      for (int j=0;j<lc;j++)
        if (board[i][j] == 0){
          r = i;
          c = j;
        }
    int U = 1;
    int D = 2;
    int L = 3;
    int R = 4;
    Queue<int[]> q= new LinkedList<>();
    q.add(new int[]{r,c,0});
    
    while (!q.isEmpty()){
      
    }


    return 0;
  }

  public static void main(String[] args) {
    int[][] board = {{1,2,3},{4,0,5}};
    System.out.println(slidingPuzzle(board));
  }
}
