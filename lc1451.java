import java.util.Arrays;

public class lc1451 {

  private static String arrangeWords(String text) {
    String[] arr = text.split(" ");
    StringBuilder pre = new StringBuilder();
    if (arr[0].charAt(0) >= 'A' && arr[0].charAt(0) <= 'Z') {
      pre.append((char) (arr[0].charAt(0) + ('a' - 'A')));
      for (int i = 1, n = arr[0].length(); i < n; i++) {
        pre.append(arr[0].charAt(i));
      }
      arr[0] = pre.toString();
    }
    Arrays.sort(arr, (m1, m2) -> Integer.compare(m1.length(), m2.length()));
    StringBuilder first = new StringBuilder();
    for (int i = 0, n = arr[0].length(); i < n; i++) {
      if (i == 0 && arr[0].charAt(0) >= 'a' && arr[0].charAt(0) <= 'z') {
        first.append((char) (arr[0].charAt(i) - ('a' - 'A')));
      } else first.append(arr[0].charAt(i));
    }
    arr[0] = first.toString();

    return String.join(" ", arr);
  }

  public static void main(String[] args) {
    String text = "Keep calm and code on";
    System.out.println(arrangeWords(text));
  }
}
