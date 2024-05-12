public class lc557 {
  private static String reverseWords(String s) {
    int n = s.length();
    if (n==1) return s;
    String[] a = s.split(" ");
    for (int i=0,m=a.length;i<m;i++){
      a[i] = reverseStr(a[i]);
    }
    return String.join(" ", a);
  }

  private static String reverseStr(String a){
    int n = a.length();
    int lp =0, rp = n-1;
    char[] s = new char[n];
    char temp;
    while (lp<rp){
      temp = a.charAt(lp);
      s[lp] = a.charAt(rp);
      s[rp] = temp;
      lp++;
      rp--;
    }
    if (lp==rp) s[lp]=a.charAt(lp);
    return new String(s);
  }

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    System.out.println( reverseWords(s) );
  }
}
