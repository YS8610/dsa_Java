import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class lc274 {
  private static int hIndex(int[] citations) {
    Map<Integer,Integer> memo = new LinkedHashMap<>();
    Arrays.sort(citations);
    int n = citations.length;
    for (int i : citations){
      if ( memo.containsKey(i)) memo.put(i, memo.get(i)+1);
      else memo.put(i,1);
    }
    int prev=n;
    for (int i=0;i<=n;i++){
      int cumulative = prev - (memo.containsKey(i-1)?memo.get(i-1):0) ;
      if (cumulative<i) return i-1;
      prev=cumulative;

    }
    return n;

  }
  public static void main(String[] args) {
    int[] citations = {0,0,2,2,3,4,5};
    System.out.println( hIndex(citations) );
  }
}
