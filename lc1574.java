public class lc1574 {

  public int findLengthOfShortestSubarray(int[] arr) {
    int l = arr.length;
    int lp = 0;
    int rp = l - 2;
    while (lp < l - 1 && arr[lp] <= arr[lp + 1]) lp++;
    if (lp == l - 1) return 0;
    while (rp >= 0 && arr[rp] <= arr[rp + 1]) rp--;
    rp++;
    if (lp == 0 && rp == l - 1) return arr[lp] <= arr[rp] ? l - 2 : l - 1;
    int ans = Math.min(l - lp - 1, rp);
    int i = 0;
    while (rp < l) {
      while (i <= lp && arr[i] <= arr[rp]) {
        ans = Math.min(ans, l - (l - rp) - (i + 1));
        i++;
      }
      rp++;
    }
    return ans;
  }
}
