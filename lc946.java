import java.util.ArrayDeque;
import java.util.Deque;

public class lc946 {
  private static boolean validateStackSequences(int[] pushed, int[] popped) {
    int l = popped.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int pushi =0;
    int popi =0;
    while (pushi < l){
      stack.addLast(pushed[pushi]);
      while (!stack.isEmpty() && popi < l && popped[popi] == stack.peekLast()){
        stack.pollLast();
        popi++;
      }
      pushi++;
    }
    return pushi==popi;
  }

  public static void main(String[] args) {
    int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
    System.out.println(validateStackSequences(pushed, popped));
  }
}
