import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc3397 {
	private static int maxDistinctElements(int[] nums, int k) {
		Arrays.sort(nums);
		nums[0]-=k;
		Deque<Integer> s = new ArrayDeque<>();
		s.add(nums[0]);
		int i =1;
		int top, tmp, low, high;
		int l = nums.length;
		while (i < l){
			top = s.peekLast();
			tmp = nums[i++];
			low = tmp - k;
			high = tmp + k;
			// in range with top
			if (top+1>=low && top+1<=high)
				s.add(top+1);
			// low is below top
			else if (low >= top+1)
				s.add(low);
		}
		return s.size();
	}

	public static void main(String[] args) {
		int[] nums = {4,4,4,4};
		int k =1;
		System.out.println(maxDistinctElements(nums, k));
	}
}
