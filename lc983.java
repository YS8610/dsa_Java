import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class lc983{
	private static int mincostTickets(int[] days, int[] costs) {
		return dfs(days, costs, 0, new HashMap<>());
	}

	private static int dfs(int[] days, int[] costs, int i, Map<Integer,Integer>memo){
		int l = days.length;
		if (i >= l) return 0;
		if (memo.containsKey(i)) return memo.get(i);
		int ans = Integer.MAX_VALUE;
		ans = Math.min(ans, dfs(days, costs, i+1, memo)+costs[0]);
		int pos7 = Arrays.binarySearch(days, days[i]+7);
		pos7 =pos7>=0?pos7:-pos7 -1;
		ans = Math.min(ans, dfs(days, costs, pos7, memo)+costs[1]);
		int pos30 = Arrays.binarySearch(days, days[i]+30);
		pos30 =pos30>=0?pos30:-pos30 -1;
		ans = Math.min(ans, dfs(days, costs, pos30, memo)+costs[2]);
		memo.put(i, ans);
		return ans;
	}
	
	
  private static int mincostTickets1(int[] days, int[] costs) {
		boolean[] q = new boolean[366];
		for (int d: days) q[d] = true;
		return dsf1(q, costs);
	}

	private static int dsf1(boolean[] q, int[] cost){
		int pos = fTrue(q);
		if (pos==-1) return 0;
		int ans = Integer.MAX_VALUE;
		boolean[] one = Arrays.copyOf(q, 366);
		ff(one, pos, 1);
		boolean[] seven = Arrays.copyOf(q, 366);
		ff(seven, pos, 7);
		boolean[] thirty = Arrays.copyOf(q, 366);
		ff(thirty, pos, 30);
		ans = Math.min(ans, dsf1(one, cost)+cost[0]);
		ans = Math.min(ans, dsf1(seven, cost)+cost[1]);
		ans = Math.min(ans, dsf1(thirty, cost)+cost[2]);
		return ans;
	}

	private static int fTrue(boolean[] q){
		for (int i =0; i<366;i++)
			if (q[i])
				return i;
		return -1;
	}

	private static void ff(boolean[] q, int pos, int amt){
		int finalpos = Math.min(pos+amt, 366);
		Arrays.fill(q, pos, finalpos, false);
	}

	public static void main(String[] args){
		int[] days = {1,4,6,7,8,20};
		int[] costs = {2,7,15};
		System.out.println(mincostTickets(days, costs));
	}

}
