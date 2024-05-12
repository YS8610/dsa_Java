import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc56 {

  private static int[][] merge(int[][] intervals) {
    int rlen = intervals.length;
    
    int min = intervals[0][0];
    int max = intervals[rlen-1][1];
    List<List<Integer>> ans = new ArrayList<>(1000);
    for (int row = 0; row < rlen; row++) {
      for (int col = 0; col < 2; col++) {
        min = Math.min(intervals[row][col], min);
        max = Math.max(intervals[row][col], max);
      }
    }
    // Arrays.sort(intervals, (m1, m2) -> { 
    //   if (m1[0]==m2[0]) return Integer.compare(m1[1], m2[1]);
    //   else return Integer.compare(m1[0], m2[0]);
    // });
    int[] memo = new int[max + 1];
    for (int row = 0; row < rlen; row++) {
      if (intervals[row][0] == intervals[row][1]) memo[intervals[row][1]]=2;
    }
    for (int row = 0; row < rlen; row++) {
      if (intervals[row][0] == intervals[row][1]) continue;
      Arrays.fill(memo, intervals[row][0], intervals[row][1]+1, 1);
    }
    for (int lp = min, n = max + 1; lp < n; lp++) {
      if (memo[lp]==2) ans.add(List.of(lp, lp));
      else if (memo[lp] == 1) {
        int rp = lp + 1;
        while (rp < n && memo[rp] == 1) rp++;
        ans.add(List.of(lp, rp - 1));
        lp = rp;
      }
    }
    int[][] finalans = new int[ans.size()][2];
    for (int i = 0, n = ans.size(); i < n; i++) {
      finalans[i][0] = ans.get(i).get(0);
      finalans[i][1] = ans.get(i).get(1);
    }
    return finalans;
  }

  private static int[][] merge1(int[][] intervals) {
    int rlen = intervals.length;
    Arrays.sort(intervals, (m1, m2) -> { 
      if (m1[0]==m2[0]) return Integer.compare(m1[1], m2[1]);
      else return Integer.compare(m1[0], m2[0]);
    });
    for (int r=0;r<rlen-1;r++){
      if (intervals[r][1]>=intervals[r+1][1] ){
        // merge the interval
        intervals[r+1][0] =intervals[r][0];
        intervals[r+1][1] =intervals[r][1];
        // change the row to negative number to signal merged
        intervals[r][0] = -1;
      }
      else if (intervals[r][1]>= intervals[r+1][0]){
        // merge the interval
        intervals[r+1][0] = intervals[r][0];
        // change the row to negative number to signal merged
        intervals[r][0] = -1;
      }
    }
    int counter =0;
    for(int[] a : intervals) if (a[0]!=-1) counter++;
    int[][] ans = new int[counter][2];
    counter=0;
    for(int i=0; i<rlen;i++) {
      if (intervals[i][0]>=0){
        ans[counter][0] =intervals[i][0]; 
        ans[counter][1] =intervals[i][1]; 
        counter++;
      }
    }
    return ans;
  }
//  interval
  public static void main(String[] args) {
    int[][] intervals = { {0,1},{ 1, 1 }, { 2, 6 }, { 6, 10 }, { 10, 18 } };
    // int[][] intervals = {{1,4},{4,5}};
    System.out.println(Arrays.deepToString(merge(intervals)));
    System.out.println(Arrays.deepToString(merge1(intervals)));
  }
}
