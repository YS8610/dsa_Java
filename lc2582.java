public class lc2582 {
  private static int passThePillow(int n, int time) {
    if (time < n) return time+1;
    int start = (time - (n - 1)) / n;
    if ((start & 1) == 1 && start % n == 0) return (time - (n - 1))% n;
    return n - (time - (n - 1)) % n;
  }

  private static int passThePillow1(int n, int time) {
    int i = 1;
    out:
    while (time > 0){
      while (i < n){
        i++;
        time--;
        if (time == 0) break out;
      }
      while (i>1){
        i--;
        time--;
        if (time == 0) break out;
      }
    }
    return i;
  }

  public static void main(String[] args) {
    int n = 3, time = 3;
    System.out.println(passThePillow(n, time));
    System.out.println(passThePillow1(n, time));
  }
}
