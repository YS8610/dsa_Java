import java.util.List;
import java.util.ArrayList;

class lc1222{

  private static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king){
    int[][] map = new int[8][8];
    for (int[] q : queens) map[q[0]][q[1]] = 1;
    dfs(map, king[0], king[1], -1, 0);
    dfs(map, king[0], king[1], 1, 0);
    dfs(map, king[0], king[1], 0, -1);
    dfs(map, king[0], king[1], 0, 1);
    dfs(map, king[0], king[1], -1, -1);
    dfs(map, king[0], king[1], -1, 1);
    dfs(map, king[0], king[1], 1, -1);
    dfs(map, king[0], king[1], 1, 1);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i=0;i<8;i++)
      for (int j=0; j<8;j++)
        if (map[i][j] == 2)
          ans.add(List.of(i,j));
    return ans;
  }

  private static void dfs(int[][] map, int r, int c, int dr, int dc){
    int lr = map.length;
    int lc = map[0].length;
    if (r < 0 || c < 0 || r>= lr|| c>=lc) return;
    if (map[r][c] >= 1){
      map[r][c]=2;
      return;
    }
    dfs(map, r+dr, c+dc, dr, dc);
  }

  public static void main(String[] args){
    int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
    int[] king = {0,0};
    System.out.println(queensAttacktheKing(queens, king).toString());
  }
}
