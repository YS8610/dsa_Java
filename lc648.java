import java.util.List;

public class lc648 {
  private static class TrieNode {
    boolean endofWord;
    TrieNode[] next;

    public TrieNode(){
      this.next = new TrieNode[26];
      this.endofWord = false;
    }
  }
  
  private static String replaceWords(List<String> dictionary, String sentence) {
    TrieNode root = new TrieNode();
    TrieNode cp;
    for (String d:dictionary){
      cp = root;
      for (int i =0,n=d.length();i<n;i++){
        if (cp.next[d.charAt(i) - 'a'] == null){
          cp.next[d.charAt(i) - 'a'] = new TrieNode(); 
        }
        cp = cp.next[d.charAt(i) - 'a'];
      }
      cp.endofWord = true;
    }
    String[] a = sentence.split(" ");
    String[] ans = new String[a.length];
    for (int j=0, m=a.length; j<m;j++){
      cp = root;
      for (int i=0, n=a[j].length();i<n;i++){
        if (cp.endofWord){
          ans[j] = a[j].substring(0, i);
          break;
        }
        if (cp.next[a[j].charAt(i) - 'a'] == null){
          ans[j] = a[j];
          break;
        }
        cp = cp.next[a[j].charAt(i) - 'a'];
      }
      if (ans[j]==null) ans[j] = a[j];
    }
    return String.join(" ", ans);
  }

  public static void main(String[] args) {
    List<String> dictionary = List.of("cat","bat","rat");
    String sentence = "the cattle was rattled by the battery";
    System.out.println(replaceWords(dictionary, sentence));
  }
}
