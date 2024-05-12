public class lc292 {
  static private boolean canWinNim(int n) {
    if (n!=0 && n%4==0) return false;
    return true;
  }
  public static void main(String[] args) {
    System.out.println( canWinNim(20) );
  }
}
