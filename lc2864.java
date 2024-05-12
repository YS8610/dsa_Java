import java.util.Arrays;

public class lc2864 {
  private static String maximumOddBinaryNumber(String s) {
    int l = s.length();
    int sum = 0;
    int j = 0;
    for (int i=0;i<l;i++) sum += s.charAt(i)=='1'?1:0;
    char[] ans = new char[l];
    Arrays.fill(ans, '0');
    ans[l-1] = '1';
    sum--;
    while (sum>0){
      ans[j] = '1';
      j++;
      sum--;
    }
    return String.valueOf(ans);
  }

  public static void main(String[] args) {
    String s = "0101";
    System.out.println(maximumOddBinaryNumber(s));
  }
}
