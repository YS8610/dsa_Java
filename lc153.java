import java.util.Arrays;

public class lc153 {
  
  private static int findMin(int[] nums) {
    int n = nums.length;
    int[] heap = new int[n];
    heap[0] = nums[0];
    for (int i=1;i<n;i++){
      heap[i] = nums[i];
      int j = i;
      if (i%2!=0){
        while(heap[(i-1)/2] > heap[i]){
          swap(heap,(i-1)/2,i);
          i = (i-1)/2;
          if (i==0) break;
        }
        i=j;
      }
      else{
        while( heap[(i-2)/2] > heap[i]){
          swap(heap,(i-2)/2,i);
          i = (i-2)/2;
          if (i==0) break;
        }
        i=j;
      }
    }
    System.out.println(  Arrays.toString(heap));
    return heap[0];
  }
  private static void swap(int[] nums, int p1, int p2){
    if (p1==p2) return;
    int temp = nums[p1];
    nums[p1]=nums[p2];
    nums[p2] = temp;
  }
// heapify
  public static void main(String[] args) {
    int[] nums = {3,4,5,1,2};
    System.out.println( findMin(nums) );
  }
}
