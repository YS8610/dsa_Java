import java.util.Arrays;

public class lc455 {
  static private int findContentChildren(int[] g, int[] s) {
    int counter =0;
    Arrays.sort(s);
    Arrays.sort(g);
    for (int i=0,n=s.length;i<n;i++){
      for (int j=counter,m=g.length;j<m;){
        if (s[i] >= g[j]) {
          counter++;
          break;
        }
        else break;
      }
    }
    return counter;

  }

  public static void main(String[] args) {
    int[] g= {10,9,8,7}, s={5,6,7,8};
    System.out.println( findContentChildren(g, s) );
  }
}
