import java.util.Arrays;

public class lc167 {
  private static int[] twoSum(int[] numbers, int target) {

    for (int i=0, n=numbers.length;i<n;i++){
      for (int j=i+1;j<n;j++){
        int result = numbers[i] + numbers[j] ;
        if (result == target) return new int[]{i+1,j+1};
        if (result> target) break;
      }
    }

    return null;
  }
  public static void main(String[] args) {
    int[] numbers = {2,3,4};
    int target = 6;

    System.out.println( Arrays.toString( twoSum(numbers, target) )) ;
  }
}
