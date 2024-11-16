import java.util.Arrays;

public class lc2416 {

  private static class Trie {
    public int counter;
    public Trie[] nodes;

    public Trie() {
      this.counter = 0;
      this.nodes = new Trie[26];
    }
  }

  private static int[] sumPrefixScores(String[] words) {
    Trie head = new Trie();
    Trie cp;
    int[] ans = new int[words.length];
    for (String w : words) {
      cp = head;
      for (int i = 0, n = w.length(); i < n; i++) {
        if (cp.nodes[w.charAt(i) - 'a'] == null) {
          cp.nodes[w.charAt(i) - 'a'] = new Trie();
        }
        cp = cp.nodes[w.charAt(i) - 'a'];
        cp.counter++;
      }
    }
    for (int j = 0, m = words.length; j < m; j++) {
      cp = head;
      for (int i = 0, n = words[j].length(); i < n; i++) {
        cp = cp.nodes[words[j].charAt(i) - 'a'];
        ans[j] += cp.counter;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] words = {"abc","ab","bc","b"};
    System.out.println(Arrays.toString(sumPrefixScores(words)));
  }
}
