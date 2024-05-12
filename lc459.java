public class lc459 {
  private static boolean repeatedSubstringPattern(String s){
    String p;
    int n = s.length();
    for (int i =1,m=n/2; i<=m;i++){
      p = s.substring(0, i);
      if (n%i!=0) continue;
      if ( p.repeat(n/i).equals(s) ) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "abab";
    System.out.println( repeatedSubstringPattern(s) );
  }

}
