import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1395 {

  private static int dfsi(int[] rating, int idx, int prev, int count, Map<List<Integer>,Integer> map) {
    int len = rating.length;
    if (count >= 2) return 1;
    if (idx >= len) return 0;
    if (map.containsKey(List.of(idx,count))) return map.get(List.of(idx,count));
    int ans = 0;
    for (int i = idx + 1; i < len; i++) {
      if (rating[i] <= rating[idx]) continue;
      ans += dfsi(rating, i, rating[idx], count + 1, map);
    }
    map.put(List.of(idx,prev,count), ans);
    return ans;
  }

  private static int dfsd(int[] rating, int idx, int prev, int count, Map<List<Integer>,Integer> map) {
    int len = rating.length;
    if (count >= 2) return 1;
    if (idx >= len) return 0;
    if (map.containsKey(List.of(idx,count))) return map.get(List.of(idx,count));
    int ans = 0;
    for (int i = idx + 1; i < len; i++) {
      if (rating[i] >= rating[idx]) continue;
      ans += dfsd(rating, i, rating[idx], count + 1, map);
    }
    map.put(List.of(idx,count), ans);
    return ans;
  }

  private static int numTeams(int[] rating) {
    int ans = 0;
    for (int i = 0, n = rating.length; i < n; i++) {
      ans += dfsi(rating, i, 0, 0, new HashMap<>());
      ans += dfsd(rating, i, rating[i] + 1, 0, new HashMap<>());
    }
    return ans;
  }

  private static int numTeams1(int[] rating) {
    int len = rating.length;
    int ans = 0;
    for (int i=1;i<len-1;i++){
      int smaller = 0;
      int bigger = 0;
      for (int j=0; j<i;j++){
        if (rating[j]<rating[i]) smaller++;
      }
      for( int k=i+1;k<len;k++){
        if (rating[k]>rating[i]) bigger++;
      }
      ans += smaller * bigger + (i-smaller) * (len-1-i-bigger);
    }
    return ans;
  }



  public static void main(String[] args) {
    int[] rating = {2,5,3,4,1 };
    System.out.println(numTeams1(rating));
  }
}
