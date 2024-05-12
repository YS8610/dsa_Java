import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class lc575 {
  static private int distributeCandies(int[] candyType) {
    int len = candyType.length;
    int candytoeat = len/2;
    List<Integer> a = Arrays.stream(candyType)
                            .boxed()
                            .collect(Collectors.toCollection(ArrayList::new));
    int min = Collections.min(a);
    int counter = 0;
    while ( candytoeat > 0 ){
      candytoeat = candytoeat - min;
      counter++;
      a.remove( a.indexOf(min));
      min = Collections.min(a);
    }

    return counter;
  }
  public static void main(String[] args) {
    int[] candyType = {1000,1000,2,1,2,5,3,1};
    System.out.println(distributeCandies(candyType));
  }
}
