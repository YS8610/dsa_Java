import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc384 {
  int[] list;
  List<Integer> listShuffled;

  public lc384(int[] nums) {
    this.list = nums;
    this.listShuffled = new ArrayList<>( Arrays.stream(nums).boxed().toList() );
  }
  
  public int[] reset() {
    return this.list;
  }
  
  public int[] shuffle() {
    Collections.shuffle(listShuffled);
    return listShuffled.stream().mapToInt(Integer::valueOf).toArray();
  }
}
