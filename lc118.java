import java.util.ArrayList;
import java.util.List;

public class lc118 {
  static private List<List<Integer>> generate(int numRows){
    List<List<Integer>> a = new ArrayList<>();
    List<Integer> row = new ArrayList<>( );
    
    if(numRows==1){
      row.add(1);
      a.add(row);
      return a;
    }
    a = generate(numRows-1);
    if (numRows==2){
      row.add(1);
      row.add(1);
      a.add(row);
      return a;
    }
    
    for (int i=0; i<numRows;i++){
      if (i==0 ){
        row.add(1);
      }
      else if (i==numRows-1){
        row.add(1);
      }
      else{
        List<Integer> rowUp = a.get(numRows-1-1);
        row.add( rowUp.get(i-1) + rowUp.get(i) );
      }
    }
    a.add(row);
    return a;
  }
  
  public static void main(String[] args) {
    
    System.out.println( generate(5).toString());
  }
}
