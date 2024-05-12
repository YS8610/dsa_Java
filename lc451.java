import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class lc451 {
  private static String frequencySort(String s){
    int[] memo = new int[75];
    String ans = "";
    s.chars().forEach(x -> memo[x-48] ++);
    Map<Integer,List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
    for (int i=0; i<75;i++){
      if ( map.containsKey( memo[i]) ) map.get(memo[i]).add( i);
      else map.put( memo[i], new ArrayList<>(Arrays.asList(i)) );
    }
    List<Integer> intAns = new ArrayList<>();
    for ( int no : map.keySet()){
      if (no ==0) continue;
      for (int a : map.get(no)){
        for(int i=0;i<no;i++) intAns.add(a);
      }
    }
    for (int a : intAns){
      ans +=  Character.toString( (char) a+48);
    }
    return ans;
  }

  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
    List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
    list.sort(Entry.comparingByValue());

    Map<K, V> result = new LinkedHashMap<>();
    for (Entry<K, V> entry : list) {
        result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  private static String frequencySort1(String s){
    int[][] memo = new int[75][2];
    String ans = "";
    s.chars().forEach(x ->{
      memo[x-48][0] = x-48;
      memo[x-48][1] ++;
    } );
    Arrays.sort(memo, (m1,m2) -> Integer.compare(m2[1], m1[1]));
    for (int[] a : memo){
      for (int i=0;i<a[1];i++){
        ans += Character.toString( (char) a[0]+48);
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    String s = "zztreeEEEdd12223zzz000";
    System.out.println( frequencySort1(s) ); 
  }
}
