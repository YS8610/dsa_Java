import java.util.Arrays;

public class lc2300 {

  private static int[] successfulPairs(int[] spells, int[] potions, long success) {
    int lenSpell = spells.length;
    int lenPotion = potions.length;
    int[] ans = new int[lenSpell];
    int start = 0;
    int end = lenPotion - 1;
    int mid;
    Arrays.sort(potions);
    for (int i = 0; i < lenSpell; i++) {
      if ((long) spells[i] * (long) potions[0] >= success) {
        ans[i] = lenPotion;
        continue;
      }
      if ((long) spells[i] * (long) potions[lenPotion - 1] < success) {
        ans[i] = 0;
        continue;
      }
      start = 0;
      end = lenPotion - 1;
      while (start <= end) {
        mid = start + (end - start) / 2;
        if ((long) spells[i] * (long) potions[mid] >= success) {
          end = mid;
        }
        if ((long) spells[i] * (long) potions[mid] < success) {
          start = mid;
        }
        if (end == start) break;
        if (end - start == 1) break;
      }
      if ((long) spells[i] * (long) potions[start] >= success) {
        ans[i] = lenPotion - start;
      } else ans[i] = lenPotion - end;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] spells = { 5, 1, 3 };
    int[] potions = { 1, 2, 3, 4, 5 };
    int success = 7;

    System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
  }
}
