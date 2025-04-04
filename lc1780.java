public class lc1780 {
  private static boolean checkPowersOfThree(int n) {
    int[] table = new int[15];
    for (int i =0; i<15;i++)
      table[i] = (int)Math.pow(3,i);
    return dfs(table, n, 0);
}

private static boolean dfs(int[] table, int n, int p){
    if (n==0) return true;
    if (n < 0) return false;
    int tmp;
    boolean ans = false;
    for (int i=p; i<15;i++){
        tmp =  n-table[i];
        if (tmp <0) break;
        ans = dfs(table, tmp, i+1);
        if (ans) return true;
    }
    return ans;
}

  public static void main(String[] args) {
    int n = 21;
    System.out.println(checkPowersOfThree(n));
  }
}
