import java.util.Arrays;

public class lc1491 {
  private static double average(int[] salary){
    Arrays.sort(salary);
    int sum = 0;
    for (int i=1,n=salary.length-1;i<n;i++) sum += salary[i];
    return (double) sum / (salary.length-2);
  }


  public static void main(String[] args) {
    int[] salary = {4000,3000,1000,2000};
    System.out.println( average(salary));
  }
}
