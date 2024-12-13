import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc752 {
  private static int encode(String code){
    int ans = 0;
    for (int i =0, n=code.length();i<n;i++)
      ans += ans*10 + (code.charAt(i)-'0');
    return ans;
  }

  private static String rotate(String code, int i, boolean plus){
    char[] tmp = new char[4];
    for (int j=0;j<4;j++) tmp[j] = code.charAt(j);
    int digit = (int)(tmp[i] -'0');
    if (plus){
      digit = (digit+1)%10;
      tmp[i] = (char)(digit+'0');
      return String.valueOf(tmp);
    }
    digit =digit==0? 9:digit-1;
    tmp[i] = (char)(digit+'0');
    return String.valueOf(tmp);
  }

  private static int openLock(String[] deadends, String target) {
    Set<String> visited = new HashSet<>();
    String starting = "0000";
    if (target.equals(starting)) return 0;
    for (String d : deadends) {
      visited.add(d);
      if (d.equals(starting)) return -1;
    }
    Queue<String> q = new LinkedList<>();
    q.add(starting);
    visited.add(starting);
    int ans = 0;
    String tmp;
    String rotated;
    while (!q.isEmpty()){
      for (int i =0, n=q.size();i<n;i++){
        tmp = q.poll();
        for (int j =0; j<4;j++){
          rotated = rotate(tmp, j, true);
          if (!visited.contains(rotated)){
            if (target.equals(rotated)) return ans+1;
            q.add(rotated);
            visited.add(rotated);
          }
          rotated = rotate(tmp, j, false);
          if (!visited.contains(rotated)){
            if (target.equals(rotated)) return ans+1;
            q.add(rotated);
            visited.add(rotated);
          }
        }
      }
      ans++;
    }
    return -1;
  }

  public static void main(String[] args) {
    String[] deadends = {"0000"};
    String target = "8888";
    System.out.println(openLock(deadends, target));
  }
}
