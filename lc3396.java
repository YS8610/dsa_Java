import java.util.ArrayDeque;
import java.util.Deque;

public class lc3396 {
	private static boolean distinct(int[] map){
		for (int m:map)
			if (m > 1)
				return false;
		return true;
	}
	
	private static int minimumOperations1(int[] nums) {
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

  static public int minimumOperations(int[] nums) {
    int l = nums.length;
    int[] map = new int[101];
    for (int n : nums)
        map[n]++;
    int ans = 0;
    if (can(map))
        return ans;
    for (int i=0; i<l;i+=3){
        travel(nums, map, i, 3);
        ans++;
        if (can(map))
            return ans;
    }
    return ans;
}

static private void travel(int[] nums, int[] map, int i, int count){
    int l = nums.length;
    if (count <= 0 || i >= l)
        return;
    map[nums[i]]--;
    travel(nums, map, i+1, count - 1);
}

static private boolean can(int[] map){
    for (int n : map)
        if (n >1)
            return false;
    return true;
}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,2,3,3,5,7};
		System.out.println(minimumOperations(nums));
		System.out.println(minimumOperations1(nums));
	}
}
