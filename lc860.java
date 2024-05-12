import java.util.Arrays;

public class lc860 {

  public static void main(String[] args) {
    int[] bills = {5,5,10,10,20};
    int[] billRec = {0,0,0};

    for (int i : bills){
      switch (i) {
        case 5:
          billRec[0] ++;
          break;
        case 10:
          billRec[1]++;
          billRec[0]--;
          if (billRec[0] <0) System.out.println(false);
          break;
          case 20:
          billRec[2]++;
          if (billRec[1] >0 && billRec[0]>0){
            billRec[1]--;
            billRec[0]--;
          }
          else if (billRec[0]>=3){
            billRec[0] -= 3;
          }
          else{
            System.out.println(false);
          }
          break;
      }
      System.out.println( Arrays.toString(billRec));
    }
    System.out.println(true);

  }
}
