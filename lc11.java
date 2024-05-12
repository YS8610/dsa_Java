public class lc11 {
  private static int maxArea1(int[] height) {
    int largestArea = 0;
    for (int i=0, n=height.length;i<n;i++){
      for (int j = i+1; j<n-1;j++){
        int area = Math.min(height[i],height[j])* (j-i);
        if (area>largestArea) largestArea = area;
      }

      for (int k = i-1; k>=0;k--){
        int area = Math.min(height[i],height[k]) * Math.abs(i-k);
        if (area>largestArea) largestArea = area;
      }
      
    }
    return largestArea;
  }

  private static int maxArea2(int[] height) {
    int largestArea = 0;
    for (int i=0, n=height.length;i<n;i++ ){
      for(int j=n-1; j>i;j--){
        int area = Math.min(height[i],height[j]) * (j-i);
        largestArea = largestArea<area?area:largestArea;
      }
    }
    return largestArea;
  }

  private static int maxArea(int[] height) {
    int largestArea = 0;
    int lp = 0;
    int rp = height.length-1;
    while(lp<rp){
      int area = Math.min(height[lp], height[rp]) * (rp-lp);
      largestArea = largestArea<area?area:largestArea;
      if (height[lp]<height[rp]) lp++;
      else if (height[lp]>height[rp]) rp--;
      else lp++;
    }
    return largestArea;
  }


  public static void main(String[] args) {
    int[] height = {1,8,6,2,5,4,8,3,7};

    System.out.println( maxArea(height) );
  }
}
