public class lc704 {
  private static int search(int[] nums, int target){
    int upperBound =nums.length-1;
    int lowerBound = 0;
    int searchSize = (upperBound-lowerBound)/2;

    while (searchSize>3){
        if (nums[lowerBound + searchSize] > target){
            upperBound -= searchSize;
        }
        else{
            lowerBound += searchSize;
        }
        searchSize = (upperBound-lowerBound)/2;
    }
    for (int i = lowerBound; i<=upperBound;i++){
        if(nums[i]==target) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    // int[] nums = {-1,0,3,5,9,12};
    int[] nums = new int[2000];
    int start = -1200;
    System.out.println( search(nums, start) );
  }
  
}
