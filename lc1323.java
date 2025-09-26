public class lc1323 {
  public int maximum69Number(int num) {
    int[] tmp = new int[10];
    int p = 0;
    while (num > 0) {
      tmp[p++] = num % 10;
      num /= 10;
    }
    for (int i = p - 1; i >= 0; i--) {
      if (tmp[i] == 6) {
        tmp[i] = 9;
        break;
      }
    }
    int ans = 0;
    for (int i = p - 1; i >= 0; i--)
      ans = tmp[i] + ans * 10;
    return ans;
  }
}
