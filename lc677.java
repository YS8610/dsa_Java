public class lc677 {
  private static class Trie{
    Trie[] nodes;
    boolean end;
    int val;

    Trie(){
      nodes = new Trie[26];
      end = false;
      val = 0;
    }
  }
  Trie root;
  
  public lc677() {
    root = new Trie();
  }
  
  public void insert(String key, int val) {
    Trie cp = root;
    for (int i =0, n=key.length();i<n;i++){
      if (cp.nodes[key.charAt(i)-'a'] == null){
        cp.nodes[key.charAt(i)-'a'] = new Trie();
      }
      cp = cp.nodes[key.charAt(i)-'a'];
    }
    cp.end = true;
    cp.val = val;
  }
  
  public int sum(String prefix) {
    Trie cp = root;
    for (int i =0, n=prefix.length();i<n;i++){
      if (cp.nodes[prefix.charAt(i) - 'a'] == null) return 0;
      cp = cp.nodes[prefix.charAt(i) - 'a'];
    }
    return dfs(cp);
  }

  private static int dfs(Trie root){
    int ans = root.val;
    for (int i=0;i<26;i++){
      if (root.nodes[i] != null){
        ans += dfs(root.nodes[i]);
      }
    }
    return ans;
  }
}
