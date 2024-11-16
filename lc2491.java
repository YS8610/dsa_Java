import java.util.Arrays;

public class lc2491 {

  private static long dividePlayers(int[] skill) {
    Arrays.sort(skill);
    int lp = 0;
    int rp = skill.length - 1;
    int tmp = skill[lp] + skill[rp];
    long ans = 0;
    while (lp < rp) {
      if (skill[lp] + skill[rp] != tmp) return -1;
      ans += skill[lp] * skill[rp];
      lp++;
      rp--;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] skill = {3,2,5,1,3,4};
    System.out.println(dividePlayers(skill));
  }
}
