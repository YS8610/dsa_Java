public class lc1189 {
  private static int maxNumberOfBalloons(String text){
    int n = text.length();
    if (n<7) return 0;
    int[] memo = new int[5];
    // b=0,a=1,l=2,o=3,n=4
    for (int i=0;i<n;i++){
      if (text.charAt(i) == 'b') memo[0]++;
      else if (text.charAt(i) == 'a') memo[1]++;
      else if (text.charAt(i) == 'l') memo[2]++;
      else if (text.charAt(i) == 'o') memo[3]++;
      else if (text.charAt(i) == 'n') memo[4]++;
    }
    int minBAN = Math.min(Math.min(memo[0],memo[1]), memo[4]);
    int minLO = Math.min(memo[2]/2,memo[3]/2);
    return Math.min(minBAN,minLO);
  }

  public static void main(String[] args) {
    String text = "nlaebolko";
    System.out.println( maxNumberOfBalloons(text));
  }
}
