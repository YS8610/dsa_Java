import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lc432 {
  Map<String, Integer> map;
  Map<Integer, Set<String>> mapf;
  int max;
  int min;
  
  public lc432() {
    map = new HashMap<>();
    mapf = new HashMap<>();
    max = 0;
    min = 0;
  }
  
  public void inc(String key) {
    if (map.isEmpty()){
      map.put(key, 1);
      
      max = 1;
      min = 1;
      return;
    }
    
    
    if (map.containsKey(key)){
      map.put(key, map.get(key)+1);
      max = Math.max(max, map.get(key));
    }
  }
  
  public void dec(String key) {
      
  }
  
  public String getMaxKey() {
      
  }
  
  public String getMinKey() {
      
  }
}
