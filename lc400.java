public class lc400 {

  private static long pos(long n){
    if (n <10) return n;
    long count = 0;
    long tmp = n;
    while (tmp != 0){
      tmp/=10;
      count++;
    }
    tmp = 1;
    for (int i=0; i<count-1;i++)
      tmp *=10;
    long ans = (n-tmp+1)*count;
    ans += pos(tmp-1);
    return ans;
  }

  private static int findNthDigit(int n) {
    int lp = 1;
    int rp = Integer.MAX_VALUE;
    int m = 0;
    while (lp < rp) {
      m = (rp - lp) / 2 + lp;
      if (pos(m) >= n) rp = m; else lp = m + 1;
    }
    long tmp = pos(lp);
    int ans = lp;
    int copy = lp;
    while (tmp >= n) {
      ans = copy % 10;
      copy /= 10;
      if (copy == 0) copy = --lp;
      tmp--;
    }
    return ans;
  }

  public static int findNthDigit1(int n) {
    int counter = 1;
    int sum = 0;
    if (n < 10) return n;
    while (sum < n) {
      sum += Math.log10(counter) + 1;
      if (sum < n) counter++;
    }
    int posNeeded = sum - n + 1;
    return (
      (counter % (int) Math.pow(10, posNeeded)) /
      ((int) Math.pow(10, posNeeded - 1))
    );
  }

  public static void main(String[] args) {
    int n = 20;
    System.out.println(findNthDigit(n));
  }
}