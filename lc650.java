public class lc650 {
  private static int dfs(int len, int copied, int step, int target){
    if (len > target) return Integer.MAX_VALUE;
    if (len == target) return step;
    int noCopy = dfs(len+copied, copied, step+1, target);
    int copy = dfs(len*2, len, step+2, target);
    return Math.min(noCopy, copy);
  }
  
  private static int minSteps(int n) {
    if (n==1) return 0;
    return dfs(1, 1, 1, n);
  }

  public static void main(String[] args) {
    int n =3;
    System.out.println(minSteps(n));
  }
}
