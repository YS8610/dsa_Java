
class lc2698{
  private static int punishmentNumber(int n){
    int tmp;
    int ans = 0;
    for (int i =1; i<=n;i++){
      tmp = i * i;
      ans += pnum(tmp, i)?tmp:0;
    }
    return ans;
  }
  
  private static boolean pnum(int num, int rem){
    if (rem < 0) return false;
    if (num == 0 && rem == 0) return true;
    if (num == rem) return true;
    int tmp = 10;
    boolean ans = false;
    while (tmp <= num){
      ans = pnum(num/tmp, rem-num%tmp);
      if (ans) return true;
      tmp *= 10;
    }
    return false;
  }

  public static void main(String[] args){
    int n = 45;
    System.out.println(punishmentNumber(n));
  }
}
