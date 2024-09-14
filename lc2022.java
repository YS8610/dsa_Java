import java.util.Arrays;

public class lc2022 {
  private static int[][] construct2DArray(int[] original, int m, int n) {
    int l = original.length;
    if (l != m*n || m * n ==0) return new int[0][0];
    int[][] ans = new int[m][n];
    for (int i =0; i<l;i++){
      ans[i/n][i%n] = original[i]; 
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] original = {1,2,3,4};
    int m = 2, n = 2;
    System.out.println(Arrays.deepToString(construct2DArray(original, m, n)));
  }
}
