class lc3208 {

  static public int numberOfAlternatingGroups(int[] colors, int k) {
    int i = 0;
    int j = 0;
    int l = colors.length;
    int n = l + k;
    int ans = 0;
    while (i < l){
      while (j < n && i <l){
        if (i ==j || colors[j%l] != colors[(j-1)%l]){
          if (j-i+1 >= k){
            ans++;
            i++;
          }
          j++;
        }
        else
          break;
      }
      i = j;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] colors = {0,1,0,1,0};
    int k = 3;
    System.out.println(numberOfAlternatingGroups(colors, k));
  }

}
