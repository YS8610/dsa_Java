import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lc187 {
  private static class Trie {
    boolean end;
    int n;
    Trie[] node;

    Trie() {
      end = false;
      n = 0;
      node = new Trie[4];
    }
  }

  public List<String> findRepeatedDnaSequences(String s) {
    List<String> ans = new ArrayList<>();
    int[] map = new int[128];
    map['A'] = 0;
    map['C'] = 1;
    map['G'] = 2;
    map['T'] = 3;
    Trie head = new Trie();
    int l = s.length();
    if (l <= 10)
      return ans;
    Trie cp = head;
    for (int i = 0, n = l - 9; i < n; i++) {
      cp = head;
      for (int j = 0; j < 10; j++) {
        if (cp.node[map[s.charAt(i + j)]] == null)
          cp.node[map[s.charAt(i + j)]] = new Trie();
        cp = cp.node[map[s.charAt(i + j)]];
      }
      cp.end = true;
      cp.n++;
      if (cp.n == 2)
        ans.add(s.substring(i, i + 10));
    }
    return ans;
  }

  public List<String> findRepeatedDnaSequences1(String s) {
    int l = s.length();
    if (l <= 10)
      return new ArrayList<>();
    Map<List<Character>, Integer> map = new HashMap<>();
    LinkedList<Character> tmp = new LinkedList<>();
    for (int i = 0; i < 10; i++)
      tmp.add(s.charAt(i));
    map.put(new LinkedList<>(tmp), 1);

    for (int i = 1, n = l - 10; i <= n; i++) {
      tmp.pollFirst();
      tmp.add(s.charAt(i + 9));
      map.computeIfPresent(new LinkedList<>(tmp), (k, v) -> v + 1);
      map.computeIfAbsent(new LinkedList<>(tmp), (k) -> 1);
    }
    List<String> ans = new ArrayList<>();
    for (Map.Entry<List<Character>, Integer> entry : map.entrySet()) {
      if (entry.getValue() >= 2)
        ans.add(tostring(entry.getKey()));

    }
    return ans;
  }

  static private String tostring(List<Character> tmp) {
    StringBuilder s = new StringBuilder();
    for (char t : tmp)
      s.append(t);
    return s.toString();
  }
}
