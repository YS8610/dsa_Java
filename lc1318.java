public class lc1318 {
  private static int minFlips(int a, int b, int c) {
    int mask = 1;
    int[] b1 = new int[32];
    int[] b2 = new int[32];
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      b1[31 - i] += ((a & mask) != 0 ? 1 : 0) + ((b & mask) != 0 ? 1 : 0);
      b2[31 - i] = (c & mask) != 0 ? 1 : 0;
      mask <<= 1;
      if (mask > a && mask > b && mask > c) break;
    }
    for (int i = 0; i < 32; i++) {
      if (b1[i] == b2[i]) continue;
      if (b2[i] == 0) {
        ans += b1[i];
        continue;
      }
      if (b2[i] == 1 && b1[i] == 0) ans++;
    }
    return ans;
  }

  private static int minFlips1(int a, int b, int c) {
    int mask = 1;
    int b1 = 0;
    int b2 = 0;
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      b1 = 0;
      b2 = 0;
      b1 += ((a & mask) != 0 ? 1 : 0) + ((b & mask) != 0 ? 1 : 0);
      b2 = (c & mask) != 0 ? 1 : 0;
      mask <<= 1;
      if (b1 == b2) continue;
      if (b2 == 0) {
        ans += b1;
        continue;
      }
      if (b2 == 1 && b1 == 0) ans++;
      if (mask > a && mask > b && mask > c) break;
    }
    return ans;
  }

  public static void main(String[] args) {
    int a = 8, b = 3, c = 5;
    System.out.println(minFlips(a, b, c));
    System.out.println(minFlips1(a, b, c));
  }
}
