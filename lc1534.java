public class lc1534 {
  public int countGoodTriplets(int[] arr, int a, int b, int c) {
    int l = arr.length;
    int ans = 0;
    for (int i = 0, n = l - 2; i < n; i++)
      for (int j = i + 1, m = l - 1; j < m; j++)
        for (int k = j + 1; k < l; k++)
          ans += Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c ? 1 : 0;
    return ans;
  }
}
