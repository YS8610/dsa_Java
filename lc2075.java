public class lc2075 {
  public String decodeCiphertext(String encodedText, int rows) {
    int l = encodedText.length();
    if (l == 1)
      return encodedText;
    int lc = l / rows;
    StringBuilder ans = new StringBuilder();
    for (int c = 0, pos = 0; c < lc; c++) {
      for (int r = 0; r < rows; r++) {
        pos = c + (r * lc + r);
        if (pos >= l)
          continue;
        ans.append(encodedText.charAt(pos));
      }
    }
    return ans.toString().stripTrailing();
  }
}
