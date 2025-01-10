import java.util.ArrayDeque;
import java.util.Deque;

class lc1475 {
	public int[] finalPrices(int[] prices) {
		int[] ans = new int[prices.length];
		// element, index
		Deque<int[]> stack = new ArrayDeque<>();
		int[] tmp;
		for (int i =0, n= prices.length; i<n;i++){
			if (stack.isEmpty()){
				stack.add(new int[]{prices[i], i});
				continue;
			}
			while (!stack.isEmpty() && stack.peekLast()[0] >= prices[i]){
				tmp = stack.pollLast();
					ans[tmp[1]] = tmp[0] - prices[i];
			}
			stack.add(new int[]{prices[i], i});
		}
		while (!stack.isEmpty()){
			tmp = stack.pollLast();
			ans[tmp[1]] = tmp[0];
		}
		return ans;
	}
}
