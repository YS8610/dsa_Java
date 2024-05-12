import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc217 {
  public static void main(String[] args) {
    int[] nums = {1,2,2,3,3,1};
    Set<Integer> a = new HashSet<>();
    Arrays.stream(nums)
          .forEach(x -> a.add(x));
    boolean b = nums.length == a.size()?false:true;

    System.out.println(b);


  }
}
