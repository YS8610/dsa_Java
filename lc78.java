import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lc78 {
  private static List<List<Integer>> subsets1(int[] nums){
    List<List<Integer>> ans = new ArrayList<>();
    
    if (nums.length==0) return new ArrayList<>();
    if (nums.length==1) {
      ans.add(new ArrayList<>());
      ans.add( new ArrayList<>( Arrays.asList(nums[0])) );
      return ans;
    }

    List<List<Integer>> result = subsets1( Arrays.copyOfRange(nums, 0, nums.length-1) ) ;
    for (int i=0, n = result.size(); i<n;i++ ){
      if (!result.get(i).isEmpty()) {
        List<Integer> temp = new ArrayList<>(result.get(i));
        temp.add( nums[nums.length-1] );
        result.add( new ArrayList<>(temp));
      }
    }
    result.add( Arrays.asList( nums[nums.length-1] ));
    ans = new ArrayList<>( result.stream()
                                  .map(ArrayList::new)
                                  .collect(Collectors.toList()) );

    return ans;
  }

  private static List<List<Integer>> subsets(int[] nums){
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    dfs(nums, 0, new ArrayList<>(), ans);
    return ans;
  }

  private static void dfs(int[] nums, int i, List<Integer> a, List<List<Integer>> ans){
    if (i>=nums.length) return;
    a.add(nums[i]);
    ans.add( new ArrayList<>(a) );
    dfs(nums, i+1, a, ans);
    a.remove(a.size()-1);
    dfs(nums, i+1, a, ans);
  }

  public static void main(String[] args) {
    int[] nums = {0,1,2};
    System.out.println( subsets1(nums).toString() );
    System.out.println( subsets(nums).toString() );
  }
}
