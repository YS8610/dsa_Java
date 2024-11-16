public class lc2707 {
  private static class Trie{
    Trie node[];
    boolean end;

    Trie(){
      end = false;
      node = new Trie[26];
    }
  }
  
  
  private static int minExtraChar(String s, String[] dictionary) {
    Trie head = new Trie();
    Trie cp = head;
    for (String d :dictionary){
      cp = head;
      for (int i=0, n=d.length();i<n;i++){
        if (cp.node[d.charAt(i) - 'a'] == null) cp.node[d.charAt(i) - 'a'] = new Trie();
        cp = cp.node[d.charAt(i) - 'a'];
      }
      cp.end = true;
    }
    int charno;
    

    return 0;
  }

  public static void main(String[] args) {
    String s = "leetscode";
    String[] dictionary = {"leet","code","leetcode"};
    System.out.println(minExtraChar(s, dictionary));
  }
}
