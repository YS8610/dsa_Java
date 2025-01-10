import java.util.Arrays;
class lc2545{
  private static int[][] sortTheStudents(int[][] score, int k) {
    Arrays.sort(score, (m1,m2) -> Integer.compare(m2[k],m1[k]));
    return score;
  }

  public static void main(String[] args){
    int[][] score = {
      {10,6,9,1},
      {7,5,11,2},
      {4,8,3,15}
    };
    int k = 2;
    System.out.println(Arrays.deepToString(sortTheStudents(score, k)));
  }
}
