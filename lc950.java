import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc950 {
    private static int[] deckRevealedIncreasing(int[] deck) {
    int l = deck.length;
    int t;
    int count = -1;
    int[] temp = new int[l];
    int[] ans = new int[l];
    for (int i=0;i<l;i++) temp[i] = i;
    Arrays.sort(deck);
    Deque<Integer> stack = new ArrayDeque<>(Arrays.stream(temp).boxed().toList());
    while (!stack.isEmpty()){
      temp[++count] = stack.pollFirst();
      if (!stack.isEmpty()){
        t = stack.pollFirst();
        stack.addLast(t);
      }
    }
    for (int i =0;i<l;i++){
      ans[temp[i]] = deck[i];
    }
    return ans;
    }

    public static void main(String[] args) {
      int[] deck = {17,13,11,2,3,5,7};
      System.out.println( Arrays.toString(deckRevealedIncreasing(deck)));
    }
}
