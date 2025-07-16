import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc838 {
  static public String pushDominoes(String dominoes) {
    int l = dominoes.length();
    char[] copy = new char[l];
    for (int i = 0; i < l; i++)
      copy[i] = dominoes.charAt(i);
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < l; i++) {
      if (copy[i] == 'L' || copy[i] == 'R')
        q.add(i);
    }
    Set<Integer> set = new HashSet<>();
    int tmp;
    while (!q.isEmpty()){
      set.clear();
      for (int i =0, n=q.size();i<n;i++){
        tmp = q.pollFirst();
        if (copy[tmp] == 'L'){
          if (tmp <= 0)
            continue;
          if (copy[tmp-1] == '.')
            copy[tmp-1] = 'L';
          else if (copy[tmp-1] == 'R' && set.contains(tmp-1))
            copy[tmp-1] = '.';
          else if (copy[tmp-1] == 'R' || copy[tmp-1] == 'L')
            continue;
          set.add(tmp-1);
          q.add(tmp-1);
        }
        else if (copy[tmp] == 'R'){
          if (tmp >= l-1)
            continue;
          if (copy[tmp+1] == '.')
            copy[tmp+1] = 'R';
          else if (copy[tmp+1] == 'L' && set.contains(tmp+1))
            copy[tmp+1] = '.';
          else if (copy[tmp+1] == 'L' || copy[tmp+1] == 'R')
            continue;
          set.add(tmp+1);
          q.add(tmp+1);
        }
      }
    }
    return new String(copy);
  }

  public static void main(String[] av){
    String dominoes = "RR.L";
    System.out.println(pushDominoes(dominoes));
  }
}
