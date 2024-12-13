import java.util.Optional;
import java.util.TreeSet;

public class lc475 {

  public int findRadius(int[] houses, int[] heaters) {
    TreeSet<Integer> hset = new TreeSet<>();
    for (int h : heaters) hset.add(h);
    int ans = 0;
    Optional<Integer> lowOptional;
    Optional<Integer> highOptional;
    int tmp;
    for (int h : houses) {
      lowOptional = Optional.ofNullable(hset.floor(h));
      highOptional = Optional.ofNullable(hset.ceiling(h));
      tmp =
        Math.min(
          Math.abs(lowOptional.orElse(Integer.MAX_VALUE) - h),
          Math.abs(highOptional.orElse(Integer.MAX_VALUE) - h)
        );
      ans = Math.max(tmp, ans);
    }
    return ans;
  }
}
