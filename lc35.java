public class lc35 {
  private static int searchInsert(int[] nums, int target) {
    int len = nums.length;
    int searchSize = len;
    int lowerRange=0;
    int upperRange=len-1;
    int posL;
    int posH;
    
    while (searchSize >3){
    searchSize = (upperRange - lowerRange) /2;
        if ( nums[lowerRange+searchSize]> target ){
            upperRange = lowerRange+searchSize;
        }
        else{
            lowerRange += searchSize; 
        }
    }
    for (int i=lowerRange;i<upperRange+1;i++){
        if (nums[i]==target) return i;
        else {
            if (nums[len-1]<target) return len;
            if (nums[0]>target) return 0;
            posL = i-1 <0 ? 0:i-1;
            posH = i+1>=len-1 ? len-1: i+1;
            if( nums[posL]<target && nums[posH]>target) return i+1;
        }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,5,6};
    int target = 7;

    System.out.println( searchInsert(nums, target) );
  }
}
