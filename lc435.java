import java.util.Arrays;


public class lc435 {

  private static int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (m1,m2)->{
      if (m1[1]==m2[1]) return Integer.compare(m1[0], m2[0]);
      return Integer.compare(m1[1], m2[1]);
    });
    int[] temp = intervals[0];
    int ans = 0;
    for(int[] i : intervals){
      if (temp[1]<=i[0]) temp = i;
      else ans++;
    }
    return ans-1;
  }

  public static void main(String[] args) {
    // int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
    // int[][] intervals = { { 0,1 }, { 3,4 }, { 1, 2 } };
    // int[][] intervals = { { 1, 2 }, { 1,2 }, { 1,2 }, { 1,2 } };
    int[][] intervals = {
      { -45771, 43174 },
      { -43730, -33388 },
      { -38240, 17122 },
      { -37497, -1380 },
      { -36639, 1280 },
      { -34683, 27103 },
      { -22692, 16373 },
      { -22621, -2258 },
      { -21774, 21717 },
      { -20502, 33620 },
      { -15372, 11264 },
      { -12327, -4978 },
      { -3943, 45736 },
      { -2602, 47669 },
      { -81, 38395 },
      { 840, 35984 },
      { 3742, 19258 },
      { 15345, 23474 },
      { 20443, 34360 },
      { 23847, 24423 },
      { 31334, 34657 },
      { 38798, 39394 },
      { 41254, 46599 },
      { 47229, 49062 },
      { 47816, 47915 },
    };
    System.out.println(eraseOverlapIntervals(intervals));
  }
}
