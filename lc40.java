import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc40 {
  private static List<List<Integer>> combinationSum(int[] candidates, int target){
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(candidates, 0, target, new ArrayList<>(), ans);
    return ans;
  }

  private static void dfs(int[] candidates, int i, int target, List<Integer> a, List<List<Integer>> ans){
    if (target==0) {
      ans.add(new ArrayList<>(a));
      return;
    }
    if (i >= candidates.length || target < 0) return;
    a.add(candidates[i]);
    dfs(candidates, i+1, target - candidates[i], a, ans);
    a.remove(a.size()-1);
    int search = Arrays.binarySearch(candidates, candidates[i]);
    int j = search;
    while (search >=0 && j < candidates.length){
      search = Arrays.binarySearch(candidates,j+1, candidates.length,candidates[i]);
      if (search>=0) j = search;
    }
    dfs(candidates, j+1, target, a, ans);
  }

  public static void main(String[] args) {
    int[] candidates = {4,4,2,1,4,2,2,1,3};
    // int[] candidates = {10,1,2,7,6,1,5};
    int target = 8;

    System.out.println( combinationSum(candidates,target).toString() );
  }
}
