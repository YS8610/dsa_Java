public class lc852 {
  private static int peakIndexInMountainArray(int[] arr) {

    return  helper(arr, 0, arr.length-1);
  }

  private static int helper(int[] arr, int start, int end){
    if (start==end) return start;
    if (end-start==1){
      if (arr[start]>arr[(start-1)<0?0:(start-1)] && arr[start]>arr[(start+1)>arr.length-1?arr.length-1:(start+1)]) return start;
      return end;
    }
    int guess = start+(end - start)/2;

    if (arr[(guess-1)<0?0:(guess-1)]<arr[guess] && arr[(guess+1)>arr.length-1?arr.length-1:(guess+1)]>arr[guess]){
      
      return helper(arr, guess, end);
    }
    // if (arr[guess-1]>arr[guess] && arr[guess+1]<arr[guess])
    else {
      return helper(arr, start, guess);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,3,2,1};
    System.out.println( peakIndexInMountainArray(arr) );
  }

}
