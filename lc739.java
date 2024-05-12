import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class lc739 {
  private static int[] dailyTemperatures(int[] temperatures){
    int n = temperatures.length;
    int[] ans = new int[n];
    Deque<List<Integer>> stack = new ArrayDeque<>();
    outloop:
    for (int i =n-1; i>=0;i--){
      // if stack is empty
      if (stack.isEmpty()){
        stack.push( List.of(temperatures[i],i) );
        ans[i] = 0;
      }
      else{
        // if stack is not empty
        List<Integer> top = stack.peek();
        while (temperatures[i] > top.get(0) ){
          top = stack.pop();
          if (stack.isEmpty()){
            stack.push( List.of(temperatures[i],i) );
            ans[i] = 0;
            continue outloop;
          }
          top = stack.peek();
        }
        stack.push( List.of(temperatures[i],i) );
        if (temperatures[i] < top.get(0)) {
          ans[i] = top.get(1) - i;
        }
        // both are equal
        else{
          ans[i] = ans[top.get(1)]==0? 0 : ans[top.get(1)]+ top.get(1)-i; 
        }
      }
    }
    return ans;
  }
  private static int[] dailyTemperatures1(int[] temperatures){
    int n = temperatures.length;
    int[] ans = new int[n];
    Deque<List<Integer>> stack = new ArrayDeque<>();
    outloop:
    for (int i =n-1; i>=0;i--){
      // if stack is empty
      if (stack.isEmpty()){
        stack.push( List.of(temperatures[i],i) );
        ans[i] = 0;
      }
      else{
        // if stack is not empty
        List<Integer> top = stack.peek();
        while (temperatures[i] >= top.get(0) ){
          top = stack.pop();
          if (stack.isEmpty()){
            stack.push( List.of(temperatures[i],i) );
            ans[i] = 0;
            continue outloop;
          }
          top = stack.peek();
        }
        stack.push( List.of(temperatures[i],i) );
        ans[i] = top.get(1) - i;
      }
    }
    return ans;
  }
  
  public static void main(String[] args) {
    // int[] temperatures = {34,80,80,34,34,80,80,80,80,34};
    int[] temperatures = {64,40,49,73,72,35,68,83,35,73,84,88,96,43,74,63,41,95,48,46,89,72,34,85,72,59,87,49,30,32,47,34,74,58,31,75,73,88,64,92,83,64,100,99,81,41,48,83,96,92,82,32,35,68,68,92,73,92,52,33,44,38,47,88,71,50,57,95,33,65,94,44,47,79,41,74,50,67,97,31,68,50,37,70,77,55,48,30,77,100,31,100,69,60,47,95,68,47,33,64};
    // int[] temperatures = {73,74,75,71,69,72,76,73};
    System.out.println( Arrays.toString( dailyTemperatures(temperatures) )  );
  }
}
