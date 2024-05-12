import java.util.HashMap;
import java.util.Map;

public class lc1207 {
  private static boolean uniqueOccurrences(int[] arr) {
    Map<Integer,Integer> countMap = new HashMap<>();
    for (int a:arr){
      if (countMap.containsKey(a)) countMap.put(a, countMap.get(a)+1 );
      else countMap.put(a,1);
    }
    Map<Integer,Integer> uniqueCountMap = new HashMap<>();
    for (int k : countMap.keySet()){
      if (uniqueCountMap.containsKey(countMap.get(k))) return false;
      uniqueCountMap.put(countMap.get(k),1); 
    }
    return true;
  }

  
  public static void main(String[] args) {
    int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
    System.out.println( uniqueOccurrences(arr) );
  }
}
