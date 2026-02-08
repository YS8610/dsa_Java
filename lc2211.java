public class lc2211 {
  public int countCollisions(String directions) {
    int l = directions.length();
    int lp = 0;
    int rp = l - 1;
    int ans = l;
    while (lp < l && directions.charAt(lp) == 'L') {
      ans--;
      lp++;
    }
    while (rp >= 0 && directions.charAt(rp) == 'R') {
      ans--;
      rp--;
    }
    int present = 0;
    for (int i = lp; i <= rp; i++) {
      if (directions.charAt(i) == 'L')
        present |= 1;
      if (directions.charAt(i) == 'S') {
        present |= 2;
        ans--;
      }
      if (directions.charAt(i) == 'R')
        present |= 4;
    }
    if (present == 1 || present == 2 || present == 4)
      return 0;
    return ans;
  }
}
