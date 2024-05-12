public class lc1732 {
  private static int largestAltitude(int[] gain) {
    int result = 0;
    int highest = 0;
    for (int a : gain){
      result += a;
      highest = result>highest?result:highest;
    }
    return highest;
  }

  public static void main(String[] args) {
    int[] gain = {-5,1,5,0,-7};
    System.out.println( largestAltitude(gain));
  }
}
