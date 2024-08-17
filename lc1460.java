public class lc1460 {
  private static boolean canBeEqual(int[] target, int[] arr) {
    int[] map = new int[1001];
    for (int a:target) map[a]++;
    for (int a:arr) map[a]--;
    for (int a:map){
      if (a != 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[] target = {1,2,3,4}, arr = {2,4,1,3};
    System.out.println(canBeEqual(target, arr));
  }
}
