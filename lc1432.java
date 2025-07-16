public class lc1432 {
  static public int maxDiff(int num) {
    if (num < 10)
      return 8;
    int[] tmp = new int[9];
    int t = num;
    int pos = 0;
    while (t != 0) {
      tmp[pos++] = t % 10;
      t /= 10;
    }
    int bigpos = pos - 1;
    int smallpos = pos - 1;
    while (bigpos >= 0 && tmp[bigpos] == 9)
      bigpos--;
    if (tmp[smallpos] == 1)
      while (smallpos >=0 && tmp[smallpos] <= 1)
        smallpos--;
    int big = 0;
    int small = 0;
    for (int i=0, exp=1; i< pos && smallpos >=0;i++, exp*=10){
      if (tmp[i] == tmp[smallpos] && smallpos == pos-1){
        small = small + 1*exp;
        continue;
      }
      else if (tmp[i] == tmp[smallpos]){
        continue;
      }
      small = small + tmp[i] * exp;
    }
    if (smallpos==-1)
      small = num;
    if (bigpos == -1)
      return num - small;
    for (int i = 0, exp = 1; i < pos; i++, exp *= 10) {
      if (tmp[i] == tmp[bigpos]) {
        big = big + 9 * exp;
        continue;
      }
      big = big + tmp[i] * exp;
    }
    return big - small;
  }

  static public void main(String[] args){
    int num = 100;
    System.out.println(maxDiff(num));
  }
}
