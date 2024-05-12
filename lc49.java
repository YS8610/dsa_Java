import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class lc49 {
  private static List<List<String>> groupAnagrams1(String[] strs){
    Map<Set<String>,List<String>> map = new HashMap<>();
    for (String str : strs){
      Set<String> set = Arrays.stream( str.split("") )
                              .collect(Collectors.toSet());
      if (map.containsKey(set)){
        map.get(set).add(str);
        map.put(set, new ArrayList<>(map.get(set) ) );
      }
      else{
        List<String> strList = new ArrayList<>();
        strList.add(str);
        map.put( set , strList);
      }
    }
    List<List<String>> ans = new ArrayList<>();
    for (Set<String> a : map.keySet() ){
      ans.add( new ArrayList<>(map.get(a)) );
    }
    return ans;
  }
  private static List<List<String>> groupAnagrams(String[] strs){
    Map<List<Integer>,List<String>> map = new HashMap<>();
    for (String str : strs){
      List<Integer> c = new ArrayList<Integer>(Collections.nCopies(26, 0));
      str.chars().boxed().forEach(x-> {
        c.set(x-97, c.get(x-97)+1);
      });
      if (map.containsKey(c)){
        List<String> b = new ArrayList<>(map.get(c));
        b.add(str);
        map.put(c, new ArrayList<>(b) );
      }
      else map.put(c,new ArrayList<>( Arrays.asList(str)));
    }
    List<List<String>> ans = new ArrayList<>();
    for (List<Integer> key : map.keySet()){
      ans.add( new ArrayList<>( map.get(key)) );
    }
    return ans;
  }
  public static void main(String[] args) {
    String[] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
    System.out.println( groupAnagrams(strs).toString() );
  }
}
