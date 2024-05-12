import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc735 {
  private static int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<Integer>();
    int top;
    for(int a : asteroids){
      if (stack.isEmpty()) stack.add(a);
      else{
        top = stack.peekLast();
        // incoming asteroids same sign
        if ( (top>0 && a>0) || (top<0 && a<0) ) stack.add(a);
        // incoming asteroid opposite sign
        else{
          // equal
          if (Math.abs(top)== Math.abs(a)) stack.pollLast();
          // top is bigger than incoming asteroid
          else if (Math.abs(top)> Math.abs(a)) continue;
          // abs(top) is smaller than incoming abs(asteroid)
          else{
            while ( Math.abs(top) <= Math.abs(a) ){
              if (Math.abs(top) == Math.abs(a) ){
                // pop top
                stack.pollLast();
                break;
              }
              else stack.pollLast();
              if (stack.isEmpty()) {
                stack.add(a);
                break;
              }
              top = stack.peekLast();
            }
          }
        }
      }
    }
    return stack.stream().mapToInt(x->Integer.valueOf(x)).toArray();
  }

  private static int[] asteroidCollision1(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<Integer>();
    int top;
    boolean isDestroyed;
    for(int a : asteroids){
      if (stack.isEmpty()) stack.add(a);
      else{
        top = stack.peekLast();
        // if top is -ve, all can be added
        if (top<0) stack.add(a);
        // top is +ve
        else {
          // +ve asteroid when top is +ve
          if (a>0){
            stack.add(a);
            continue;
          } 
          // -ve asteroid when top is +ve
          else{
            isDestroyed=false;
            while(top>0){
              // top bigger than incoming asteroid collision
              if (Math.abs(a)<Math.abs(top)) {
                isDestroyed = true;
                break;
              }
              // top = incoming asteroid collision
              if (Math.abs(a)==Math.abs(top)) {
                stack.pollLast();
                isDestroyed = true;
                break;
              }
              // top is smaller than incoming asteroid collision
              stack.pollLast();
              if (stack.isEmpty()) {
                isDestroyed=false;
                break;
              }
              else top=stack.peekLast();
            }
            if (!isDestroyed) stack.add(a);
          }
        }
      }
    }
    return stack.stream().mapToInt(x->Integer.valueOf(x)).toArray();
  }

  public static void main(String[] args) {
    int[] asteroids = {-2,-2,1,-2};
    System.out.println( Arrays.toString( asteroidCollision(asteroids) ) );
    System.out.println( Arrays.toString( asteroidCollision1(asteroids) ) );
  }
}
