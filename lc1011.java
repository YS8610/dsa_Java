public class lc1011 {
  private static int shipdays(int[] weights, int cap){
    int ans = 1;
    int tmp = cap;
    for (int w:weights){
      if (tmp >= w) tmp-=w;
      else {
        tmp = cap;
        ans++;
        tmp -=w;
      }
    }
    return ans;
  }
  
  private static int shipWithinDays(int[] weights, int days) {
    int lp = 1;
    int rp = 5*10*10*10*10*500;
    for (int w:weights) lp=Math.max(w, lp);
    int m = rp;
    while (lp<rp){
      m = (rp-lp)/2+lp;
      if (shipdays(weights, m) <= days) rp = m;
      else lp = m + 1;
    }
    return lp;
  }

  public static void main(String[] args) {
    int[] weights = {1,2,3,1,1};
    int days = 4;
    System.out.println(shipWithinDays(weights, days));
  }
}
