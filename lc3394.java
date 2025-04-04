import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc3394 {
  static public boolean checkValidCuts(int n, int[][] rectangles) {
    // sort by x
    Arrays.sort(rectangles, (m1, m2) -> {
      if (m1[0] == m2[0])
        return Integer.compare(m1[2], m2[2]);
      return Integer.compare(m1[0], m2[0]);
    });
    boolean ans = merge(rectangles, true, n);
    if (ans)
      return true;
    // sort by y
    Arrays.sort(rectangles, (m1, m2) -> {
      if (m1[1] == m2[1])
        return Integer.compare(m1[3], m2[3]);
      return Integer.compare(m1[1], m2[1]);
    });
    ans = merge(rectangles, false, n);
    if (ans)
      return true;
    return false;
  }

  private static boolean merge(int[][] rectangles, boolean x, int n){
    int j = x?0:1;
    int l = rectangles.length;
    List<int[]> tmp = new ArrayList<>();
    int len;
    for (int i =0; i<l;i++){
      if (tmp.isEmpty()){
        tmp.add(new int[]{rectangles[i][j], rectangles[i][j+2]});
        continue;
      }
      len = tmp.size();
      if (tmp.get(len-1)[1] <= rectangles[i][j])
        tmp.add(new int[]{rectangles[i][j], rectangles[i][j+2]});
      else
        tmp.get(len-1)[1] = tmp.get(len-1)[1] > rectangles[i][j+2]? tmp.get(len-1)[1] : rectangles[i][j+2];
    }
    len = tmp.size();
    if (tmp.size() >= 3)
      return true;
    return false;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] rectangles = {{0,0,1,3},{1,0,2,2},{2,0,3,2},{1,2,3,3}};
    System.out.println(checkValidCuts(n, rectangles));
  }
}
