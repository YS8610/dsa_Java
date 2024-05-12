import java.util.HashMap;
import java.util.Map;

public class lc705 {
  private Map<Integer, Integer> map; 

  public lc705() {
    this.map = new HashMap<>();
  }
  
  public void add(int key) {
    if (map.containsKey(key)) map.put(key, map.get(key)+1);
    else map.put(key,1);
  }
  
  public void remove(int key) {
    if (map.containsKey(key)) map.remove(key);
  }
  
  public boolean contains(int key) {

    return map.containsKey(key);
  }
}
