public class lc211 {

  private class TrieNode {

    TrieNode[] arr;
    boolean wordend = false;

    public TrieNode() {
      this.arr = new TrieNode[26];
      for (int i = 0; i < 26; i++) {
        arr[i] = null;
      }
    }
  }

  TrieNode root;

  public lc211() {
    root = new TrieNode();
  }

  private static boolean dfs(TrieNode root, String word, int i) {
    if (i >= word.length()) return root.wordend;
    if (root == null) return false;
    if (
      word.charAt(i) != '.' && root.arr[word.charAt(i) - 'a'] == null
    ) return false;
    if (word.charAt(i) != '.') {
      return dfs(root.arr[word.charAt(i) - 'a'], word, i + 1);
    } else {
      for (int j = 0; j < 26; j++) {
        if (root.arr[j] != null) {
          if (dfs(root.arr[j], word, i + 1)) return true;
        }
      }
      return false;
    }
  }

  public void addWord(String word) {
    TrieNode cp = root;
    for (int i = 0, n = word.length(); i < n; i++) {
      if (cp.arr[word.charAt(i) - 'a'] == null) {
        cp.arr[word.charAt(i) - 'a'] = new TrieNode();
        cp = cp.arr[word.charAt(i) - 'a'];
        continue;
      }
      cp = cp.arr[word.charAt(i) - 'a'];
    }
    cp.wordend = true;
  }

  public boolean search(String word) {
    return dfs(root, word, 0);
  }

  public static void main(String[] args) {
    lc211 wordDictionary = new lc211();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search("pad")); // return False
    System.out.println(wordDictionary.search("bad")); // return True
    System.out.println(wordDictionary.search(".ad")); // return True
    System.out.println(wordDictionary.search("b..")); // return True
  }
}
