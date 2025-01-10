import java.util.PriorityQueue;

public class lc3398 {
	private static int minLength(String s, int numOps) {
		int l = s.length();
		int[] nums = new int[l];
		for (int i =0;i<l;i++)
			nums[i] = (s.charAt(i) - '0');
		int lp=0;
		int rp=0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(m1,m2) -> Integer.compare(m2[1]-m2[0], m1[1]-m1[0])
		);
		while (lp < l){
			rp = 0;
			while (lp+rp < l && nums[lp] == nums[lp+rp])
				rp++;
			pq.add(new int[]{lp,lp+rp});
			lp += rp;
		}
		int[] tmp;
		int half;
		while (numOps > 0){
			tmp = pq.poll();
			if (tmp[1]-tmp[0] == 1)
				return 1;
			half = (tmp[1] - tmp[0])/2 + tmp[0];
			nums[half] = nums[half]==0?1:0;
			pq.add(new int[]{tmp[0], half});
			if (half+1 == tmp[1])
				pq.add(new int[]{half, half+subarrlen(nums, half)});
			else
				pq.add(new int[]{half+1, tmp[1]});
			numOps--;
		}
		return pq.peek()[1]-pq.peek()[0];
	}

	private static int subarrlen(int[] nums, int i){
		int rp = 0;
		while (i+rp<nums.length && nums[i] == nums[i+rp])
			rp++;
		return rp;
	}

	public static void main(String[] args) {
		String s = "1001";
		int numOps = 1;
		System.out.println(minLength(s, numOps));
	}
}
