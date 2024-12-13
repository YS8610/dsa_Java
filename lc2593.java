import java.util.PriorityQueue;

public class lc2593 {
  private static long findScore(int[] nums) {
		long ans = 0;
		boolean[] marked = new boolean[nums.length];
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(m1,m2) -> {
				if (m1[0] == m2[0]) 
					return Integer.compare(m1[1],m2[1]);
				return Integer.compare(m1[0],m2[0]);
			}
		);
		for (int i =0, n=nums.length;i<n;i++)
			pq.add(new int[]{nums[i], i});
		int[] tmp;
		while (!pq.isEmpty()){
			tmp = pq.poll();
			if (marked[tmp[1]]) continue;
			ans += tmp[0];
			marking(marked, tmp[1]-1);
			marking(marked, tmp[1]+1);
		}
		return ans;
  }

  private static void marking(boolean[] marked, int idx){
		int l = marked.length;
		if (idx < 0 || idx >= l) return;
		marked[idx] = true;
	}
}
