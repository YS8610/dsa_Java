import java.util.Arrays;

public class lc733 {

  private static void dfs(int[][] image, int sr, int sc, int color, int c) {
    int row = image.length;
    int col = image[0].length;
    if (color == c) return;
    if (
      sr < 0 || sc < 0 || sr >= row || sc >= col || image[sr][sc] != c
    ) return;
    image[sr][sc] = color;
    dfs(image, sr + 1, sc, color, c);
    dfs(image, sr - 1, sc, color, c);
    dfs(image, sr, sc + 1, color, c);
    dfs(image, sr, sc - 1, color, c);
  }

  private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    dfs(image, sr, sc, color, image[sr][sc]);
    return image;
  }

  public static void main(String[] args) {
    int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    int sr = 1, sc = 1, color = 2;
    System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
  }
}
