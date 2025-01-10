class lc1014{

  private static int maxScoreSightseeingPair(int[] values) {
    int l = values.length;
    int ans = 0;
    int maxi = values[0];
    for (int i =1; i<l;i++){
      maxi = Math.max(values[i-1] + i-1, maxi);
      ans = Math.max(maxi+values[i]-i, ans);
    }
    return ans;
  }

  public static void main(String[] args){
    int[] values = {8,1,5,2,6};
    System.out.println(maxScoreSightseeingPair(values));
  }
}
