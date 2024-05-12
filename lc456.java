import java.util.Stack;

public class lc456 {
  private static boolean find132pattern(int[] nums) {
    Stack<Integer> s = new Stack<>();
    int top;
    int low = nums[0];
    int high = nums[0];
    boolean isPop = false;
    if (nums.length < 3) return false;
    for (int n : nums) {
      if (s.isEmpty()) {
        s.add(n);
        continue;
      }
      top = s.peek();
      while (!s.isEmpty() && top >= n) {
        high = Math.max(s.pop(), high);
        isPop = true;
        if (!s.isEmpty()) {
          top = s.peek();
          low = Math.min(low, top);
        }
      }
      s.add(n);
      if (isPop && low < n && high > n ) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    // int nums[] = {0,3,5,0,3};
    // int nums[] = {1,0,1,-4,-3};
    int nums[] = {1,2,3,4,-4,-3,-5,-1};
    System.out.println(find132pattern(nums));
  }
}
