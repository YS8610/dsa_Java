public class lc389 {
  
  private static char findTheDifference(String s, String t) {
    int n = s.length();
    int[] original = new int[26];
    int[] newA = new int[26];
    for (int i=0;i<n;i++) original[ s.charAt(i)-97]++;
    for (int i=0,m=t.length();i<m;i++) {
      newA[ t.charAt(i)-97]++;
      if (newA[ t.charAt(i)-97]> original[ t.charAt(i)-97]) return t.charAt(i);
    }
    return 'a';
  }

  public static void main(String[] args) {
    String s = "abcd", t = "abcde";
    System.out.println( findTheDifference(s, t) );
  }
}
