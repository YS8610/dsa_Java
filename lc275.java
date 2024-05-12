import java.util.Arrays;

public class lc275 {
  
  private static int hIndex(int[] citations){
    int n = citations.length;
    // remove all zeros
    int ind0 = Arrays.binarySearch(citations,0);
    if (ind0>=0){
      int last0Pos=0;
      while( ind0>=0){
        last0Pos = ind0;
        ind0 = Arrays.binarySearch(citations,Integer.valueOf(0),ind0+1,n);
      }
      citations = Arrays.copyOfRange(citations, last0Pos+1, n);
      n = citations.length;
    }
    if (n==0) return 0;
    if (n==1) return Math.min(citations[0], 1);
    if (n==2){
      if (citations[0]>=2) return 2;
      else if (citations[0]==1) return 1;
      else {
        if (citations[1]>=1) return 1;
        else return 0;
      }
    }
    int rp = citations.length;
    int lp = 0;
    int cp = lp+(rp-lp)/2;
    while ( rp-lp>0 ){
      if (citations[cp]<n-cp) lp = cp+1;
      else if (citations[cp]>n-cp) rp = cp-1;
      else return Math.min(citations[cp], n-cp);
      cp = lp+(rp-lp)/2;
    }
    if ( citations[lp]>=n-lp ) return n-lp;
    else return n-lp-1;
  }

  public static void main(String[] args) {
    int[] citations = {1,2,7,9};
    // int[] citations = {1,2,3,4,5,6};
    System.out.println( hIndex(citations) );
  }
}
