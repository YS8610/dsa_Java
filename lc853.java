import java.util.Arrays;
import java.util.Stack;

public class lc853 {
  private static int carFleet(int target, int[] position, int[] speed) {
    int l = speed.length;
    int[][] car = new int[l][2];
    for (int i=0;i<l;i++){
      car[i][0] = position[i];
      car[i][1] = speed[i];
    }
    Arrays.sort(car, (m1,m2)->{
      if (m2[0]==m1[0]) return Integer.compare(m2[1], m1[1]);
      return Integer.compare(m2[0], m1[0]);
    } );
    Stack<int[]> s = new Stack<>();
    double t;
    double t1;
    for (int[] c:car){
      if (s.isEmpty()) {
        s.add(c);
        continue;
      }
      t = (target - s.peek()[0])/ (double)s.peek()[1];
      t1 = (target - c[0])/ (double)c[1];
      if (t >= t1) continue;
      s.add(c);
    }
    return s.size();
    }

    public static void main(String[] args) {
      int target = 12; 
      int[] position = {10,8,0,5,3}, speed = {2,4,1,1,3};
      System.out.println(carFleet(target, position, speed));
    }
}
