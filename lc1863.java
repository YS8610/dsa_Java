import java.util.ArrayList;
import java.util.List;

public class lc1863 {
  private static void dfs(int[] num, int i, List<Integer> subl, List<List<Integer>> l){
    if (i>=num.length) return;
    subl.add(num[i]);
    l.add(new ArrayList<>(subl));
    dfs(num,i+1,subl,l);
    subl.remove(subl.size()-1);
    dfs(num,i+1,subl,l);
  }

  
  private static int subsetXORSum(int[] nums) {
    List<List<Integer>> l = new ArrayList<>();
    dfs(nums,0,new ArrayList<>(),l);
    int ans = 0;
    int tmp;
    for (List<Integer> a : l){
      if (a.size()==0) continue;
      tmp = a.get(0);
      for (int i=1, n=a.size();i<n;i++){
        tmp ^=a.get(i);
      }
      ans += tmp;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {3,4,5,6,7,8};
    System.out.println(subsetXORSum(nums));
  }
}
