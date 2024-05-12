import java.util.ArrayList;
import java.util.List;

public class lc412 {
  private static List<String> fizzBuzz(int n) {
    List<String> ans = new ArrayList<>(n);
    for (int i=0; i<n;i++){
      if ((i+1) % 3 == 0 && (i+1) % 5 == 0)
        ans.add("FizzBuzz");
      else if ((i+1) % 3 == 0)
        ans.add("Fizz");
      else if ((i+1) % 5 == 0)
        ans.add("Buzz");
      else
        ans.add(String.valueOf(i+1));
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 3;
    System.out.println(fizzBuzz(n).toString());
  }
}
