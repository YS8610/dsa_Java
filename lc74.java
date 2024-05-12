import java.util.Arrays;

public class lc74 {
  private static boolean searchMatrix(int[][] matrix, int target){
    Boolean inRange = false;
    int rowtoSearch = 0;
    for(int i =0, iLen=matrix.length;i<iLen;i++ ){
      if ( target>= matrix[i][0] && target <= matrix[i][ matrix[i].length-1 ] ){
        rowtoSearch = i;
        inRange = true;
        break;
      }
    }
    if (!inRange) return false;

    int position = Arrays.binarySearch(matrix[rowtoSearch], target);
    return position>=0;
  }
  public static void main(String[] args) {
    // int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int[][] matrix = {{1},{3}};
    int target = 1;
    System.out.println( searchMatrix(matrix,target));
  }
}
