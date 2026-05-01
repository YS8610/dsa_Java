public class lc1888 {
  public int minFlips(String s) {
    int l = s.length();
    int[] start1 = new int[l + 1];
    int[] start0 = new int[l + 1];
    int ans = l + 1;
    for (int i = 0; i < l; i++) {
      if (i % 2 == 0) {
        start1[i + 1] = start1[i] + (s.charAt(i) == '1' ? 0 : 1);
        start0[i + 1] = start0[i] + (s.charAt(i) == '0' ? 0 : 1);
        continue;
      }
      start1[i + 1] = start1[i] + (s.charAt(i) == '1' ? 1 : 0);
      start0[i + 1] = start0[i] + (s.charAt(i) == '0' ? 1 : 0);
    }
    // 101010
    // System.out.println(Arrays.toString(start1));
    // 010101
    // System.out.println(Arrays.toString(start0));
    ans = Math.min(start1[l], start0[l]);
    int tmp1, tmp0, subans1, subans2;
    for (int i = 1, tmp = 0; i < l; i++) {
      tmp1 = start1[l] - start1[i];
      tmp0 = start0[l] - start0[i];
      tmp = (l - i) % 2;
      // odd position
      if (i % 2 != 0) {
        // start with 1
        subans1 = tmp0 + (tmp == 1 ? start0[i] : start1[i]);
        // start with 0
        subans2 = tmp1 + (tmp == 1 ? start1[i] : start0[i]);
        ans = Math.min(ans, Math.min(subans1, subans2));
        continue;
      }
      // even position
      // start with 1
      subans1 = tmp1 + (tmp == 1 ? start0[i] : start1[i]);
      // start with 0
      subans2 = tmp0 + (tmp == 1 ? start1[i] : start0[i]);
      ans = Math.min(ans, Math.min(subans1, subans2));
    }
    return ans;
  }
}
