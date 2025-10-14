public class lc11 {
  
  public int maxArea1(int[] height) {
    int l = height.length;
    int lp = 0, rp = l - 1;
    int ans = (l - 1) * Math.min(height[lp], height[rp]);
    while (lp < rp) {
      if (height[lp] <= height[rp])
        lp++;
      else
        rp--;
      ans = Math.max(ans, Math.min(height[lp], height[rp]) * (rp - lp));
    }
    return ans;
  }

  private static int maxArea(int[] height) {
    int largestArea = 0;
    int lp = 0;
    int rp = height.length - 1;
    while (lp < rp) {
      int area = Math.min(height[lp], height[rp]) * (rp - lp);
      largestArea = largestArea < area ? area : largestArea;
      if (height[lp] < height[rp])
        lp++;
      else if (height[lp] > height[rp])
        rp--;
      else
        lp++;
    }
    return largestArea;
  }

  public static void main(String[] args) {
    int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

    System.out.println(maxArea(height));
  }
}
