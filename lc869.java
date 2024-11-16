public class lc869 {
  private static int[] numcount(int n){
    int[] ans = new int[10];
    while (n /10 != 0){
      ans[n%10]++;
      n/=10;
    }
    ans[n%10]++;
    return ans;
  }

    private static boolean reorderedPowerOf2(int n) {
    int[] count = new int[10];
    while(n/10!=0){
      count[n%10]++;
      n/=10;
    }
    count[n%10]++;
    int[] tmp;
    out:
    for (int i=0;i<31;i++){
      tmp = numcount(1<<i);
      for(int j = 0;j<10;j++){
        if (tmp[j] != count[j]) continue out;
      }
      return true;
    }
    return false;
    }

    public static void main(String[] args) {
      int n = 10;
      System.out.println(reorderedPowerOf2(n));
    }
}
