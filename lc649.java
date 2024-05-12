import java.util.LinkedList;
import java.util.Queue;

public class lc649 {
  private static String predictPartyVictory(String senate) {
    Queue<Character> voted = new LinkedList<>();
    Queue<Character> notVoted = new LinkedList<>();
    Queue<Character> q = new LinkedList<>();
    int n = senate.length();
    int r = 0;
    int d = 0;
    int rr = 0;
    int dr = 0;
    char top;
    for (int i =0;i<n;i++){
      if (senate.charAt(i)== 'R') r++;
      else d++;
      q.add(senate.charAt(i));
    }

    while (!(r==0 || d==0)){
      if (q.isEmpty()){
        while (!notVoted.isEmpty()){
          if (voted.peek() != notVoted.peek()){
            top = voted.remove();
            if (top == 'R') r--;
            else d--;
            voted.add(notVoted.remove());
            continue;
          }
          top = notVoted.remove();
          if (top == 'D') rr++;
          else dr++;
          voted.add(top);
        }
        while(!voted.isEmpty()){
          top = voted.remove();
          if (top == 'R' && rr > 0) {
            r--;
            rr--;
          }
          else if (top == 'D' && dr > 0){
            d--;
            dr--;
          }
          else q.add(top);
        }
      }
      top = q.remove();
      if (notVoted.isEmpty()) {
        notVoted.add(top);
        continue;
      }
      if (notVoted.peek() == top){
        notVoted.add(top);
        continue;
      }
      if (notVoted.peek() != top){
        if (top == 'R') r--;
        else d--;
        voted.add(notVoted.remove());
        continue;
      }
    }
    if (r==0) return "Dire";
    return "Radiant";
  }

  public static void main(String[] args) {
    String senate = "DRRDRDRDRDDRDRDRD";
    System.out.println(predictPartyVictory(senate));
  }
}
