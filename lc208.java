import java.util.HashMap;
import java.util.Map;

public class lc208 {
  TrieNode root;

  private class TrieNode{
    Map<Character,TrieNode> node;
    boolean endofWord;

    TrieNode(){
      this.node = new HashMap<>();
      this.endofWord = false;
    }
  }
  
  public lc208() {
    this.root = new TrieNode();
  }
  
  public void insert(String word) {
    char[] wordsArray = word.toCharArray();
    TrieNode cp = this.root;
    for(int i =0,n=wordsArray.length;i<n;i++){
      if (cp.node.containsKey(wordsArray[i])) cp = cp.node.get(wordsArray[i]);
      else {
        cp.node.put(wordsArray[i], new TrieNode());
        cp = cp.node.get(wordsArray[i]);
      }
    }
    cp.endofWord = true;
  }
  
  public boolean search(String word) {
    char[] wordsArray = word.toCharArray();
    TrieNode cp = this.root;
    for (char c : wordsArray){
      if (cp.node.containsKey(c)) cp = cp.node.get(c);
      else return false;
    }
    return cp.endofWord?true:false;
  }
  
  public boolean startsWith(String prefix) {
    char[] wordsArray = prefix.toCharArray();
    TrieNode cp = this.root;
    for (char c : wordsArray){
      if (cp.node.containsKey(c)) cp = cp.node.get(c);
      else return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String word = "haha";
    lc208 trie  = new lc208();
    trie.insert(word);
    trie.insert("ha");

    System.out.println(trie.search("ha"));
    System.out.println(trie.startsWith("hah"));
  }
}
