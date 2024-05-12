public class lc771 {

  public static void main(String[] args) {
    String jewels = "aA", stones = "aAAbbbb";
    int count = 0;
    String[] stonesArray = stones.split("");

    for (int i =0, n=jewels.length(); i<n; i++){
      for ( String j : stonesArray){
        if ( j.equals( String.valueOf(jewels.charAt(i)) ) ) count++;
      }
    }
    System.out.println(count);
  }
}
