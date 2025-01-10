import java.util.Arrays;

class lc1561{
  private static int maxCoins(int[] piles) {
    Arrays.sort(piles);
    int ans = 0;
    int n = piles.length/3;
    int i = piles.length-2;
    while (n-- > 0){
      ans+=piles[i];
      i-=2;
    }
    return ans;
  }

  public static void main(String[] args){
    int[] piles = {9,8,7,6,5,1,2,3,4};
    System.out.println(maxCoins(piles));
  }

}
