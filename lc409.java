public class lc409 {
  private static int longestPalindrome(String s){
    int[] memo = new int[58];
    s.chars().forEach(x->{
      memo[x-65]++;
    });
    int evenCount = 0;
    int totalEven = 0;
    int oddCount = 0;
    int totalOdd = 0;
    for(int i=0;i<58;i++){
      if (memo[i]==0) continue;
      if (memo[i] %2 ==0 ){
        evenCount++;
        totalEven += memo[i];
      }
      else{
        oddCount++;
        totalOdd += memo[i];
      }
    }
    if (evenCount>0 && oddCount>0) return totalEven+totalOdd-oddCount+1;
    if (evenCount>0 && oddCount==0) return totalEven;
    if (evenCount==0 && oddCount>0) return totalOdd-oddCount+1;

    return 0;
  }
  public static void main(String[] args) {
    String s = "tattarrattat";
    System.out.println( longestPalindrome(s) );
  }
}
