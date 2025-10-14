import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;

class lc164 {

  static public int maximumGap(int[] nums) {
    int ans = 0;
    HashSet<Integer> set = new HashSet<>();
    int big = nums[0];
    int small = nums[0];
    for (int n : nums) {
      set.add(n);
      big = Math.max(big, n);
      small = Math.min(small, n);
    }
    int l = set.size();
    if (l == 1)
      return 0;
    if (l == 2) {
      for (int s : set)
        ans = Math.abs(ans - s);
      return ans;
    }
    int bsize = (big - small) / (l-1);
    int minbucket = small / bsize;
    int bigbucket = big / bsize;
    int[] bmin = new int[bigbucket - minbucket + 1];
    int[] bmax = new int[bigbucket - minbucket + 1];
    int tmp;
    Arrays.fill(bmin, Integer.MAX_VALUE);
    Arrays.fill(bmax, -1);
    int norm;
    for (int s : set) {
      tmp = s / bsize;
      norm = tmp - minbucket;
      bmin[norm] = Math.min(bmin[norm], s);
      bmax[norm] = Math.max(bmax[norm], s);
    }
    int prev = 0;
    for (int i =0;i<bmin.length;i++){
      if (bmax[i] == -1)
        continue;
      ans = Math.max(ans, bmin[i] - bmax[prev]);
      prev = i;
    }
    return ans;
  }

  static public int maximumGap1(int[] nums) {
    int big = nums[0];
    int small = nums[0];
    Set<Integer> set = new HashSet<>();
    Map<Integer, int[]> map = new HashMap<>();
    int[] tmp;
    int div;
    int ans = 0;
    for (int n : nums) {
      big = Math.max(big, n);
      small = Math.min(small, n);
      set.add(n);
    }
    int l = set.size();
    int bno = l - 1;
    if (l == 1)
      return 0;
    if (l == 2) {
      for (int s : set)
        ans = Math.abs(ans - s);
      return ans;
    }
    int bsize = (big - small) / bno;
    int sbucket = small / bsize;
    int bbucket = big / bsize;
    int mp;
    for (int n : set) {
      div = n / bsize;
      if (map.containsKey(div))
        tmp = map.get(div);
      else
        map.put(div, new int[] { big, small });
      tmp = map.getOrDefault(div, new int[] { big, small });
      tmp[0] = Math.min(tmp[0], n);
      tmp[1] = Math.max(tmp[1], n);
    }
    while (sbucket < bbucket) {
      mp = sbucket + 1;
      while (!map.containsKey(mp) && mp <= bbucket)
        mp++;
      if (mp > bbucket)
        break;
      ans = Math.max(ans, map.get(mp)[0] - map.get(sbucket)[1]);
      sbucket = mp;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 3,6,9,1 };
    System.out.println(maximumGap(nums));
  }
}
