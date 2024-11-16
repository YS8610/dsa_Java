public class lc1497 {
  private static boolean canArrange(int[] arr, int k) {
    if (k==1) return true;
    int[] map = new int[k];
    for (int a :arr) map[(a%k+k)%k]++;
    if ((map[0]&1) == 1) return false;
    for (int i=1, n=k/2; i<n;i++){
      if (map[i] - map[k-i] != 0) return false;
    }
    if (k==3){
      if (map[1] - map[2] != 0) return false;
    }
    if ((k&1) == 0){
      if (map[k/2] % 2 == 1) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[] arr = {1,-1,-1,-1,2,2,-2,-2,5};
    int k = 1;
    System.out.println(canArrange(arr, k));
  }
}
