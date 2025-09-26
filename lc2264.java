public class lc2264 {
  static public String largestGoodInteger(String num) {
    char tmp = (char) ('0' - 1);
    int l = num.length();
    for (int i = 0, n = l - 2; i < n; i++) {
      if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2))
        if (num.charAt(i) > tmp)
          tmp = num.charAt(i);
    }
    if (tmp == (char) ('0' - 1))
      return "";
    char[] ans = new char[3];
    for (int i = 0; i < 3; i++)
      ans[i] = tmp;
    return String.valueOf(ans);
  }

  public static void main(String[] args){
    String num = "6777133339";
    System.out.println(largestGoodInteger(num));
  }
}
