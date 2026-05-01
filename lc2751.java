import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2751 {
  static public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    int l = positions.length;
    Map<Integer, Integer> posMap = new HashMap<>();
    for (int i = 0; i < l; i++)
      posMap.put(positions[i], i);
    int[][] robots = new int[l][3];
    // pos, healths, directions
    // L = 1;
    for (int i = 0; i < l; i++) {
      robots[i][0] = positions[i];
      robots[i][1] = healths[i];
      robots[i][2] = directions.charAt(i) == 'L' ? 1 : 0;
    }
    Arrays.sort(robots, (m1, m2) -> Integer.compare(m1[0], m2[0]));
    Deque<int[]> stack = new ArrayDeque<>();
    int[] top;
    for (int i = 0; i < l; i++) {
      if (stack.isEmpty()) {
        stack.add(robots[i]);
        continue;
      }
      while (!stack.isEmpty() && robots[i][1] > 0) {
        top = stack.peekLast();
        // equal direction, add to stack;
        if (top[2] == robots[i][2])
          break;
        // direction is lr
        if (!(top[2] == 0 && robots[i][2] == 1))
          break;
        // unequal direction, equal hp, remove both
        if (top[1] == robots[i][1]) {
          stack.pollLast();
          robots[i][1] = 0;
          break;
        }
        // unequal direction, top more hp
        if (top[1] > robots[i][1]) {
          top[1]--;
          robots[i][1] = 0;
          if (top[1] == 0)
            top = stack.pollLast();
          break;
        }
        // unequal direction, top less hp
        stack.pollLast();
        robots[i][1]--;
        if (robots[i][1] == 0 || stack.isEmpty())
          break;
        top = stack.peekLast();
      }
      if (robots[i][1] > 0)
        stack.add(robots[i]);
    }
    if (stack.size() == 0)
      return new ArrayList<>();
    int[][] subans = new int[stack.size()][2];
    int pos = 0;
    while (!stack.isEmpty()) {
      top = stack.pollFirst();
      subans[pos][0] = top[1];
      subans[pos++][1] = posMap.get(top[0]);
    }
    Arrays.sort(subans, (m1, m2) -> Integer.compare(m1[1], m2[1]));
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < subans.length; i++)
      ans.add(subans[i][0]);
    return ans;
  }

  public static void main(String[] args) {
    int[] positions = { 3,47 }, healths = { 46,26 };
    String directions = "LR";
    System.out.println(survivedRobotsHealths(positions, healths, directions));
  }
}
