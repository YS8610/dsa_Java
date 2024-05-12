import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc729 {

  List<List<Integer>> l;

  public lc729() {
    l = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    if (l.isEmpty()) {
      l.add(List.of(start, end));
      l.sort((m1, m2) -> m1.get(0).compareTo(m2.get(0)));
      return true;
    }
    int len = l.size();
    int index = Collections.binarySearch(
      l,
      List.of(start, 0),
      (m1, m2) -> m1.get(0).compareTo(m2.get(0))
    );
    if (index >= 0) return false;
    index = -1 * index - 1;
    // start is smallest
    if (index == 0) {
      if (l.get(0).get(0) < end) return false;
      l.add(List.of(start, end));
    }
    // start is the biggest
    else if (index == l.size()) {
      if (l.get(l.size() - 1).get(1) > start) return false;
      l.add(List.of(start, end));
    }
    // start is in the middle
    else {
      if (
        l.get(index - 1).get(1) > start || l.get(index).get(0) < end
      ) return false;
      l.add(List.of(start, end));
    }
    if (len < l.size()) l.sort((m1, m2) -> m1.get(0).compareTo(m2.get(0)));
    return true;
  }

  public static void main(String[] args) {
    lc729 a = new lc729();
    System.out.println(a.book(10,20));
    System.out.println(a.book(15,25));
    System.out.println(a.book(20,30));
  }
}
