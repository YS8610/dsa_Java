public class lc845 {
  private static int longestMountain(int[] arr) {
    int l = arr.length;
    int[] dp = new int[l];
    int ans=0;
    dp[0] = 0;
    for (int i=1;i<l;i++)
      dp[i] = arr[i]-arr[i-1];
    int i =0;
    int j=0;
    int tmp;
    while (i < l){
      j = 0;
      if (dp[i]> 0){
        tmp =0;
        while (i+j<l && dp[i+j] > 0)
          j++;
        tmp = j;
        while (i+j<l && dp[i+j] < 0)
          j++;
        if (tmp < j)
          ans = Math.max(ans, j);
      }
      if (j ==0) i++;
      else i+=j;
    }
    return ans==0?0:ans+1;
  }

  public static void main(String[] args) {
    int[] arr = {2,2,2};
    System.out.println(longestMountain(arr));
  }
}
