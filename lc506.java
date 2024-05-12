import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc506 {
  private static String[] findRelativeRanks(int[] score) {
    int l = score.length;
    int[] tmp = Arrays.copyOf(score, l);
    Arrays.sort(tmp);
    Map<Integer,Integer> map = new HashMap<>();
    for (int i=0;i<l;i++) map.put(tmp[i], l-i);
    String[] ans = new String[l];
    for (int i =0;i<l;i++){
      if (map.get(score[i]) == 1) ans[i] = "Gold Medal"; 
      else if (map.get(score[i]) == 2) ans[i] = "Silver Medal"; 
      else if (map.get(score[i]) == 3) ans[i] = "Bronze Medal"; 
      else ans[i] = String.valueOf(map.get(score[i])); 
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] score = {10,3,8,9,4};
    System.out.println(Arrays.toString(findRelativeRanks(score)));
  }
}
