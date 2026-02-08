public class lc744 {
  private static char nextGreatestLetter(char[] letters, char target) {
    boolean[] map = new boolean[26];
    for (char l : letters)
      map[l - 'a'] = true;
    for (int i = target - 'a' + 1; i < 26; i++)
      if (map[i])
        return (char) (i + 'a');
    return letters[0];
  }
  public static void main(String[] args) {
    // char[] letters = {'e','e','f','f','g','g'};
    char[] letters = { 'c', 'f', 'j' };
    char target = 'c';
    System.out.println(nextGreatestLetter(letters, target));
  }
}
