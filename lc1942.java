import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class lc1942 {

  private static int smallestChair(int[][] times, int targetFriend) {
    int arrivaltime = times[targetFriend][0];
    int chair;
    int no = 0;
    int longest = 0;
    for (int[] t : times) {
      longest = Math.max(t[0], longest);
      longest = Math.max(t[1], longest);
    }
    Arrays.sort(
      times,
      (m1, m2) -> {
        if (m1[0] == m2[0]) return Integer.compare(m1[1], m2[1]);
        return Integer.compare(m1[0], m2[0]);
      }
    );
    PriorityQueue<Integer> freechair = new PriorityQueue<>();
    for (int i = 0, n = times.length; i < n; i++) freechair.add(i);
    Map<Integer, List<Integer>> timeChairseated = new HashMap<>();
    for (int i = times[no][0]; i <= longest; i++) {
      // leaving
      if (timeChairseated.containsKey(i)) {
        freechair.addAll(timeChairseated.get(i));
        timeChairseated.remove(i);
      }
      // target
      if (i == arrivaltime) return freechair.peek();
      // entering
      if (i == times[no][0]) {
        chair = freechair.poll();
        if (timeChairseated.containsKey(times[no][1])) timeChairseated
          .get(times[no][1])
          .add(chair); else timeChairseated.put(
          times[no][1],
          new ArrayList<>(List.of(chair))
        );
        no++;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[][] times = { { 1, 4 }, { 2, 3 }, { 4, 6 } };
    int targetFriend = 1;
    System.out.println(smallestChair(times, targetFriend));
  }
}
