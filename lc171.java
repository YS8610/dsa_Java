import java.util.Arrays;

public class lc171 {
  
  public static void main(String[] args) {
    String columnTitle = "AB";
    int[] a = columnTitle.chars()
                          .map(x -> x-64)
                          .toArray();
    System.out.println(Arrays.toString(a));

    int len = a.length;
    int ans = 0;

    for (int i=0; i<len;i++){
      ans += a[i] * Math.pow(26, len - i - 1);
    }
    System.out.println(ans);
  }
}
