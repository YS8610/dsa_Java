public class lc1855 {
  public int maxDistance(int[] nums1, int[] nums2) {
    int l = nums1.length;
    int ans = 0;
    for (int i = 0, tmp = 0; i < l; i++) {
      tmp = bs(nums1[i], nums2);
      ans = Math.max(ans, tmp - i);
    }
    return ans;
  }

  public int bs(int key, int[] nums2) {
    if (key > nums2[0])
      return -1;
    int l = nums2.length;
    if (key < nums2[l - 1])
      return l - 1;
    int lp = 0;
    int rp = l - 1;
    int mp;
    while (lp < rp) {
      mp = (lp + rp + 1) / 2;
      if (key <= nums2[mp])
        lp = mp;
      else
        rp = mp - 1;
    }
    return lp;
  }
}
