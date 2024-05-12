public class lc392 {
  public static void main(String[] args) {
    String s = "abc", t = "ahbgdc";
    int startpos = 0;

    for (int i=0, n=s.length(); i<n;i++ ){
      int pos = t.indexOf( String.valueOf(s.charAt(i)),startpos);
      if (startpos>=t.length()) System.out.println(false);
      
      if ( pos >=0 ){
        startpos = pos+1;
        continue;
      }
      else{
        System.out.println(false);
      }
    }

  }
}
