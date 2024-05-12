import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lc216 {
  private static List<List<Integer>> combinationSum3(int k, int n){
    int[] nums = new int[10];
    for (int i=1;i<10;i++) nums[i] = i;
    List<List<Integer>> finalans = new ArrayList<>();
    finalans.add(new ArrayList<>());
    finalans.add(new ArrayList<>( Arrays.asList(nums[1]) ));

    for (int i=2;i<10;i++){
      List<List<Integer>> temp = new ArrayList<>( finalans.stream().map(ArrayList::new).collect(Collectors.toList()) );
      for (List<Integer> t : temp) {
        if (t.size()<k){
          t.add(nums[i]);
          if (t.stream().mapToInt(Integer::intValue).sum() <=n ){
            finalans.add(new ArrayList<>(t));
          }
        }
      }
    }
    List<List<Integer>> ans = finalans.stream()
                                      .filter(x -> x.size() == k && x.stream().mapToInt(Integer::intValue).sum()==n )
                                      .toList();
    return ans;
  }

  public static void main(String[] args) {
    int k = 9, n = 50;
    System.out.println( combinationSum3(k,n) );
  }
}
