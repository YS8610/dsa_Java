import java.util.List;

public class lc931 {
  private static int[][] memo;
    
  private static int dfs(int[][] matrix, int[] coor) {
    int rlen = matrix[0].length;
    int clen = matrix.length;
    int result;
    if (coor[0] < 0 || coor[0] >= rlen || coor[1] >= clen || coor[1] < 0)
      return Integer.MAX_VALUE;
    if (memo[coor[0]][coor[1]]!=-10001) return memo[coor[0]][coor[1]];
    if (coor[0] == clen - 1) {
      memo[coor[0]][coor[1]] =matrix[coor[0]][coor[1]];
      return matrix[coor[0]][coor[1]];
    }
    result = dfs(matrix, new int[] { coor[0] + 1, coor[1] });
    for (int i : List.of(-1, 1)) {
      result = Math.min(result, dfs(matrix, new int[] { coor[0] + 1, coor[1] + i}));
    }
    result +=matrix[coor[0]][coor[1]];
    memo[coor[0]][coor[1]] = result;
    return result;
  }

    private static int minFallingPathSum(int[][] matrix) {
    memo = new int[matrix.length][matrix[0].length];
    for (int[] row : memo){
      for (int i=0,n=matrix[0].length;i<n;i++) row[i] = -10001;
    }
    int ans = dfs(matrix, new int[] { 0, 0 });
    for (int i = 1, n = matrix[0].length; i < n; i++) {
      ans = Math.min(ans, dfs(matrix, new int[] { 0, i }));
    }
    return ans;
    }

  public static void main(String[] args) {
    int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
    System.out.println(minFallingPathSum(matrix));
  }
}
