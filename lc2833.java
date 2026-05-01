public class lc2833 {
  public int furthestDistanceFromOrigin(String moves) {
    int wildcard = 0;
    int l = moves.length();
    int left = 0;
    int right = 0;
    for (int i = 0; i < l; i++) {
      if (moves.charAt(i) == '_')
        wildcard++;
      else if (moves.charAt(i) == 'L')
        left++;
      else
        right++;
    }
    int ans = 0;
    int pos = 0;
    if (right >= left) {
      for (int i = 0; i < l; i++)
        pos += moves.charAt(i) == 'L' ? -1 : 1;
      // ans = Math.max(ans, pos);
      return pos;
    }
    ans = 0;
    for (int i = 0; i < l; i++) {
      pos += moves.charAt(i) == 'R' ? -1 : 1;
      // ans = Math.max(ans, pos);
    }
    return pos;
  }
}
