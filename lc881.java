import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc881 {

  private static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int n = people.length;
    int lp=0;
    int rp=n-1;
    int boat = 0;
    while (lp<rp){
      if (people[rp]==limit) {
        rp--;
        boat++;
      }
      else if (people[rp]<limit){
        int sum = people[rp] + people[lp];
        if (sum<=limit) {
          lp++;
          // while(sum<=limit && lp<rp){
          //   lp++;
          //   sum += people[lp];
          // }
          rp--;
          boat++;
        }
        else{
          rp--;
          boat++;
        }
      }
    }
    return lp==rp?boat+1: boat;
  }

  private static int numRescueBoats1(int[] people, int limit) {
    List<Integer> ppl = new ArrayList<>(Arrays.stream(people).boxed().toList());
    ppl.sort(Collections.reverseOrder());
    int n = people.length;
    int fullBoat = 0;
    List<List<Integer>> memo = new ArrayList<>(n);
    memo.add(new ArrayList<>());
    outloop:for (int i = 0; i < n; i++) {
      for (int j = fullBoat, m = memo.size(); j < m; j++) {
        List<Integer> boat = memo.get(j);
        int sumofArray = boat.stream().reduce(0, Integer::sum);
        // when boat is empty
        if (boat.isEmpty()) {
          boat.add(ppl.get(i));
          continue outloop;
        }
        // when boat is full
        else if (boat.size() == 2 || sumofArray == limit) {
          fullBoat++;
          memo.add(new ArrayList<>(2));
          memo.get(m).add(ppl.get(i));
          continue outloop;
        }
        // when boat is partially filled
        else if (
          boat.size() < 2 &&
          sumofArray < limit &&
          boat.get(0) + ppl.get(i) <= limit
        ) {
          boat.add(ppl.get(i));
          fullBoat++;
          if (fullBoat == memo.size()) memo.add(new ArrayList<>(2));
          continue outloop;
        }
      }
      // when all partially filled boat cannot fill current ppl.get(i)
      memo.add(new ArrayList<>(2));
      memo.get(memo.size() - 1).add(ppl.get(i));
    }
    System.out.println(memo.toString());
    return memo.get(memo.size() - 1).isEmpty() ? memo.size() - 1 : memo.size();
  }

  public static void main(String[] args) {
    int[] people = { 3,3,2,2,1,1,1,1,1 };
    // int[] people = {3,2,2,1};
    int limit = 3;
    System.out.println(numRescueBoats(people, limit));
    System.out.println(numRescueBoats1(people, limit));
  }
}
