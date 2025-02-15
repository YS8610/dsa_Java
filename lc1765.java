import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc1765 {
  private static int[][] highestPeak(int[][] isWater) {
    int lr = isWater.length;
    int lc = isWater[0].length;
    int[][] ans = new int[lr][lc];
    for (int[] a :ans) Arrays.fill(a, -1);
    Deque<int[]> q = new ArrayDeque<>();
    for (int r=0;r<lr;r++)
      for (int c=0;c<lc;c++)
        if (isWater[r][c] == 1)
          q.add(new int[]{r,c,0});
    int[] tmp;
    while (!q.isEmpty()){
      tmp = q.pollFirst();
      if (tmp[0] < 0 || tmp[0] >= lr || tmp[1] <0 || tmp[1] >=lc || ans[tmp[0]][tmp[1]] != -1)
        continue;
      ans[tmp[0]][tmp[1]] = tmp[2];
      q.add(new int[]{tmp[0]-1, tmp[1], tmp[2]+1});
      q.add(new int[]{tmp[0]+1, tmp[1], tmp[2]+1});
      q.add(new int[]{tmp[0], tmp[1]-1, tmp[2]+1});
      q.add(new int[]{tmp[0], tmp[1]+1, tmp[2]+1});
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][]  isWater = {{0,0,1},{1,0,0},{0,0,0}};
    System.out.println(Arrays.deepToString(highestPeak(isWater)));
  }
}
