import java.util.Arrays;

public class lc840 {

  private static boolean magic(int[][]grid, int r, int c){
    

    return true;
  }

  private static int numMagicSquaresInside(int[][] grid) {
    int lc = grid.length;
    int lr = grid[0].length;
    int[] map = new int[16];
    if (lc < 3 || lr < 3) return 0;
    int[][] sumR = new int[lc][lr];
    int[][] sumC = new int[lc][lr];
    int ans=0;
    int p1=0,p2=0,p3=0;
    int q1=0,q2=0,q3=0;
    for (int c =0; c<lc;c++){
      for (int i=0;i<lr;i++){
        if (i==0){
          sumR[c][i] = grid[c][i];
          continue;
        }
        sumR[c][i] = sumR[c][i-1] + grid[c][i];
      }
    }
    for (int r=0;r<lc;r++){
      for (int c=0;c<lr;c++){
        if (r == 0){
          sumC[r][c] = grid[r][c];
          continue;
        }
        sumC[r][c] = sumC[r-1][c] + grid[r][c];
      }
    }
    // System.out.println(Arrays.deepToString(sumR));
    // System.out.println(Arrays.deepToString(sumC));
    for (int r =2;r<lc;r++){
      for (int i=0, n=map.length;i<n;i++) map[i]=0;
      out:
      for (int c=2;c<lr;c++){
        if (c==2){
          map[grid[r][c]]++;
          map[grid[r-1][c]]++;
          map[grid[r-2][c]]++;
          map[grid[r][c-1]]++;
          map[grid[r-1][c-1]]++;
          map[grid[r-2][c-1]]++;
          map[grid[r][c-2]]++;
          map[grid[r-1][c-2]]++;
          map[grid[r-2][c-2]]++;
          for (int i =1;i<=9;i++){
            if (map[i] != 1) continue out;
          }
        }
        else {
          map[grid[r-2][c-3]]--;
          map[grid[r-1][c-3]]--;
          map[grid[r][c-3]]--;
          map[grid[r-2][c]]++;
          map[grid[r-1][c]]++;
          map[grid[r][c]]++;
          for (int i =1;i<=9;i++){
            if (map[i] != 1) continue out;
          }
        }
        if (r >=3){
          p1 = sumC[r-3][c-2];
          p2 = sumC[r-3][c-1];
          p3 = sumC[r-3][c];
        }
        if (c >= 3){
          q1 = sumR[r][c-3];
          q2 = sumR[r-1][c-3];
          q3 = sumR[r-2][c-3];
        }
        if (sumC[r][c-2]-p1!=15 || sumC[r][c-1]-p2!=15 || sumC[r][c]-p3!=15) continue;
        if (sumR[r-2][c]-q3!=15 || sumR[r-1][c]-q2!=15 || sumR[r][c]-q1!=15) continue;
        if (grid[r][c] + grid[r-1][c-1] + grid[r-2][c-2] != 15) continue;
        if (grid[r][c-2] + grid[r-1][c-1] + grid[r-2][c] != 15) continue;
        ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {{5,5,5},{5,5,5},{5,5,5}};
    System.out.println(numMagicSquaresInside(grid));
  }
}
