import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class lc460 {
  int cap;
  Map<Integer, Integer> map1; // key, freq
  Map<Integer, LinkedHashSet<Integer>> map2; // freq, queue for least used
  Map<Integer, Integer> map3; // key, val

  public lc460(int capacity) {
        this.cap= capacity;
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
        this.map3 = new HashMap<>();
    }

  public int get(int key) {
    int val = this.map3.getOrDefault(key, -1);
    if (val == -1)
      return -1;
    int freq = this.map1.get(key);
    this.map1.computeIfPresent(key, (k, v) -> v + 1);
    LinkedHashSet<Integer> set = this.map2.get(freq);
    set.remove(key);
    if (!this.map2.containsKey(freq + 1))
      this.map2.put(freq + 1, new LinkedHashSet<>(List.of(key)));
    else
      this.map2.get(freq + 1).add(key);
    return val;
  }

  public void put(int key, int value) {
    // existing key
    if (this.map3.containsKey(key)) {
      this.map1.computeIfPresent(key, (k, v) -> v + 1);
      int pFreq = this.map1.get(key) - 1;
      this.map2.get(pFreq).remove(key);
      if (this.map2.containsKey(pFreq + 1))
        this.map2.get(pFreq + 1).add(key);
      else
        this.map2.put(pFreq + 1, new LinkedHashSet<>(List.of(key)));
      this.map3.put(key, value);
      return;
    }
    // new key
    // capacity not exceeded
    if (this.cap > this.map3.size()) {
      this.map3.put(key, value);
      this.map1.put(key, 1);
      if (!this.map2.containsKey(1))
        this.map2.put(1, new LinkedHashSet<>(List.of(key)));
      else
        this.map2.get(1).add(key);
      return;
    }
    // capacity exceeded
    int leastFreq = Integer.MAX_VALUE;
    for (Map.Entry<Integer, LinkedHashSet<Integer>> entry : this.map2.entrySet())
      leastFreq = entry.getValue().size() > 0 ? Math.min(leastFreq, entry.getKey()) : leastFreq;
    int leastkey = this.map2.get(leastFreq).getFirst();
    this.map1.remove(leastkey);
    this.map2.get(leastFreq).remove(leastkey);
    this.map3.remove(leastkey);
    this.map1.put(key, 1);
    if (this.map2.containsKey(1))
      this.map2.get(1).add(key);
    else
      this.map2.put(1, new LinkedHashSet<>(List.of(key)));
    this.map3.put(key, value);
  }
}
