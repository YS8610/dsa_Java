import java.util.HashSet;
import java.util.List;
import java.util.Set;

class lc3136 {

  private static boolean isValid(String word) {
    int l = word.length();
    if (l < 3)
      return false;
    boolean sc = false;
    boolean tc = false;
    Set<Character> vowel = new HashSet<>();
    vowel.addAll(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    for (int i = 0; i < l; i++) {
      if (vowel.contains(word.charAt(i)))
        sc = true;
      if ((word.charAt(i) >= 'a' && word.charAt(i) <= 'z') ||
          (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
        if (!vowel.contains(word.charAt(i)))
          tc = true;
      }
      if ((word.charAt(i) >= '0' && word.charAt(i) <= '9') ||
          (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') ||
          (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'))
        continue;
      else
        return false;
    }
    if (sc && tc)
      return true;
    return false;
  }

  public boolean isValid1(String word) {
    boolean[] map = new boolean[3];
    int l = word.length();
    char tmp;
    if (l <= 2)
      return false;
    for (int i = 0; i < l; i++) {
      if (word.charAt(i) >= '0' && word.charAt(i) <= '9' || Character.isLetter(word.charAt(i)))
        map[0] = true;
      else
        return false;
      if (Character.isLetter(word.charAt(i))) {
        tmp = Character.toLowerCase(word.charAt(i));
        if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u')
          map[1] = true;
        else
          map[2] = true;
      }

    }
    for (boolean m : map)
      if (!m)
        return false;
    return true;
  }

  public static void main(String[] args) {
    String word = "Uu0e";
    System.out.println(isValid(word));
  }
}
