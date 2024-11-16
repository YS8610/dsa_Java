public class lc3133 {

  private static long minEnd(int n, int x) {
    if (n==1) return x;
    long[] masks = new long[60];
    long tmp = 1;
    for (int i = 0; i < 60; i++) {
      masks[i] = tmp;
      tmp <<= 1;
    }
    long ans = x;
    int idx = 0;
    int idx2 = 0;
    while (idx < 60){
      if ((ans & masks[idx])!=0){
        idx++;
        continue;
      }
      if (((n-1) & masks[idx2]) != 0){
        ans ^= masks[idx];
      }
      idx2++;
      idx++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 2, x = 7;
    System.out.println(minEnd(n, x));
  }
}
