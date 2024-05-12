import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc350 {
  private static int[] intersect(int[] nums1, int[] nums2){
    Map<Integer,Integer> m1 = new HashMap<>();
    Map<Integer,Integer> m2 = new HashMap<>();
    for (int n1 :nums1){
      if (m1.containsKey(n1) ) m1.put(n1, m1.get(n1)+1);
      else m1.put(n1,1);
    }
    for (int n2 :nums2){
      if (m2.containsKey(n2) ) m2.put(n2, m2.get(n2)+1);
      else m2.put(n2,1);
    }
    int l1 = m1.size();
    int l2 = m2.size();
    List<Integer> ans = new ArrayList<>();
    if (l1>=l2){
      for (int k1:m1.keySet()){
        if (m2.containsKey(k1) ) for (int i=0, n=Math.min(m1.get(k1),m2.get(k1));i<n;i++) ans.add(k1);
      }
    }
    else {
      for (int k2 :m2.keySet()){
        if (m1.containsKey(k2) ) for (int i=0, n=Math.min(m1.get(k2),m2.get(k2));i<n;i++) ans.add(k2);
      }
    }
    return ans.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
    System.out.println( Arrays.toString( intersect(nums1,nums2) ) );
  }
}
