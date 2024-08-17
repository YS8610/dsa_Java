import java.util.ArrayList;
import java.util.List;

public class lc68 {

  private static boolean canFit(int maxWidth, int curWidth, int wordWidth) {
    if (curWidth == 0 && maxWidth == wordWidth) return true;
    if (maxWidth >= curWidth + wordWidth + 1) return true;
    return false;
  }

  private static List<String> fullJustify(String[] words, int maxWidth) {
    List<List<String>> subans = new ArrayList<>();
    int curWidth = 0;
    int l;
    List<String> line = new ArrayList<>();
    for (String w : words) {
      l = w.length();
      if (curWidth == 0) {
        curWidth = l;
        line.add(w);
        continue;
      }
      if (canFit(maxWidth, curWidth, l)) {
        curWidth += l + 1;
        line.add(w);
      } else {
        subans.add(line);
        line = new ArrayList<>();
        curWidth = l;
        line.add(w);
      }
    }
    subans.add(line);
    List<String> ans = new ArrayList<>(subans.size());
    int nline = -1;
    for (List<String> s : subans) {
      nline++;
      int len = s.size();
      int tlen = s.stream().mapToInt(String::length).sum();
      StringBuilder a = new StringBuilder();
      if (len == 1) {
        a.append(s.get(0));
        for (int i = 0, n = maxWidth - tlen; i < n; i++) a.append(' ');
        ans.add(a.toString());
        continue;
      }
      if (nline == subans.size() - 1) {
        String laststr = String.join(" ", s);
        a.append(laststr);
        for (int j = 0, m = maxWidth - laststr.length(); j < m; j++) {
          a.append(' ');
        }
        ans.add(a.toString());
        continue;
      }
      int space = (maxWidth - tlen) / (len - 1);
      int reminder = (maxWidth - tlen) % (len - 1);
      for (int i = 0; i < len; i++) {
        if (i == 0) {
          a.append(s.get(i));
          continue;
        }
        for (int j = 0; j < space; j++) a.append(' ');
        if (reminder > 0) a.append(' ');
        reminder--;
        a.append(s.get(i));
      }
      ans.add(a.toString());
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] words = {"What","must","be","acknowledgment","shall","be"};
    int maxWidth = 16;
    System.out.println(fullJustify(words, maxWidth));
  }
}
