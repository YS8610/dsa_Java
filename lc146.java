import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class lc146 {
  Map<Integer,Integer> map;
  LinkedHashSet<Integer> stack;
  int cap;

  public lc146(int capacity) {
    this.map = new HashMap<>(3000);
    this.stack = new LinkedHashSet<>(3000);
    this.cap = capacity;
  }

  public int get(int key) {
    if(this.map.containsKey(key)) {
      this.stack.remove(key);
      this.stack.add(key);
      return this.map.get(key);
    }
    else return -1;
  }
  
  public void put(int key, int value) {
    if (map.containsKey(key)){
      map.put(key, value);
      this.stack.remove(key);
      this.stack.add(key);
    }
    else{
      map.put(key, value);
      if (map.size()>this.cap){
        Iterator itr = this.stack.iterator();
        int top =0;
        if (itr.hasNext()) {
          top=(int)itr.next();
          this.stack.remove(top);
          this.map.remove(top);
        }
      }
      this.stack.add(key);
    }
  }

  public static void main(String[] args) {
    lc146 test = new lc146(2);
    test.put(1,1);
    test.put(2,2);
    System.out.println(test.get(1));
    test.put(3,3);
    System.out.println(test.get(2));
    test.put(4,4);
    System.out.println(test.get(1));
    System.out.println(test.get(3));
    System.out.println(test.get(4));

  }

}
