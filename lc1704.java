import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc1704 {
  private static boolean halvesAreAlike(String s) {
    int len = s.length();
    int count1=0;
    int count2=0;

    Set<Character> set = new HashSet<>( List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U') );
    for (int i=0; i<len/2;i++){
      if ( set.contains(s.charAt(i)) ) count1++;
    }
    for (int i =len/2;i<len;i++ ){
      if ( set.contains(s.charAt(i)) ) count2++;
    }
    return count1==count2;
    }

    public static void main(String[] args) {
      String s = "textbook";
      System.out.println(halvesAreAlike(s));
    }
}
