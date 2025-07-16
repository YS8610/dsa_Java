public class lc1007 {
  static public int minDominoRotations(int[] tops, int[] bottoms) {
    int l = tops.length;
    int ans = l;
    boolean skip = false;
    int up = 0;
    int down = 0;
    out: for (int i = 1; i < 7; i++) {
      up = 0;
      down = 0;
      skip = false;
      for (int j = 0; j < l; j++) {
        if (tops[j] == i || bottoms[j] == i) {
          up += tops[j] == i ? 1 : 0;
          down += bottoms[j] == i ? 1 : 0;
          continue;
        }
        skip = true;
        continue out;
      }
      if (!skip)
        ans = Math.min(ans, Math.min(l - up, l - down));
    }
    return ans == l ? -1 : ans;
  }

  public static void main(String[] av){
    int[] tops = {2,1,2,4,2,2}, bottoms = {5,2,6,2,3,2};
    System.out.println(minDominoRotations(tops, bottoms));
  }
}
