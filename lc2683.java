public class lc2683 {

  private static boolean doesValidArrayExist(int[] derived) {
    int tmp = 0;
    for (int n : derived) tmp ^= n;
    return tmp == 0;
  }

  public static void main(String[] args) {
    int[] derived = { 1, 1, 0 };
    System.out.println(doesValidArrayExist(derived));
  }
}
