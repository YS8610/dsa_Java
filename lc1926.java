import java.util.LinkedList;
import java.util.Queue;

public class lc1926 {

  private static int nearestExit(char[][] maze, int[] entrance) {
    int lc = maze.length;
    int lr = maze[0].length;
    Queue<int[]> q = new LinkedList<>();
    int[] tmp;
    int ans = 0;
    q.add(entrance);
    while (!q.isEmpty()) {
      for (int i = 0, n = q.size(); i < n; i++) {
        tmp = q.poll();
        if (
          tmp[0] < 0 ||
          tmp[1] < 0 ||
          tmp[0] >= lc ||
          tmp[1] >= lr ||
          maze[tmp[0]][tmp[1]] == 'V' ||
          maze[tmp[0]][tmp[1]] == '+'
        ) {
          continue;
        }
        if (
          (entrance[0] != tmp[0] || entrance[1] != tmp[1]) &&
          (tmp[0] == 0 || tmp[1] == 0 || tmp[0] == lc - 1 || tmp[1] == lr - 1)
        ) {
          return ans;
        }
        maze[tmp[0]][tmp[1]] = 'V';
        q.add(new int[] { tmp[0] - 1, tmp[1] });
        q.add(new int[] { tmp[0] + 1, tmp[1] });
        q.add(new int[] { tmp[0], tmp[1] - 1 });
        q.add(new int[] { tmp[0], tmp[1] + 1 });
      }
      ans++;
    }
    return -1;
  }

  public static void main(String[] args) {
    String[][] maze = {{"+","+","+"},{".",".","."},{"+","+","+"}};
    int[] entrance = {1,0};
    System.out.println(nearestExit(null, entrance));
  }
}
