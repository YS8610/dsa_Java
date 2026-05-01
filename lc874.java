import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc874 {
  static public int robotSim(int[] commands, int[][] obstacles) {
    Set<List<Integer>> obsSet = new HashSet<>();
    for (int[] obs : obstacles)
      obsSet.add(Arrays.asList(obs[0], obs[1]));
    // up, right,down, left = 0, 1, 2, 3
    int x = 0, y = 0, direction = 0;
    int x1 = 0, y1 = 0;
    int l = commands.length;
    int[] movement = new int[] { 0, 0 };
    int ans = 0;
    for (int i = 0; i < l; i++) {
      if (commands[i] == -2) {
        direction--;
        direction = direction < 0 ? direction + 4 : direction;
        continue;
      }
      if (commands[i] == -1) {
        direction = (direction + 1) % 4;
        continue;
      }
      if (direction == 0) {
        movement[0] = 0;
        movement[1] = 1;
      } else if (direction == 1) {
        movement[0] = 1;
        movement[1] = 0;
      } else if (direction == 2) {
        movement[0] = 0;
        movement[1] = -1;
      } else {
        movement[0] = -1;
        movement[1] = 0;
      }
      for (int j = 0; j < commands[i]; j++) {
        x1 = x;
        y1 = y;
        x1 += movement[0];
        y1 += movement[1];
        if (obsSet.contains(Arrays.asList(x1, y1)))
          break;
        x = x1;
        y = y1;
        ans = Math.max(x * x + y * y, ans);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] commands = {-2,-1,8,9,6};
    int[][] obstacles = {{-1,3},{0,1},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}};
    System.out.println(robotSim(commands, obstacles));
  }
}
