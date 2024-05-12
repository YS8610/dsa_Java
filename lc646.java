import java.util.Arrays;

public class lc646 {

  private static int findLongestChain(int[][] pairs) {
    if (pairs.length==1) return 1;
    Arrays.sort(
      pairs,
      (m1, m2) -> {
        if (m1[1] == m2[1]) return Integer.compare(m1[0], m2[0]);
        return Integer.compare(m1[1], m2[1]);
      }
    );
    int ans =1;
    int prevEnd = pairs[0][1];
    for (int i=1,n=pairs.length;i<n;i++){
      if (prevEnd<pairs[i][0]){
        ans++;
        prevEnd = pairs[i][1];
      } 
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] pairs = { { 3, 4 }, { 1, 2 }, { 2, 3 } };
    System.out.println(findLongestChain(pairs));
  }
}
