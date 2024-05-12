import java.util.HashSet;
import java.util.List;
import java.util.Set;

class lc3136 {

  private static boolean isValid(String word) {
    int l = word.length();
    if (l < 3) return false;
    boolean sc = false;
    boolean tc = false;
    Set<Character> vowel = new HashSet<>();
    vowel.addAll(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    for (int i = 0; i < l; i++) {
      if (vowel.contains(word.charAt(i))) sc = true;
      if (
        (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') ||
        (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
      ) {
        if (!vowel.contains(word.charAt(i))) tc = true;
      }
      if (
        (word.charAt(i) >= '0' && word.charAt(i) <= '9') ||
        (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') ||
        (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
      ) continue; else return false;
    }
    if (sc && tc) return true;
    return false;
  }

  public static void main(String[] args) {
    String word = "Uu0e";
    System.out.println(isValid(word));
  }
}
