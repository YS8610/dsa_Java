public class lc1128 {
  static public int numEquivDominoPairs(int[][] dominoes) {
    int l = dominoes.length;
    int ans = 0;
    int tmp;
    int[] map = new int[100];
    for (int i = 0; i < l; i++) {
      if (dominoes[i][0] > dominoes[i][1]) {
        tmp = dominoes[i][0];
        dominoes[i][0] = dominoes[i][1];
        dominoes[i][1] = tmp;
      }
    }
    for (int[] d : dominoes) {
      tmp = d[0] * 10 + d[1];
      ans += map[tmp];
      map[tmp]++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
    System.out.println(numEquivDominoPairs(dominoes));
  }
}
