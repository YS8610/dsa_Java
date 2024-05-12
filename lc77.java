import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class lc77 {
  private static List<List<Integer>> combine(int n, int k) {
    int[] nums = new int[n];
    for (int i=0;i<n;i++) nums[i] = i+1;
    
    List<List<Integer>> finalans = new ArrayList<>();
    finalans.add(new ArrayList<>());
    finalans.add( new ArrayList<>( Arrays.asList(nums[0])) );
    if(n==1) {
      finalans.remove(0);
      return finalans;
    }
    List<List<Integer>> prev = new ArrayList<>(finalans.stream().map(ArrayList::new).collect(Collectors.toList()) );
    for (int i=1;i<n;i++){
      for (List<Integer> p : prev){
        if (p.size()<k){
          p.add(nums[i]);
          finalans.add(new ArrayList<>(p));
        }
      }
      prev = new ArrayList<>(finalans.stream().map(ArrayList::new).collect(Collectors.toList()));
    }
    Set<List<Integer>> set = new HashSet<>(finalans.stream().filter(x->x.size()==k).toList());
    Set<List<Integer>> setSorted = new HashSet<>();
    for (List<Integer> s :set ){
      s.sort((m1,m2)-> m1.compareTo(m2));
      setSorted.add( new ArrayList<>(s));
    }
    return new ArrayList<>(setSorted);
  }

  public static void main(String[] args) {
    int n = 4, k = 2;
    System.out.println( combine(n,k) );
  }
}
