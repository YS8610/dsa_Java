import java.util.ArrayList;
import java.util.List;

public class lc273 {

  private static String numberToWords(int num) {
    String[] one = {
      "Zero",
      "One",
      "Two",
      "Three",
      "Four",
      "Five",
      "Six",
      "Seven",
      "Eight",
      "Nine",
      "Ten",
      "Eleven",
      "Twelve",
      "Thirteen",
      "Fourteen",
      "Fifteen",
      "Sixteen",
      "Seventeen",
      "Eighteen",
      "Nineteen",
      "Twenty",
    };
    String[] tens = {
      "Thirty",
      "Forty",
      "Fifty",
      "Sixty",
      "Seventy",
      "Eighty",
      "Ninety",
      "Hundred",
    };
    String[] thou = { "", "Thousand", "Million", "Billion" };
    String[] map1k = new String[thou.length + 1];
    String[] map = new String[101];
    int[][] a = new int[thou.length + 1][3];
    int i = -1;
    List<String> ansL = new ArrayList<>(15);
    for (String word : one) map[++i] = word;
    i = 2;
    for (String word : tens) map[++i * 10] = word;
    i = -1;
    for (String word : thou) map1k[++i] = word;
    i = -1;
    if (num <= 20) return map[num];
    while (num != 0) {
      a[++i / 3][i % 3] = num % 10;
      num /= 10;
    }
    int b = 0;
    for (int j = a.length - 1; j >= 0; j--) {
      if (a[j][0] == 0 && a[j][1] == 0 && a[j][2] == 0) continue;
      if (a[j][2] > 0) {
        ansL.add(map[a[j][2]]);
        ansL.add(map[100]);
      }
      b = a[j][1] * 10 + a[j][0];
      if (b == 0) {
        if (map1k[j] != "") ansL.add(map1k[j]);
        continue;
      }
      if (b <= 20 || (b != 0 && b % 10 == 0)) ansL.add(map[b]); else {
        ansL.add(map[a[j][1] * 10]);
        ansL.add(map[a[j][0]]);
      }
      if (map1k[j] != "") ansL.add(map1k[j]);
    }
    return String.join(" ", ansL);
  }

  private static String numberToWords1(int num) {
    String one = "Zero One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen Twenty";
    String tens = "Thirty Forty Fifty Sixty Seventy Eighty Ninety Hundred";
    String thou = "Thousand Million Billion";
    int len = thou.split(" ").length;
    String[] map1k = new String[len+1];
    map1k[0] = "";
    String[] map = new String[101];
    int[][] a = new int[len+1][3];
    int i = -1;
    List<String> ansL = new ArrayList<>(15);
    for (String word: one.split(" ")) map[++i] = word;
    i = 2;
    for (String word: tens.split(" ")) map[++i * 10] = word;
    i = 0;
    for (String word : thou.split(" ")) map1k[++i] = word;
    i = -1;
    if (num <= 20) return map[num]; 
    while (num != 0){
      a[++i/3][i%3] = num % 10;
      num /= 10;
    }
    int b = 0;
    for (int j = a.length-1; j>=0;j--){
      if (a[j][0] == 0 && a[j][1] == 0 && a[j][2] == 0) continue;
      if (a[j][2]>0) {
        ansL.add( map[a[j][2]]);
        ansL.add( map[100]);
      }
      b = a[j][1]*10+a[j][0];
      if (b == 0) {
        if (map1k[j]!= "") ansL.add( map1k[j]);
        continue;
      }
      if (b <= 20 || (b !=0 && b %10 == 0)) ansL.add( map[b]);
      else{
        ansL.add(map[a[j][1] * 10]);
        ansL.add(map[a[j][0]]);
      }
      if (map1k[j]!= "") ansL.add( map1k[j]);
    }
    return String.join(" ", ansL);
    }

  public static void main(String[] args) {
    int num = 123;
    System.out.println(numberToWords(num));
    System.out.println(numberToWords1(num));
  }
}
