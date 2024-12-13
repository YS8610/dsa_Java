public class lc3361 {
  private static long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
    long[][] map = new long[26][26];
    long nshift=0;
    long pshift=0;
    int tmpi= 0;
    int tmpj= 0;
    for (int i=0;i<26;i++){
      for (int j=0;j<26;j++){
        if (i==j) continue;
        nshift = 0;
        pshift = 0;
        tmpi = i;
        tmpj = j;
        // forward shift
        while (tmpi != tmpj){
          nshift += nextCost[tmpi%26];
          tmpi++;
          tmpi%=26;
        }
        tmpi = i;
        tmpj = j;
        while (tmpi!=tmpj){
          pshift += previousCost[tmpi%26];
          tmpi--;
          if (tmpi ==-1) tmpi = 25;
        }
        map[i][j] = Math.min(nshift, pshift);
      }
    }
    long ans = 0;
    for (int i =0, n=s.length(); i<n;i++){
      ans += map[s.charAt(i)-'a'][t.charAt(i)-'a'];
    }
    return ans;
  }


  public static void main(String[] args) {
    String s = "abab";
    String t = "baba";
    int[] nextCost = {100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] previousCost = {100,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    System.out.println(shiftDistance(s, t, nextCost, previousCost));
  }
}
