import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class lc30 {
  static class Trie{
    Trie[] nodes;
    String s;
    boolean end;

    Trie(){
      nodes = new Trie[26];
      s="";
      end = false;
    }

    void add(String str){
      Trie cp = this;
      for (int i=0, n=str.length();i<n;i++){
        if (cp.nodes[str.charAt(i)-'a']==null)
          cp.nodes[str.charAt(i)-'a'] = new Trie();
        cp = cp.nodes[str.charAt(i)-'a'];
      }
      cp.end = true;
      cp.s = str;
    }
  }

  private static List<Integer> findSubstring(String s, String[] words) {
    Trie root = new Trie();
    Map<String, Integer> map = new HashMap<>();
    for (String w:words) {
      root.add(w);
      map.computeIfPresent(w, (k,v) -> v+1);
      map.computeIfAbsent(w, k -> 1);
    }
    Map<String,Integer> mapT = new HashMap<>();
    int l = s.length();
    int i =0;
    int j =0;
    List<Integer> ans = new ArrayList<>();
    boolean add = true;
    while (i <l){
      Trie cp = root;
      if (cp.nodes[s.charAt(i) - 'a'] == null){
        i++;
        continue;
      }
      for (Entry<String, Integer> entry : map.entrySet())
        mapT.put(entry.getKey(), entry.getValue());
      j = 0;
      while (i+j < l){
        if (cp.nodes[s.charAt(i+j) - 'a'] == null) break;
        cp = cp.nodes[s.charAt(i+j) - 'a'];
        if (cp.end){
          if (mapT.get(cp.s) == 0) {
            j -= cp.s.length();
            break;
          }
          mapT.put(cp.s, mapT.get(cp.s)-1);
          cp = root;
        }
        j++;
      }

      add = true;
      for (Entry<String,Integer> entry:mapT.entrySet()){
        if (entry.getValue() > 0){
          add = false;
          break;
        }
      }
      if (add) ans.add(i);
      if (j==0) i++;
      else i +=j;
    }
    return ans;
  }

  private static List<Integer> findSubstring1(String s, String[] words) {
    Trie root = new Trie();
    Map<String, Integer> map = new HashMap<>();
    for (String w:words) {
      root.add(w);
      map.computeIfPresent(w, (k,v) -> v+1);
      map.computeIfAbsent(w, k -> 1);
    }
    Map<String,Integer> mapT = new HashMap<>();
    int l = s.length();
    List<Integer> ans = new ArrayList<>();
    boolean add = true;
    int i =-1;
    int j =0;
    int maxl = words.length * words[0].length();
    while (++i <l && l-i >= maxl){
      Trie cp = root;
      if (cp.nodes[s.charAt(i) - 'a'] == null) continue;
      for (Entry<String, Integer> entry : map.entrySet())
        mapT.put(entry.getKey(), entry.getValue());
      j = 0;
      while (i+j < l){
        if (cp.nodes[s.charAt(i+j) - 'a'] == null) break;
        cp = cp.nodes[s.charAt(i+j) - 'a'];
        if (cp.end){
          if (mapT.get(cp.s) == 0) break;
          mapT.put(cp.s, mapT.get(cp.s)-1);
          cp = root;
        }
        j++;
      }
      add = true;
      for (Entry<String,Integer> entry:mapT.entrySet()){
        if (entry.getValue() > 0){
          add = false;
          break;
        }
      }
      if (add) ans.add(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "barfoofoobarthefoobarman";
    String[] words = {"foo","bar", "the"};
    System.out.println(findSubstring(s, words));
    System.out.println(findSubstring1(s, words));
  }
}