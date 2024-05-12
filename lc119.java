import java.util.ArrayList;
import java.util.List;

public class lc119 {
  private static List<Integer> getRow(int rowIndex){
    List<Integer> a = new ArrayList<>();
    if (rowIndex < 0) return a;
    
    if (rowIndex == 0 ){
      a.add(1);
      return a;
    }
    if (rowIndex == 1){
      a.add(1);
      a.add(1);
      return a;
    }
    List<Integer> rowup = getRow(rowIndex-1);
    for (int i =0;i<=rowIndex;i++){
      if( i == 0){
        a.add(1);
      }
      else if (i==rowIndex){
        a.add(1);
      }
      else{
        a.add( rowup.get(i-1) + rowup.get(i) );
      }
    }

    return a;
  }
  public static void main(String[] args) {
    System.out.println( getRow(4).toString());
  }
}
