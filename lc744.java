import java.util.Arrays;

public class lc744 {
  private static char nextGreatestLetter(char[] letters, char target){
    int n = letters.length;
    int[] memo = new int[n];
    int targetInt = Character.getNumericValue(target);
    for (int i=0;i<n;i++ ) memo[i] = Character.getNumericValue(letters[i]);
    int index = Arrays.binarySearch(memo,targetInt);
    if( index>=0){
      while( index<n && memo[index]==targetInt ){
        index++;
      }
      index--;
    }
    return letters[ Math.abs(index+1)>=n?0:Math.abs(index+1) ];
  }
  public static void main(String[] args) {
    // char[] letters = {'e','e','f','f','g','g'};
    char[] letters = {'c','f','j'};
    char target = 'c';
    System.out.println( nextGreatestLetter(letters, target) );
  }
}
