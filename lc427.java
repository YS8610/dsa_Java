public class lc427 {
  static class QNode {
    public boolean val;
    public boolean isLeaf;
    public QNode topLeft;
    public QNode topRight;
    public QNode bottomLeft;
    public QNode bottomRight;

    public QNode() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public QNode(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public QNode(boolean val, boolean isLeaf, QNode topLeft, QNode topRight, QNode bottomLeft, QNode bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }

  static public QNode construct(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (lr == 1 && lc == 1)
      return new QNode(grid[0][0] == 1, true);
    return dfs(grid, lr, 0, 0);
  }

  static public QNode dfs(int[][] grid, int l, int r, int c) {
    if (l == 1)
      return new QNode(grid[r][c] == 1, true);
    l >>= 1;
    QNode topleft = dfs(grid, l, r, c);
    QNode topright = dfs(grid, l, r, c + l);
    QNode bottomleft = dfs(grid, l, r + l, c);
    QNode bottomright = dfs(grid, l, r + l, c + l);
    if (topleft.val == topright.val &&
        topright.val == bottomleft.val &&
        bottomleft.val == bottomright.val &&
        topleft.isLeaf &&
        topright.isLeaf &&
        bottomleft.isLeaf &&
        bottomright.isLeaf)
      return new QNode(topleft.val, true, null, null, null, null);
    return new QNode(topleft.val, false, topleft, topright, bottomleft, bottomright);
  }

  public static void main(String[] args) {
    int[][] grid = {
        { 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 0, 0 },
        { 1, 1, 1, 1, 1, 1, 0, 0 },
        { 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1 },
        { 0, 0, 0, 0, 1, 1, 1, 1 },
        { 0, 0, 0, 0, 1, 1, 1, 1 }
    };
    QNode ans = construct(grid);
    System.out.println(ans);
  }
}
