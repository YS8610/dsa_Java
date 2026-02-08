public class lc944 {
  public int minDeletionSize(String[] strs) {
    int l = strs.length;
    int strl = strs[0].length();
    int ans = 0;
    for (int j = 0; j < strl; j++) {
      for (int i = 1; i < l; i++) {
        if (strs[i].charAt(j) >= strs[i - 1].charAt(j))
          continue;
        ans++;
        break;
      }
    }
    return ans;
  }
}
