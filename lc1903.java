public class lc1903 {
  private static String largestOddNumber(String num) {
    int len = num.length();
    int i = len;
    while (--i>=0){
      if ((num.charAt(i)-'0') % 2 != 0) break;
    }
    if (i==-1) return "";
    return num.substring(0, i+1);
  }

  public static void main(String[] args) {
    String num = "5206";
    System.out.println(largestOddNumber(num));
  }
}
