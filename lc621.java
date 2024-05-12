import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc621 {
  private static int leastInterval(char[] tasks, int n) {
    int ans = 0;
    int len = tasks.length;
    int temp = -1;
    int tIdx = 0;
    int taskNo;
    taskNo = 0;
    if (n==0) return len;
    int[] map = new int['Z' - 'A' + 1];
    Deque<int[]> cooldownQ = new ArrayDeque<>();
    Set<Integer> cooldown = new HashSet<>();
    for (char t : tasks) map[t - 'A']++;
    for (int i = 0, l = 'Z' - 'A';i<=l;i++)
      if (map[i]>0) taskNo++;
    outer:
    while (len >= 1) {
    if (ans != 0 && ans == cooldownQ.peek()[1] + n + 1) 
      cooldown.remove(cooldownQ.pop()[0]);
    if (cooldownQ.size() == taskNo){
      ans++;
      // System.out.print("idle ");
      continue;
    }
    temp = -1;
    for (int i = 0, l = 'Z' - 'A';i<=l;i++){
      if (map[i] > 0 && !cooldown.contains(i) && map[i] >= temp){
        temp = map[i];
        tIdx = i;
      }
    }
    if (temp>-1){
      map[tIdx]--;
      cooldown.add(tIdx);
      cooldownQ.add(new int[]{tIdx,ans});
      // System.out.print((char)(tIdx+'A') + " ");
      ans++;
      len--;
      continue outer;
    }
    ans++;
    // System.out.print("idle ");
  }
    return ans;
  }

  public static void main(String[] args) {
    char[] tasks = {'A','A','A','B','B','B','C','C','C','C','D','D'};
    int n = 5;
    System.out.println(leastInterval(tasks, n));
  }
}