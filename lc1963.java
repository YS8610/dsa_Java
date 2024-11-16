public class lc1963 {

  private static int minSwaps(String s) {
    int l = s.length();
    char[] arr = s.toCharArray();
    int ans = 0;
    int rp = l - 1;
    int tmp = 0;
    char swap;
    for (int i = 0; i < rp && i < l; i++) {
      if (arr[i] == ']') tmp++;
      if ((i + 1) - tmp < tmp) {
        while (i > rp && arr[rp] == ']') rp--;
        swap = arr[i];
        arr[i] = arr[rp];
        arr[rp] = swap;
        ans++;
        tmp--;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "]]][[[";
    System.out.println(minSwaps(s));
  }
}
