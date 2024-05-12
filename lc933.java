import java.util.LinkedList;
import java.util.Queue;

public class lc933 {
  int req;
  public lc933() {
    this.req = 0;
  }
  
  public int ping(int t) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(t);
    int counter=0;
    while(!q.isEmpty()){
      int result = q.poll();
      if ( result!=0 && result<=t-3000 ) counter++;
    }
    return counter;
      
  }

  public static void main(String[] args) {
    
  }
}
