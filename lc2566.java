public class lc2566 {
  static public int minMaxDifference(int num) {
    int[] tmp = new int[9];
    int t = num;
    int pos = 0;
    while (t != 0) {
      tmp[pos++] = t % 10;
      t /= 10;
    }
    int bigpos = pos - 1;
    while (bigpos >= 0 && tmp[bigpos] == 9)
      bigpos--;
    int big = 0;
    int small = 0;
    for (int i = 0, exp = 1; i < pos-1; i++, exp*=10) {
      if (tmp[i] == tmp[pos - 1])
        continue;
      small = small + tmp[i]*exp;
      
    }
    if (bigpos == -1)
      return num - small;
    for (int i = 0, exp=1; i < pos; i++, exp*=10) {
      if (tmp[i] == tmp[bigpos]) {
        big = big + 9*exp;
        continue;
      }
      big = big + tmp[i]*exp;
    }
    return big - small;
  }

  public static void main(String[] args) {
    int num = 11891;
    System.out.println(minMaxDifference(num));
  }
}
