import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class lc131 {

  private static List<List<String>> partition(String s) {
    Map<String,Boolean> memo = new HashMap<>();
    List<List<String>> ans= new ArrayList<>();
    int len = s.length();
    int rp=len-1;
    for (int i =0;i<len;i++){
      while (rp>i){

        rp--;
      }
    }

    return null;
  }

  private static boolean helper(String s){
    int len = s.length();
    if (len==1) return true;
    String s1, s2;
    
    if (len%2==0){
      s1 = s.substring(0, len/2);
      s2 = s.substring( len/2, len);
    }
    else {
      s1 = s.substring(0, len/2);
      s2 = s.substring(len/2+1, len);
    }
    StringBuffer sbr = new StringBuffer(s2);
    sbr.reverse();
    s2 = sbr.toString();
    if (s1.equals(s2)) return true;
    
    return false;
  }

  public static void main(String[] args) {
    String s = "aab";
    // System.out.println( partition(s).toString() );
    System.out.println( helper("ollo") );
  }
}
