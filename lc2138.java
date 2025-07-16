import java.util.Arrays;

public class lc2138 {
  static public String[] divideString(String s, int k, char fill) {
    int l = s.length();
    int part = l / k;
    int remainder = l % k;
    int ansl = part + (remainder == 0 ? 0 : 1);
    String[] ans = new String[ansl];
    char[] p = new char[k];
    for (int i = 0, j = 0; i < ansl; i++) {
      for (int t = 0; t < k; t++) {
        if (j < l)
          p[t] = s.charAt(j++);
        else
          p[t] = fill;
      }
      ans[i] = String.valueOf(p);
    }
    return ans;
  }

  public static void main(String[] args){
    String s = "abcdefghi";
    int k = 4;
    char fill = 'x';
    System.out.println(Arrays.toString(divideString(s, k, fill)));
  }
}
