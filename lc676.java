public class lc676 {
  private static class Trie{
    Trie[] nodes;
    boolean end;

    Trie(){
      nodes = new Trie[26];
      end = false;
    }
  }

  Trie root;

  public lc676() {
    this.root = new Trie();
  }
  
  public void buildDict(String[] dictionary) {
    for (String d:dictionary){
      Trie cp = root;
      for (int i =0, n=d.length();i<n;i++){
        if (cp.nodes[d.charAt(i)-'a'] ==null)
          cp.nodes[d.charAt(i)-'a'] = new Trie();
        cp = cp.nodes[d.charAt(i)-'a'];
      }
      cp.end = true;
    }
  }
  
  public boolean search(String searchWord) {
    Trie cp = root;
    return dfs(cp, searchWord, 0, false);
  }

  private static boolean dfs(Trie root, String w, int i, boolean used){
    if (i >= w.length()){
      if (!root.end || !used) return false;
      return true;
    }
    if (root.nodes[w.charAt(i) - 'a'] == null && used)
      return false;
    if (root.nodes[w.charAt(i)-'a'] != null){
      boolean ans = dfs(root.nodes[w.charAt(i)-'a'], w, i+1, used);
      for (int j =0;j<26 && !used;j++){
        if (j == w.charAt(i)-'a' || root.nodes[j]==null) continue;
        ans = ans || dfs(root.nodes[j], w, i+1, true);
      }
      return ans;
    }
    if (used) return false;
    boolean allnull=true;
    boolean ans=false;
    for (Trie t:root.nodes){
      if (t == null) continue;
      allnull = false;
      ans = ans || dfs(t, w, i+1, true);
    }
    return !allnull && ans;
  }

  public static void main(String[] args) {
    lc676 magicDictionary = new lc676();
    magicDictionary.buildDict(new String[]{"a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"});
    System.out.println(magicDictionary.search("ba")); // We can change the second 'h' to 'e' to match "hello" so we return True
    System.out.println(magicDictionary.search("ab")); // return False
    System.out.println(magicDictionary.search("abc")); // return False
    System.out.println(magicDictionary.search("cba")); // return False
  }
}
