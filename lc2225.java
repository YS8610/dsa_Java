import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc2225 {
  private static List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> loser = new HashMap<>();
    Set<Integer> player = new HashSet<>();
    for (int[] match : matches) {
      for(int p : match) player.add(p);
      if (loser.containsKey(match[1]))
        loser.put(match[1], loser.get(match[1]) + 1);
      else
        loser.put(match[1], 1);
    }
    List<Integer> notLose = new ArrayList<>();
    List<Integer> lose = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    for (int key : loser.keySet())
      if (loser.get(key) == 1) lose.add(key);
    for (int p : player)
      if (!loser.containsKey(p)) notLose.add(p);

    notLose.sort((m1,m2)->m1.compareTo(m2));
    lose.sort((m1,m2)->m1.compareTo(m2));
    ans.add(notLose);
    ans.add(lose);
    return ans;
  }

  public static void main(String[] args) {
    int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
    System.out.println(findWinners(matches));
  }
}
