import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc97 {

  static class Trie {

    Trie[] nodes;
    boolean end;

    Trie() {
      nodes = new Trie[26];
      end = false;
    }

    void add(String s) {
      Trie cp = this;
      for (int i = 0, n = s.length(); i < n; i++) {
        cp.nodes[s.charAt(i) - 'a'] = new Trie();
        cp = cp.nodes[s.charAt(i) - 'a'];
      }
      cp.end = true;
    }
  }

  private static boolean isinter(
    Trie t1,
    Trie t2,
    int i,
    String s3,
    Map<List<Trie>, Boolean> memo
  ) {
    if (i >= s3.length()) return true;
    if (memo.containsKey(List.of(t1, t2))) return memo.get(List.of(t1, t2));

    if (
      t1.nodes[s3.charAt(i) - 'a'] != null &&
      t2.nodes[s3.charAt(i) - 'a'] != null
    ) {
      boolean tmp =
        isinter(t1.nodes[s3.charAt(i) - 'a'], t2, i + 1, s3, memo) ||
        isinter(t1, t2.nodes[s3.charAt(i) - 'a'], i + 1, s3, memo);
      memo.put(List.of(t1, t2), tmp);
      return tmp;
    }
    if (t1.nodes[s3.charAt(i) - 'a'] != null) {
      boolean tmp = isinter(t1.nodes[s3.charAt(i) - 'a'], t2, i + 1, s3, memo);
      memo.put(List.of(t1, t2), tmp);
      return tmp;
    }
    if (t2.nodes[s3.charAt(i) - 'a'] != null) {
      boolean tmp = isinter(t1, t2.nodes[s3.charAt(i) - 'a'], i + 1, s3, memo);
      memo.put(List.of(t1, t2), tmp);
      return tmp;
    }
    memo.put(List.of(t1, t2), false);
    return false;
  }

  private static boolean isInterleave(String s1, String s2, String s3) {
    if ((s1 + s2).equals(s3) || (s2 + s1).equals(s3)) return true;
    if (s1.length() + s2.length() != s3.length()) return false;
    Trie t1 = new Trie();
    Trie t2 = new Trie();
    t1.add(s1);
    t2.add(s2);
    return isinter(t1, t2, 0, s3, new HashMap<>());
  }

  private static boolean isinter1(String s1, String s2, String s3, int l1, int l2, Map<List<Integer>,Boolean> memo){
    if (l1 + l2 >= s3.length()) return true;
    if (memo.containsKey(List.of(l1, l2))) return memo.get(List.of(l1, l2));
    boolean tmp = false;
    if ((l1<s1.length() && s1.charAt(l1) == s3.charAt(l1+l2)) && (l2 < s2.length() && s2.charAt(l2) == s3.charAt(l1+l2)))
      tmp = isinter1(s1, s2, s3, l1+1, l2, memo) || isinter1(s1, s2, s3, l1, l2+1, memo);
    else if (l1<s1.length() && s1.charAt(l1) == s3.charAt(l1+l2))
      tmp =isinter1(s1, s2, s3, l1+1, l2, memo);
    else if (l2 < s2.length() && s2.charAt(l2) == s3.charAt(l1+l2))
      tmp = isinter1(s1, s2, s3, l1, l2+1, memo);
    memo.put(List.of(l1,l2), tmp);
    return tmp;
  }

  private static boolean isInterleave1(String s1, String s2, String s3) {
    if ((s1 + s2).equals(s3) || (s2 + s1).equals(s3)) return true;
    if (s1.length() + s2.length() != s3.length()) return false;
    return isinter1(s1,s2,s3,0,0, new HashMap<>());
  }

  public static void main(String[] args) {

    String s1 = "abababababababababababababababababababababababababababababababababababababababababababababababababbb";
    String s2 = "babababababababababababababababababababababababababababababababababababababababababababababababaaaba";
    String s3 = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb";
    System.out.println(isInterleave(s1, s2, s3));
    System.out.println(isInterleave1(s1, s2, s3));
  }
}
