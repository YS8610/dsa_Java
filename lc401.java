import java.util.ArrayList;
import java.util.List;

public class lc401 {
  static public List<String> readBinaryWatch(int turnedOn) {
    List<Integer> possible = new ArrayList<>();
    dfs(turnedOn, 9, 0, possible);
    List<String> ans = new ArrayList<>();
    for (int p : possible) {
      String tmp = convert(p);
      if (tmp == null)
        continue;
      ans.add(tmp);
    }
    return ans;
  }

  static public String convert(int bit) {
    int hr = 0;
    int min = 0;
    for (int i = 6; i < 10; i++)
      hr += (bit & (1 << i)) == 0 ? 0 : (1 << (i - 6));
    for (int i = 0; i < 6; i++)
      min += (bit & (1 << i)) == 0 ? 0 : (1 << i);
    if (hr >= 12 || min >= 60)
      return null;
    String hrStr = hr == 0 ? "0" : String.valueOf(hr);
    String minStr;
    if (min == 0)
      minStr = "00";
    else if (min < 10)
      minStr = "0" + String.valueOf(min);
    else
      minStr = String.valueOf(min);
    return hrStr + ":" + minStr;
  }

  static public void dfs(int turnOn, int i, int bit, List<Integer> possible) {
    if (turnOn == i + 1) {
      while (i >= 0)
        bit |= 1 << i--;
      possible.add(bit);
      return;
    }
    if (turnOn == 0 || i < 0) {
      possible.add(bit);
      return;
    }
    // turn on
    dfs(turnOn - 1, i - 1, bit | 1 << i, possible);
    dfs(turnOn, i - 1, bit, possible);
  }

  public static void main(String[] args) {
    int turnedOn = 7;
    System.out.println(readBinaryWatch(turnedOn));
  }
}
