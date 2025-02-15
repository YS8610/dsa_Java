import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class lc1333{
  
  private static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    int l = restaurants.length;
    int count = 0;
    for (int[] r : restaurants)
      if ((veganFriendly==0 || r[2] == veganFriendly) && r[3] <= maxPrice && r[4] <= maxDistance)
        count++;
    int[][] selected = new int[count][5];
    count = 0;
    for (int[] r : restaurants)
      if ((veganFriendly==0 || r[2] == veganFriendly) && r[3] <= maxPrice && r[4] <= maxDistance)
        selected[count++] = Arrays.copyOf(r, 5);
    Arrays.sort(selected, (m1,m2)->{
      if (m2[1] == m1[1])
        return Integer.compare(m2[0], m1[0]);
      return Integer.compare(m2[1], m1[1]);
    });
    List<Integer> ans = new ArrayList<>(selected.length);
    for (int[] s:selected)
      ans.add(s[0]);
    return ans;
  }

  public static void main(String[] args){
    int[][] restaurants = {
      {1,4,1,40,10},
      {2,8,0,50,5},
      {3,8,1,30,4},
      {4,10,0,10,3},
      {5,1,1,15,1}
    };
    int veganFriendly = 0, maxPrice = 50, maxDistance = 10;
    System.out.println(filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance).toString());
  }
}
