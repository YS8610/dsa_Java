public class lc3110 {
  private static int scoreOfString(String s) {
    int ans = 0;
    for (int i=0, n=s.length();i<n-1;i++){
      ans += Math.abs( s.charAt(i) - s.charAt(i+1) );
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "hello";
    System.out.println(scoreOfString(s));
  }
}
