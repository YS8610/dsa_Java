public class lc717 {
  public boolean isOneBitCharacter(int[] bits) {
    int l = bits.length;
    for (int i = 0; i < l; i++) {
      if (i == l - 1)
        return true;
      i += bits[i] == 1 ? 1 : 0;
    }
    return false;
  }
}
