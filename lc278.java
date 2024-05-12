public class lc278 {
  
  private static Boolean isBadVersion(int version,int[] test){
    return test[version]==0?true:false;
  } 

  public static void main(String[] args) {
    int[] test = {1,1,1,1,1,0,0,0};
    
    int lowerBound = 0;
    int upperBound = test.length-1;
    int searchSize = (upperBound-lowerBound)/2;

    while (searchSize >3){
      if ( isBadVersion(lowerBound+searchSize,test) ){
        upperBound -= searchSize;
      }
      else{
        lowerBound += searchSize;
      }
      searchSize = (upperBound-lowerBound)/2;
    }
    System.out.println("upp"+upperBound);
    System.out.println("lowl"+lowerBound);
    for (int i =lowerBound; i<=upperBound;i++){
      if( isBadVersion(i,test) ) System.out.println("badver " +i);
    }
  }
}
