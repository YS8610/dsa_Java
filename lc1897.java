public class lc1897 {

  private static boolean makeEqual(String[] words) {
    int[] map = new int[26];
    int len = words.length;
    if (len == 1) return true;
    for (String i : words) {
      for (int j = 0, n = i.length(); j < n; j++) {
        map[(int) i.charAt(j) - 97]++;
      }
    }
    for (int i : map) {
      if (i != 0 && i % len != 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] words = {"abc","aabc","bc"};
    System.out.println(makeEqual(words));
  }
}
