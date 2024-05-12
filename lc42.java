public class lc42 {

  private static int trap(int[] height) {
    int max = 0;
    int l = height.length;
    int lp;
    int rp;
    int ans = 0;
    for (int h : height) max = Math.max(max, h);
    for (int i = 0; i < max; i++) {
      lp = 0;
      rp = l - 1;
      if (i > 0) {
        for (int j = 0; j < l; j++) height[j] =
          height[j] - 1 >= 0 ? height[j] - 1 : 0;
      }
      // finding the both edge
      while (height[lp] == 0 && lp < rp) lp++;
      while (height[rp] == 0 && lp < rp) rp--;
      // counting zero between both edges
      while (++lp < rp) {
        if (height[lp] == 0) ans++;
      }
    }
    return ans;
  }

  private static int trap1(int[] height) {
    int l = height.length;
    int[] left = new int[l];
    int[] right = new int[l];
    int ans = 0;
    int temp;
    left[0] = 0;
    right[l-1] = 0;
    for (int i =1; i<l;i++)
      left[i] = Math.max(left[i-1], height[i-1]);
    for (int i=l-2;i>=0;i--)
      right[i] = Math.max(right[i+1], height[i+1]);
    for (int i=0;i<l;i++){
      temp = Math.min(left[i], right[i]) - height[i];
      ans += temp>0?temp:0;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trap1(height));
    System.out.println(trap(height));
  }
}
