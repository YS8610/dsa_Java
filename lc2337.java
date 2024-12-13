public class lc2337 {

  public boolean canChange(String start, String target) {
    int n = 0;
    int n1 = 0;
    for (int i = 0; i < start.length(); i++) {
      if (start.charAt(i) == 'R' || start.charAt(i) == 'L') n++;
      if (target.charAt(i) == 'R' || target.charAt(i) == 'L') n1++;
    }
    if (n != n1) return false;
    char[] c1 = new char[n];
    char[] c2 = new char[n];
    for (int i = 0, j = 0; i < start.length(); i++) {
      if (start.charAt(i) == '_') continue;
      c1[j++] = start.charAt(i);
    }
    for (int i = 0, j = 0; i < start.length(); i++) {
      if (target.charAt(i) == '_') continue;
      c2[j++] = target.charAt(i);
    }
    for (int i = 0; i < c1.length; i++) if (c1[i] != c2[i]) return false;
    int[] i1 = new int[n];
    int[] i2 = new int[n];
    for (int i = 0, j = 0; i < start.length(); i++) {
      if (start.charAt(i) == '_') continue;
      i1[j++] = i;
    }
    for (int i = 0, j = 0; i < start.length(); i++) {
      if (target.charAt(i) == '_') continue;
      i2[j++] = i;
    }
    for (int i = 0; i < c1.length; i++) {
      if (c1[i] == 'L') {
        if (i2[i] > i1[i]) return false;
      } else {
        if (i2[i] < i1[i]) return false;
      }
    }
    return true;
  }
}
