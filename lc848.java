public class lc848 {

  public String shiftingLetters(String s, int[] shifts) {
    char[] subans = s.toCharArray();
    for (int i = shifts.length - 2; i >= 0; i--) 
      shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
    for (int i = 0, n = shifts.length; i < n; i++) 
      subans[i] = (char) ((subans[i] - 'a' + shifts[i]) % 26 + 'a');
    return new String(subans);
  }
}
