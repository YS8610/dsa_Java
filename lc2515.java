public class lc2515 {
  static public int closestTarget(String[] words, String target, int startIndex) {
    int l = words.length;
    int ans = -1;
    int lp = startIndex;
    int rp = lp;
    // left
    for (int i = 0; i < l; i++) {
      if (words[lp].equals(target)) {
        ans = ans == -1 ? i : Math.min(ans, i);
        break;
      }
      lp = (lp - 1 + l) % l;
    }
    // right
    for (int i = 0; i < l; i++) {
      if (words[rp].equals(target)) {
        ans = ans == -1 ? i : Math.min(ans, i);
        break;
      }
      rp = (rp+1) % l;
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] words = {"hsdqinnoha","mqhskgeqzr","zemkwvqrww","zemkwvqrww","daljcrktje","fghofclnwp","djwdworyka","cxfpybanhd","fghofclnwp","fghofclnwp"};
    String target = "zemkwvqrww";
    int startIndex = 8;
    System.out.println(closestTarget(words, target, startIndex));
  }
}
