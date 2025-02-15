import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

class lc2349 {

  Map<Integer, Integer> idxmap;
  Map<Integer, PriorityQueue<Integer>> map;

  public lc2349() {
    this.idxmap = new HashMap<>();
    this.map = new HashMap<>();
  }

  public void change(int index, int number) {
    // index with number
    if (this.idxmap.containsKey(index)) {
      int n = this.idxmap.get(index);
      if (n == number)
        return;
      this.map.get(n).remove(index);
      this.idxmap.put(index, number);
    } else {
      this.idxmap.put(index, number);
    }
    putNum(index, number);

  }

  private void putNum(int index, int number) {
    PriorityQueue<Integer> pq;
    if (this.map.containsKey(number)) {
      pq = this.map.get(number);
      pq.add(index);
      return;
    }
    pq = new PriorityQueue<>();
    pq.add(index);
    this.map.put(number, pq);
  }

  public int find(int number) {
    if (this.map.containsKey(number)) {
      if (this.map.get(number).isEmpty())
        return -1;
      return this.map.get(number).peek();
    }
    return -1;
  }
}
