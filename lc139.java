import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc139 {
  private static List<String> a = new ArrayList<>();
  private static Map<String,Boolean> memo = new HashMap<>();
  private static boolean wordBreak1(String s, List<String> wordDict) {
    if (s.length()==0) return true;
    for (String i : wordDict){
      if (i.charAt(0) == s.charAt(0) ){
        if (s.contains(i)){
          s = s.substring(i.length(), s.length());
          a.add(i);
          if ( wordBreak(s, wordDict) ) {
            for (String str : wordDict){
              if (!a.contains(str)) return false;
            }
            return true;
          }
        }
      }
    }
    return false;
  }

  private static boolean wordBreak(String s, List<String> wordDict){
    if (s.length()==0) return true;
    if (memo.containsKey(s)) return memo.get(s);
    for (String i : wordDict){
      if (i.charAt(0) == s.charAt(0) && i.length()<=s.length() && s.substring(0, i.length()).equals(i)){
        if (s.contains(i)){
          String suffix = s.substring(i.length(), s.length());
          if ( wordBreak(suffix, wordDict) ) {
              memo.put(s, true);
              return true;
            }
          }
        }
      }
    memo.put(s, false);
    return false;
  }
  public static void main(String[] args) {
    String s = "a";
    List<String> wordDict = List.of("b");
    System.out.println( wordBreak(s, wordDict));
  }
}
