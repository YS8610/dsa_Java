import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class lc542 {

  private static int[][] updateMatrix(int[][] mat) {
    int rows = mat.length;
    int column = mat[0].length;
    int[][] ans = new int[rows][column];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < column; c++) {
        ans[r][c] = bfs(mat, r, c);
      }
    }
    return ans;
  }

  private static int bfs(int[][] mat, int r, int c) {
    Deque<List<Integer>> q = new ArrayDeque<>();
    int rows = mat.length;
    int column = mat[0].length;
    int[][] visited = new int[rows][column];

    if (mat[r][c] == 0) return 0;

    q.add(List.of(r, c));
    int count = 0;
    List<Integer> first;
    while (!q.isEmpty()) {
      for (int i = 0, n = q.size(); i < n; i++) {
        first = q.pollFirst();
        // skip out of range coordinates
        if (
          first.get(0) < 0 ||
          first.get(1) < 0 ||
          first.get(0) >= rows ||
          first.get(1) >= column ||
          visited[first.get(0)][first.get(1)] == 1
        ) continue;

        if (mat[first.get(0)][first.get(1)] == 0) return count;
        visited[first.get(0)][first.get(1)] = 1;

        // up
        q.add(List.of(first.get(0) - 1, first.get(1)));
        // left
        q.add(List.of(first.get(0), first.get(1) - 1));
        // down
        q.add(List.of(first.get(0) + 1, first.get(1)));
        // right
        q.add(List.of(first.get(0), first.get(1) + 1));
      }
      count++;
    }
    return count;
  }

  private static int[][] updateMatrix1(int[][] mat) {
    int rows = mat.length;
    int column = mat[0].length;
    int maxVal = rows + column;
    int[][] visited = new int[rows][column];
    Deque<int[]> q = new ArrayDeque<>();
    int[][] ans = new int[rows][column];

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < column; c++) {
        if (mat[r][c] == 0) {
          ans[r][c] = 0;
          q.add(new int[] { r - 1, c });
          q.add(new int[] { r + 1, c });
          q.add(new int[] { r, c - 1 });
          q.add(new int[] { r, c + 1 });
          visited[r][c]=1;
        } else ans[r][c] = maxVal;
      }
    }
    int[] first;
    int top, down, left, right;
    int min;
    while (!q.isEmpty()) {
      min=maxVal;
      first = q.pollFirst();
      if (
        first[0] < 0 ||
        first[1] < 0 ||
        first[0] >= rows ||
        first[1] >= column ||
        mat[first[0]][first[1]] == 0 ||
        visited[first[0]][first[1]] ==1
      ) continue;
      // top
      if (first[0] - 1 >= 0 ) {
        top = ans[first[0] - 1 ][first[1]];
        min = top<min?top:min;
      }
      // down
      if (first[0] + 1 < rows) {
        down = ans[first[0] + 1 ][first[1]];
        min = down<min?down:min;
      }
      // left
      if (first[1] - 1 >= 0) {
        left = ans[first[0]][first[1]-1];
        min = left<min?left:min; 
      }
      // right
      if (first[1] + 1 < column) {
        right = ans[first[0]][first[1]+1];
        min = right<min?right:min;
      }
      ans[first[0]][first[1]] =min+1;
      visited[first[0]][first[1]]=1;
      q.add(new int[] { first[0] - 1, first[1] });
      q.add(new int[] { first[0] + 1, first[1] });
      q.add(new int[] { first[0], first[1] - 1 });
      q.add(new int[] { first[0], first[1] + 1 });
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
    System.out.println(Arrays.deepToString(updateMatrix(mat)));
    System.out.println(Arrays.deepToString(updateMatrix1(mat)));
  }
}
