import java.util.ArrayList;
import java.util.List;

public class lc1291 {
  private static List<Integer> sequentialDigits(int low, int high) {
    List<Integer> ans = new ArrayList<>();
    int num = low;
    long temp = 0;
    int t;
    int i = 0;
    int start = 0;
    int[] a = new int[10];
    boolean can = true;
    
    while (num <=high){
      temp = num;
      i = -1;
      while (temp != 0){
        a[++i] = (int)temp %10;
        temp /=10;
      }
      t = a[i];
      for (int j = i; j>=0;j--){
        if (a[i] + (i-j+start)>9){
          can = false;
          break;
        }
      }
      if (!can){
        for (int j =1; j<=i+2; j++ ){
          temp = temp *10 + j;
        }
      }
      else{
        for (int j = i; j>=0;j--){
          temp = temp*10 + (t + (i-j+start));
        }
      }
      if (temp >= (long)low && temp <= (long)high) {
        ans.add((int)temp);
      }
      num = (int)temp;
      start = 1;
      can = true;
    }
    return ans;
  }

  public static void main(String[] args) {
    int low = 100, high = 300;
    System.out.println(sequentialDigits(low, high));
  }
}
