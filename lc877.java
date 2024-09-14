import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc877 {

  private static boolean dfs(
    int[] p,
    boolean turn,
    int alice,
    int bob,
    int lp,
    int rp,
    Map<List<Integer>, Boolean> memo
  ) {
    if (lp >= rp) return alice > bob ? true : false;
    if (memo.containsKey(List.of(turn ? 1 : 0, lp, rp))) return memo.get(
      List.of(turn ? 1 : 0, lp, rp)
    );
    boolean left = dfs(
      p,
      !turn,
      turn ? alice + p[lp] : alice,
      turn ? bob : bob + p[lp],
      lp + 1,
      rp,
      memo
    );
    boolean right = dfs(
      p,
      !turn,
      turn ? alice + p[rp] : alice,
      turn ? bob : bob + p[rp],
      lp,
      rp - 1,
      memo
    );
    memo.put(List.of(turn ? 1 : 0, lp, rp), left || right ? true : false);
    if (left || right) return true;
    return false;
  }

  private static boolean stoneGame(int[] piles) {
    return dfs(piles, true, 0, 0, 0, piles.length - 1, new HashMap<>());
  }

  public static void main(String[] args) {
    int[] piles = {5,3,4,5};
    System.out.println(stoneGame(piles));
  }
}
