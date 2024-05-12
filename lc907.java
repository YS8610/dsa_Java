
public class lc907 {
  private static int sumSubarrayMins(int[] arr) {
    // final int mod = (int) Math.pow(10, 9)+7;
    long ans = arr[0];
    int len = arr.length;
    int min = arr[0];
    for (int i=0;i<len;i++){
      min = Math.min(min, arr[i]);
      ans += min * i + arr[i];
    }
    return (int)ans;
  }

  private static int sumSubarrayMins1(int[] arr) {
    final int mod = (int) Math.pow(10, 9)+7;
    int min;
    int ans=0;
    int len = arr.length;

    for (int i =0;i<len;i++){
      min = arr[i];
      for (int j=i; j<len;j++){
        min = Math.min(min, arr[j]);
        if (ans>=mod) ans = (ans+min)%mod;
        else ans +=min;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {3,1,2,4};
    System.out.println(sumSubarrayMins(arr));
  }
}
// 3,  1,1  1,1,2  ,
