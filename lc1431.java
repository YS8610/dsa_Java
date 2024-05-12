import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc1431 {
  private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int top = Collections.max( Arrays.stream(candies).boxed().toList() );
    int n = candies.length;
    List<Boolean> ans = new ArrayList<>( n);
    for (int i=0;i<n;i++ ){
      ans.add(candies[i]+extraCandies>=top?true:false); 
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] candies = {4,2,1,1,2};
    int extraCandies = 1;
    System.out.println( kidsWithCandies(candies, extraCandies).toString() );
    
  }
}
