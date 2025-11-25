import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc127 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Integer> index = new HashMap<>();
    int l = wordList.size();
    boolean[] visited = new boolean[l + 1];
    Map<Integer, List<Integer>> adj = new HashMap<>();
    adj.put(l, new ArrayList<>());
    for (int i = 0; i < l; i++) {
      index.put(wordList.get(i), i);
      adj.put(i, new ArrayList<>());
      if (adjacent(wordList.get(i), beginWord))
        adj.get(l).add(i);
    }
    if (!index.containsKey(endWord))
      return 0;
    for (int i = 0, n = l - 1; i < n; i++) {
      for (int j = i + 1; j < l; j++) {
        if (!adjacent(wordList.get(i), wordList.get(j)))
          continue;
        adj.get(i).add(j);
        adj.get(j).add(i);
      }
    }
    Deque<int[]> q = new ArrayDeque<>();
    q.add(new int[] { l, 1 });
    int[] top;
    int match = index.get(endWord);
    while (!q.isEmpty()) {
      top = q.poll();
      if (top[0] == match)
        return top[1];
      if (visited[top[0]])
        continue;
      visited[top[0]] = true;
      for (int i : adj.get(top[0]))
        q.add(new int[] { i, top[1] + 1 });
    }
    return 0;
  }

  public boolean adjacent(String s1, String s2) {
    int l = s1.length();
    int count = 0;
    for (int i = 0; i < l; i++)
      count += s1.charAt(i) == s2.charAt(i) ? 0 : 1;
    return count == 1;
  }
}
