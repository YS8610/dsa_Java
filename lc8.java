public class lc8 {
  private static int myAtoi(String s){
    String strippedS = s.strip();
    if (strippedS.equals("")) return 0;
    int sign = 1;
    long ans = 0;
    int i = 0;
    int n = strippedS.length();
    if (strippedS.charAt(0) == '-'){
      sign = -1;
      i = 1;
    }
    if (strippedS.charAt(0) == '+') i = 1;
    while (i < n && strippedS.charAt(i)>='0' && strippedS.charAt(i) <= '9'){
      ans = ans * 10 + (strippedS.charAt(i) - '0');
      if (Long.compare(ans, (long) Integer.MAX_VALUE) > 0 && sign == 1)
        return Integer.MAX_VALUE;
      if (Long.compare(ans * -1, (long) Integer.MIN_VALUE) < 0 && sign == -1)
        return Integer.MIN_VALUE;
      i++;
    }
    return (int) ans*sign;
  }

  public static void main(String[] args) {
    String s = "  0000000000012345678";
    System.out.println( myAtoi(s) );
  }
}
