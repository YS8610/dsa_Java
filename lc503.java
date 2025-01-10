import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc503 {
	public int[] nextGreaterElements(int[] nums) {
		int l = nums.length;
		int[] ans = new int[l];
		Arrays.fill(ans, -1);
		//element, index
		Deque<int[]> stack = new ArrayDeque<>();
		int[] tmp;
		for (int i=0; i<l;i++){
			if (stack.isEmpty()){
				stack.add(new int[]{nums[i], i});
				continue;
			}
			while (!stack.isEmpty() && stack.peekLast()[0] < nums[i]){
				tmp = stack.pollLast();
				ans[tmp[1]] = nums[i];	
			}
			stack.add(new int[]{nums[i], i});
		}
		for (int i=0; i<l;i++){
			if (stack.isEmpty()){
				stack.add(new int[]{nums[i], i});
				continue;
			}
			while (!stack.isEmpty() && stack.peekLast()[0] < nums[i]){
				tmp = stack.pollLast();
				ans[tmp[1]] = nums[i];	
			}
			stack.add(new int[]{nums[i], i});
		}
		return ans;
	}
}
