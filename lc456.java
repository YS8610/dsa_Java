import java.util.ArrayDeque;
import java.util.Deque;

public class lc456 {
  private static boolean find132pattern(int[] nums) {
    if (nums.length < 3) return false;
    Deque<int[]> s = new ArrayDeque<>();
		int l = nums.length;
		s.addLast(new int[]{nums[0], nums[0]});
		for (int i=0;i<l;i++){
			while (!s.isEmpty() && s.peekLast()[0] > nums[i]){
				if (s.peekLast()[1] < nums[i]) return true;
				s.removeLast();
			}
			if (s.isEmpty()) s.addLast(new int[]{nums[i], nums[i]});
			else s.addLast(new int[]{nums[i], s.peekLast()[1]});
		}
		return false;
  }

  public static void main(String[] args) {
    int nums[] = {0,3,5,0,4};
    // int nums[] = {1,0,1,-4,-3};
    // int nums[] = {1,2,3,4,-4,-3,-5,-1};
    System.out.println(find132pattern(nums));
  }
}
