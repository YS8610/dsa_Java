import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc624 {
  private static int maxDistance(List<List<Integer>> arrays) {
    Collections.sort(arrays, (m1,m2)->{
      if (m1.get(0)==m2.get(0)) return Integer.compare(m2.get(m2.size()-1), m1.get(m1.size()-1));
      return Integer.compare(m1.get(0), m2.get(0));
    });
    int ans=Integer.MIN_VALUE;
    int ans1=Integer.MIN_VALUE;
    int lowest = arrays.get(0).get(0);
    int h = arrays.get(0).get(arrays.get(0).size()-1);
    for (int i =1, n=arrays.size(); i<n;i++){
      ans = Math.max(ans, arrays.get(i).get(arrays.get(i).size()-1) - lowest);
      ans1 = Math.max(ans1, h - arrays.get(i).get(0));
    }
    return Math.max(ans,ans1);
  }

  public static void main(String[] args) {
    List<List<Integer>> arrays = new ArrayList<>();
    arrays.add(List.of(1,2,3));
    arrays.add(List.of(4, 5));
    arrays.add(List.of(1,2,3));
    System.out.println(maxDistance(arrays));
  }
}
