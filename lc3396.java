import java.util.ArrayDeque;
import java.util.Deque;

public class lc3396 {
	private static boolean distinct(int[] map){
		for (int m:map)
			if (m > 1)
				return false;
		return true;
	}
	
	private static int minimumOperations(int[] nums) {
		int ans =0;
		int[] map = new int[101];
		Deque<Integer> q = new ArrayDeque<>();
		for (int n:nums){
			q.add(n);
			map[n]++;
		}
		if (distinct(map)) return 0;
		while (!q.isEmpty()){
			for (int i=0; i<3 && !q.isEmpty();i++)
				map[q.pollFirst()]--;
			ans++;
			if (distinct(map)) return ans;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {4,5,6,4,4};
		System.out.println(minimumOperations(nums));
	}
}
