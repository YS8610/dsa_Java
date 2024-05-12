import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class lc380 {
    Map<Integer,Integer> map;
  List<Integer> list;

    public lc380() {
    this.map = new HashMap<>();
    this.list = new ArrayList<>(); 
    }
    
  public boolean insert(int val) {
    if (this.map.containsKey(val)) return false;
    this.list.add(val);
    this.map.put(val, this.list.size()-1);
    return true;
  }

  public boolean remove(int val) {
    if (!this.map.containsKey(val)) return false;
    int index = this.map.get(val);
    this.map.remove(val);
    if (index!=this.list.size()-1){
      this.list.set(index, this.list.get(list.size()-1));
      this.map.put(this.list.get(list.size()-1), index);
    }
    this.list.remove((int) this.list.size()-1);
    return true;
  }

  public int getRandom() {
    int item = new Random().nextInt(this.list.size());
    return this.list.get(item);
  }

  public static void main(String[] args) {
    lc380 a = new lc380();
    System.out.println(a.insert(1));
    System.out.println(a.remove(2));
    System.out.println(a.insert(2));
    System.out.println(a.getRandom());
    System.out.println(a.remove(1));
    System.out.println(a.insert(2));
    System.out.println(a.getRandom());
  }

}
