public class lc2064 {
  public int minimizedMaximum(int n, int[] quantities) {
    if (n==1) return quantities[0];
    int lower = 1;
    int upper = 100000;
    int mid = 1;
    while (lower <upper){
      mid = (upper-lower)/2+lower;
      if (canDistribute(mid, n, quantities)) upper = mid;
      else lower =mid+1;
    }
    return lower;
    }

  private static boolean canDistribute(int k, int n, int[] qty){
    if (k==0) return false;
    for (int q:qty) n -= Math.ceil((double)q/k);
    return n>=0; 
  }
}
