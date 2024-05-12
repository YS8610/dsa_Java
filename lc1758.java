public class lc1758 {
  private static int minOperations(String s) {
    int zeroAtEven=0;
    int zeroAtOdd=0;
    int len = s.length();
    for (int i =0;i<len;i++){
      if (i%2==0){
        if (s.charAt(i)!='0') zeroAtEven++;
        if (s.charAt(i)!='1') zeroAtOdd++;
      }
      if (i%2!=0){
        if (s.charAt(i)!='0') zeroAtOdd++;
        if (s.charAt(i)!='1') zeroAtEven++;
      }
    }
    return Math.min(zeroAtOdd, zeroAtEven);
  }

  public static void main(String[] args) {
    String s = "1111";
    System.out.println( minOperations(s) );
  }
}
