public class lc1545 {
  private static char findKthBit(int n, int k) {
    if (k==1) return '0';
    boolean[] map = new boolean[k+1];
    map[0] = false;
    int lp = 0;
    int rp = lp + 1;
    map[rp] = true;
    rp++;
    lp = rp - 2;
    while(rp <= k){
      while (lp >= 0 && rp <=k){
        map[rp] = !map[lp];
        rp++;
        if (lp == 0) break;
        lp--;
      }
      if (rp <=k) map[rp] = true;
      rp++;
      lp= rp - 2;
    }
    return map[k-1]?'1':'0';
  }

  public static void main(String[] args) {
    int n = 4, k = 11;
    System.out.println(findKthBit(n, k));
  }
}
