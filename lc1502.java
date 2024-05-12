import java.util.Arrays;

public class lc1502 {
  
  private static boolean canMakeArithmeticProgression(int[] arr) {
    int n = arr.length;
    if (n==2) return true;
    Arrays.sort(arr);
    int diff = arr[1]-arr[0];
    for(int i =2;i<n;i++){
      int remainder = arr[i]-arr[i-1];
      if (diff!=remainder) return false; 
    }
    return true;
  }

  public static void main(String[] args) {
    int[] arr = {3,5,1};
    System.out.println( canMakeArithmeticProgression(arr) );
  }
}
