class lc219{
  
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7,8,9,10};
    int k = 15;
    int count = 1;
    
    int n = nums.length;
    if (k>=n){
      k=n;
    }
    
    for (int i =0;i<n;i++){
      if (i < n-k){
        for (int j = 0; j<k;j++){
          if (nums[i]==nums[i+j+1]) System.out.println(true);
        }
      }
      else{
        for (int m=0; m<k-count;m++){
          if (nums[i]==nums[i+m+1]) System.out.println(true);
        }
        count++;
      }
    }
  }
}