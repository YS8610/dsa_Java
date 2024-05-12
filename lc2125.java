public class lc2125 {

  private static int numberOfBeams(String[] bank) {
    int len = bank.length;
    int rowLen = bank[0].length();
    int[] devices = new int[len];
    int rp = 0;
    int ans = 0;
    if (len == 1) return 0;
    for (int r = 0; r < len; r++) {
      for (int i = 0; i < rowLen; i++) {
        if (bank[r].charAt(i) == '1') devices[r]++;
      }
    }
    for (int i = 0; i < len - 1; i++) {
      rp = i + 1;
      while (rp < len && devices[rp] == 0) rp++;
      if (rp > len - 1) break;
      ans += devices[i] * devices[rp];
      i = rp - 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] bank = {"011001","000000","010100","001000"};
    System.out.println( numberOfBeams(bank));
  }
}
