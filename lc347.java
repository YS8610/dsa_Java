import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class lc347 {
  private static int[] topKFrequent(int[] nums, int k){
    Map<Integer,Integer> dict = new HashMap<>();
    for (int num:nums){
      if (dict.containsKey(num)) dict.put(num, Integer.valueOf(dict.get(num)+1) );
      else dict.put(num,1);
    }
    Map<Integer,Integer> dictSorted = dict.entrySet()
                                          .stream()
                                          .sorted(Map.Entry.comparingByValue( (m1,m2)->m2.compareTo(m1) ))
                                          .collect(Collectors.toMap(
                                            Map.Entry::getKey, 
                                            Map.Entry::getValue, 
                                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    System.out.println(dictSorted);
    int counter = 0;
    List<Integer> ans = new ArrayList<>();
    for (int key : dictSorted.keySet()){
      if (counter >= k) return ans.stream().mapToInt(Integer::valueOf).toArray();
      counter ++;
      ans.add(Integer.valueOf(key));
      // if (initialValue!=dictSorted.get(key) ){
      //   if (counter >= k) return ans.stream().mapToInt(Integer::valueOf).toArray();
      //   counter++;
      //   initialValue=dictSorted.get(key);
      //   ans.add(Integer.valueOf(key));
      // }
      // else{
      //   ans.add(Integer.valueOf(key));
      // }
    }

    return ans.stream().mapToInt(Integer::valueOf).toArray();
  }
  public static void main(String[] args) {
    int[] nums = {4,4,4,4,3,3,3,2,2,1,1};
    int k = 3;
    System.out.println( Arrays.toString(topKFrequent(nums, k))   ); 
  } 
}
