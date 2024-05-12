import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class lc2336 {
  Set<Integer> set;
  PriorityQueue<Integer> q;

  public lc2336() {
    set = new HashSet<>();
    for (int i = 1; i <= 1001; i++) set.add(i);
    q = new PriorityQueue<>(set);
  }

  public int popSmallest() {
    int a = q.poll();
    set.remove(a);
    return a;
  }

  public void addBack(int num) {
    if (set.contains(num)) return;
    set.add(num);
    q.add(num);
  }

  public static void main(String[] args) {
    lc2336 a = new lc2336();
    a.addBack(2);
    System.out.println(a.popSmallest());
    System.out.println(a.popSmallest());
    System.out.println(a.popSmallest());
    a.addBack(1);
    System.out.println(a.popSmallest());
    System.out.println(a.popSmallest());
    System.out.println(a.popSmallest());
  }
}
