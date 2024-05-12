import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class lc90 {
  private static List<List<Integer>> subsetsWithDup(int[] nums){
    int n = nums.length;
    List<List<Integer>> finalans = new ArrayList<>();
    finalans.add(new ArrayList<>());
    if(n==0) return finalans;
    finalans.add( new ArrayList<>( Arrays.asList(nums[0])) );
    if(n==1) return finalans;
    List<List<Integer>> prev = new ArrayList<>(finalans.stream().map(ArrayList::new).collect(Collectors.toList()) );
    for (int i=1;i<n;i++){
      for (List<Integer> p : prev){
        p.add(nums[i]);
        finalans.add(new ArrayList<>(p));
      }
      prev = new ArrayList<>(finalans.stream().map(ArrayList::new).collect(Collectors.toList()));
    }
    Set<List<Integer>> set = new HashSet<>(finalans);
    Set<List<Integer>> setSorted = new HashSet<>();
    for (List<Integer> s :set ){
      s.sort((m1,m2)-> m1.compareTo(m2));
      setSorted.add( new ArrayList<>(s));
    }
    return new ArrayList<>(setSorted);
  }


  public static void main(String[] args) {
    int[] nums = {4,4,4,1,4};
    // System.out.println( subarray(nums, 3).toString());
    System.out.println( subsetsWithDup(nums).toString());
  }
}
