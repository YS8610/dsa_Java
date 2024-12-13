public class lc3365 {
  private static class Trie{
    Trie[] nodes;
    int num;
    boolean end;

    Trie(){
      nodes = new Trie[26];
      num=0;
      end = false;
    }
  }
  
  private static boolean isPossibleToRearrange(String s, String t, int k){
    Trie head = new Trie();
    Trie cp;
    for (int i=0,n=s.length(),d= n/k;i<n;i+=d){
      cp = head;
      for (int j=0;j<d;j++){
        if (cp.nodes[s.charAt(i+j) - 'a'] ==null)
          cp.nodes[s.charAt(i+j) - 'a'] = new Trie();
        cp = cp.nodes[s.charAt(i+j) - 'a'];
      }
      cp.end = true;
      cp.num++;
    }
    for (int i=0,n=s.length(),d= n/k;i<n;i+=d){
      cp = head;
      for (int j=0;j<d;j++){
        if (cp.nodes[t.charAt(i+j)-'a'] == null) return false;
        cp = cp.nodes[t.charAt(i+j) - 'a'];
      }
      if (cp.num == 0) return false;
      cp.num--;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "abcdee";
    String t = "cdeeab";
    int k = 3;
    System.out.println(isPossibleToRearrange(s, t, k));
  }
}
