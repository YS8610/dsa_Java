import java.util.Arrays;

public class lc2410 {
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    Arrays.sort(players);
    Arrays.sort(trainers);
    int pl = players.length;
    int tp = trainers.length;
    int pp = 0;
    int pt = 0;
    int ans = 0;
    while (pp < pl && pt < tp) {
      if (players[pp] <= trainers[pt]) {
        pp++;
        pt++;
        ans++;
      } else
        pt++;
    }
    return ans;
  }
}
