import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc846 {
  private static boolean isNStraightHand(int[] hand, int groupSize) {
    int len = hand.length;
    if (len % groupSize != 0) return false;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : hand) {
      if (map.containsKey(i)) map.put(i, map.get(i) + 1);
      else map.put(i, 1);
    }
    int[] sortedSet = map.keySet().stream().mapToInt(Integer::valueOf).toArray();
    Arrays.sort(sortedSet);
    int lp=0;
    int prev = sortedSet[0];
    for (int i=0,n=len/groupSize;i<n;i++ ){
      for (int j=0; j<groupSize;j++){
        if (j==0) {
          while (lp<sortedSet.length && map.get(sortedSet[lp])==0) lp++;
          prev = sortedSet[lp];
          map.put(sortedSet[lp], map.get(sortedSet[lp])-1);
        }
        else {
          if (lp+j>=sortedSet.length ) return false;
          if (map.get(sortedSet[lp+j])<=0) return false;
          map.put(sortedSet[lp+j], map.get(sortedSet[lp+j])-1);
          if (sortedSet[lp+j]-prev>1) return false;
          prev = sortedSet[lp+j];
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] hand = {1,2,3,6,2,3,4,7,8};
    int groupSize = 3;
    System.out.println( isNStraightHand(hand, groupSize));
  }
}
