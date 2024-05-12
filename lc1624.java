import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1624 {
  private static int maxLengthBetweenEqualCharacters(String s) {
    int ans = -1;
    int sLen = 0;
    Map<Character,List<Integer>> map = new HashMap<>();
    int len = s.length();
    for (int i=0;i<len;i++){
      if (map.containsKey(s.charAt(i))) map.get(s.charAt(i)).add(i);
      else map.put(s.charAt(i), new ArrayList<>(List.of(i)));
    }
    for (Character i : map.keySet()){
      sLen = map.get(i).size();
      if (sLen>1) ans = Math.max(ans, map.get(i).get(sLen-1)- map.get(i).get(0)-1);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "abcfga";
    System.out.println( maxLengthBetweenEqualCharacters(s) );
  }

}
