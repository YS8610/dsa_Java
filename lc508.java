import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc508 {

  private static int dfs(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) return 0;
    int ans = root.val + dfs(root.left, map) + dfs(root.right, map);
    map.computeIfPresent(ans, (k, v) -> v + 1);
    map.computeIfAbsent(ans, k -> 1);
    return ans;
  }

  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    dfs(root, map);
    int max = 0;
    List<Integer> ans = new ArrayList<>(map.size());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
      max = Math.max(max, entry.getValue());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
      if (entry.getValue() == max) ans.add(entry.getKey());
    int[] finalans = new int[ans.size()];
    for (int i = 0, n = ans.size(); i < n; i++) finalans[i] = ans.get(i);
    return finalans;
  }
}
