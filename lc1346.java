import java.util.HashSet;
import java.util.Set;

public class lc1346 {
  private static boolean checkIfExist(int[] arr){
    int zeroCount = 0;
    Set<Integer> set = new HashSet<>();
    for (int a:arr){
      if (a==0) zeroCount++;
      set.add(a);
    }
    if (zeroCount>=2) return true;
    for(int a:arr){
      if (a==0) continue;
      if ( set.contains(a*2) ) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {3,1,7,11};
    System.out.println( checkIfExist(arr) );
  }
}
