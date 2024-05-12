import java.util.HashMap;
import java.util.Map;

public class lc299 {

  private static String getHint(String secret, String guess) {
    Map<Character, Integer> memoSec = new HashMap<>();
    Map<Character, Integer> memoGuess = new HashMap<>();
    int len = secret.length();
    int bull = 0, cow = 0;
    for (int i = 0; i < len; i++) {
      if (secret.charAt(i) == guess.charAt(i)) bull++; else {
        if (memoSec.containsKey(secret.charAt(i))) memoSec.put(
          secret.charAt(i),
          memoSec.get(secret.charAt(i)) + 1
        ); else memoSec.put(secret.charAt(i), 1);

        if (memoGuess.containsKey(guess.charAt(i))) memoGuess.put(
          guess.charAt(i),
          memoGuess.get(guess.charAt(i)) + 1
        ); else memoGuess.put(guess.charAt(i), 1);
      }
    }
    for (char k : memoGuess.keySet()){
      if (memoSec.containsKey(k)) cow += Math.min(memoSec.get(k), memoGuess.get(k));
    }

    return String.valueOf(bull)+"A"+String.valueOf(cow)+"B";
  }

  public static void main(String[] args) {
    String secret = "1801", guess = "7810";
    System.out.println( getHint(secret, guess) );
  }
}
