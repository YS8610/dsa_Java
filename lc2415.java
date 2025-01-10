import java.util.ArrayDeque;
import java.util.Deque;

public class lc2415 {
	public TreeNode reverseOddLevels(TreeNode root) {
		Deque<TreeNode> q = new ArrayDeque<>();
		Deque<Integer> qNum = new ArrayDeque<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		int lvl = 0;
		TreeNode cp = root;
		q.add(cp);
		int tmp;
		while (!q.isEmpty()){
			for (int i=0, n=q.size();i<n;i++){
				cp = q.pollFirst();
				if ((lvl & 1)==1){
					stack.add(cp);
					qNum.add(cp.val);
				}
				if (cp.left != null) q.add(cp.left);
				if (cp.right != null) q.add(cp.right);
			}
			while (!stack.isEmpty()){
				tmp = qNum.pollFirst();
				cp = stack.pollLast();
				cp.val = tmp;
			}
			lvl++;
		}
		return root;
	}
}
