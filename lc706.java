import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc706 {

  List<Integer> memo;

  public lc706() {
    this.memo = new ArrayList<>(Collections.nCopies(1000001, -1));
  }

  public void put(int key, int value) {
    this.memo.set(key, value);
  }

  public int get(int key) {
    return this.memo.get(key);
  }

  public void remove(int key) {
    this.memo.set(key, -1);
  }
}
