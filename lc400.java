public class lc400 {
  private static int findNthDigit(int n){
    int len = 0;
    int counter=0;
    while( len<n ){
      counter++;
      len += String.valueOf(counter).length();
    }
    int diff = len - n;
    System.out.println("counter= " + counter);
    String last2Counters = String.valueOf(counter-1) + String.valueOf(counter);
    String ans = last2Counters.substring( last2Counters.length()-1-diff , last2Counters.length()-diff);

    return Integer.parseInt(ans);
  }

  public static int findNthDigit1(int n) {
    int counter =1;
    int sum = 0;
    if(n<10) return n;
    while (sum<n){
      sum += Math.log10(counter)+1;
      if (sum<n) counter ++;
    }
    int posNeeded = sum - n+1;
    return (counter% (int) Math.pow(10,posNeeded)) / ((int)Math.pow(10, posNeeded-1))  ;
  }



  public static void main(String[] args) {
    int n = 20;
    System.out.println(findNthDigit1(n));
  }
}
// 1234567891011