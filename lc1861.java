import java.util.Arrays;

public class lc1861 {

  private static void move(char[][] box, int lp, int rp, int row){
    while (lp >=0){
      if (lp==rp && (box[row][rp] == '#' || box[row][rp] == '*')) {
        lp--;
        rp--;
        continue;
      }
      if (box[row][lp] == '#') {
        box[row][rp] = '#';
        box[row][lp] = '.';
        rp--;
      }
      else if (box[row][lp] == '*')
        rp = lp;
      else
        lp--;
    }
  }

  private static char[][] rotateTheBox(char[][] box) {
    int lr = box.length;
    int lc = box[0].length;
    char[][] ans = new char[lc][lr];
    int lp = lc-1;
    int rp = lc-1;
    for (int row=0;row <lr;row++)
      move(box, lp, rp, row);
    for (int r=0; r<lr;r++)
      for (int c=0;c<lc;c++)
        ans[c][lr-1-r] = box[r][c];
    return ans;
  }

  public static void main(String[] args) {
    char[][] box = {
      {'*','#','*','.','*','.'},
      {'#','#','#','*','.','.'},
      {'#','#','#','.','#','.'}
    };
    System.out.println(Arrays.deepToString(rotateTheBox(box)));
  }
}
