import java.util.Arrays;

public class lc289 {
  private static void gameOfLife(int[][] board){
    int rlen = board.length;
    int clen = board[0].length;
    int[][] temp = new int[rlen][clen];
    int topLeft, top, topRight;
    int left, right;
    int bottomLeft, bottom, bottomRight;
    int sum;
    for (int r=0; r<rlen;r++){
      for (int c=0; c<clen;c++){
        topLeft = (r-1<0||c-1<0)?0:board[r-1][c-1];
        top = (r-1<0)?0:board[r-1][c];
        topRight = (r-1<0||c+1>=clen)?0:board[r-1][c+1];
        left = (c-1<0)?0:board[r][c-1];
        right = (c+1>=clen)?0:board[r][c+1];
        bottomLeft = (r+1>=rlen||c-1<0)?0:board[r+1][c-1];
        bottom = (r+1>=rlen)?0:board[r+1][c];
        bottomRight = (r+1>=rlen||c+1>=clen)?0:board[r+1][c+1];
        sum = topLeft + top + topRight + left + right + bottomLeft + bottom + bottomRight;
        if (sum<2) temp[r][c]=0;
        else if (sum==3 && board[r][c]==0) temp[r][c]=1;
        else if (sum==2 || sum==3) temp[r][c]=board[r][c];
        else if (sum>3) temp[r][c] = 0;
        else temp[r][c]=board[r][c];
      }
    }
    for (int r=0; r<rlen;r++){
      for (int c=0; c<clen;c++) board[r][c] = temp[r][c];
    }
  }

  public static void main(String[] args) {
    int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    gameOfLife(board);
    System.out.println( Arrays.deepToString(board) );
  }
}
