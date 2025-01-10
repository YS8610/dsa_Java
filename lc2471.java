import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class lc2471{

	public int minimumOperations(TreeNode root) {
		TreeNode cp = root;
		Deque<TreeNode> q = new ArrayDeque<>();
		q.add(cp);
		TreeNode tmp;
		int ans = 0;
		List<int[]> list = new ArrayList<>();
		boolean sorted = true;
		int tmp0;
		int tmp1;
		while (!q.isEmpty()){
			list.clear();
			sorted = true;
			for (int i=0, n=q.size(), p=0;i<n;i++){
				tmp = q.pollFirst();
				if (tmp.left != null) q.add(tmp.left);
				if (tmp.right != null) q.add(tmp.right);
				list.add(new int[]{tmp.val, p++});
			}	
			Collections.sort(list,
				(m1,m2) -> Integer.compare(m1[0], m2[0])
			);
			while (!revert(list)){
				for (int i=0, n=list.size();i<n;i++){
					if (list.get(i)[1] == i)
						continue;
					tmp0 = list.get(i)[0];
					tmp1 = list.get(i)[1];
					list.get(i)[0] = list.get(tmp1)[0];
					list.get(i)[1] = list.get(tmp1)[1];
					list.get(tmp1)[0] = tmp0;
					list.get(tmp1)[1] = tmp1;
					ans++;
				}
			}
		}
		return ans;
	}
	
	private static boolean revert(List<int[]> list){
		for (int i=0, n=list.size();i<n;i++)
			if (list.get(i)[1] != i)
				return false;
		return true;
	}
}
