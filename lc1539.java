public class lc1539 {
  
  private static int findKthPositive(int[] arr, int k) {
    int n = arr.length;
    int last = arr[n-1];
    int missingNo = last - n;
    if (k>missingNo) return last + (k-missingNo);
    int lp=0;
    int counter=0;
    for (int i=1; i<=last;i++){
      while (i>arr[lp]) lp++;
      if (i!=arr[lp]) counter++;
      if (counter ==k) return i;
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] arr = {2,3,4,7,11};
    int k = 5;
    System.out.println( findKthPositive(arr, k) );
  }
}
