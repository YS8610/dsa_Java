import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc322 {

  // static private List<List<Integer>> allCombinationUniDP(int[] candidates, int target, Map<Integer,List<List<Integer>>> memo ){
  //   List<List<Integer>> temp = new ArrayList<>();
    
  //   if (target <0) return null;
  //   if (target ==0) {
  //     List<List<Integer>> ansSet = new ArrayList<>();
  //     ansSet.add(new ArrayList<>());
  //     return ansSet;
  //   }
  //   if (memo.containsKey(target)){
  //     return new ArrayList<>(memo.get(target).stream().map(ArrayList::new).collect(Collectors.toList()));
  //   } 

  //   for (int i=0, n=candidates.length; i<n;i++){
  //     int remainder = target - candidates[i];
  //     List<List<Integer>> result = allCombinationUniDP(candidates, remainder,memo);
  //     if (result != null){
  //       for (int j =0, m=result.size(); j<m;j++) {
  //         result.get(j).add( candidates[i] );
  //       }
  //       temp.addAll(new ArrayList<>(result));
  //     }
  //   }
  //   Set<List<Integer>> setTemp = new HashSet<>();
  //   for (List<Integer> a : temp){
  //     a.sort( (m1,m2) -> m1.compareTo(m2));
  //     setTemp.add(a);
  //   }
  //   List<List<Integer>> tempUnique = new ArrayList<>( setTemp.stream().map(ArrayList::new).collect(Collectors.toList()) );
  //   memo.put(target, new ArrayList<>( setTemp.stream().map(ArrayList::new).collect(Collectors.toList()) ) );
  //   System.out.println(memo.toString());
  //   return tempUnique;
  // }

  // private static int coinChange(int[] coins, int amount) {
  //   if (amount ==0) return 0;
  //   if (coins.length==1 && coins[0] <amount) {
  //       return amount%coins[0]==0?amount/coins[0]:-1;
  //   };
  //   if (coins.length==1 && coins[0] >amount) return -1;
  //   List<List<Integer>> uniqueCoin = allCombinationUniDP(coins, amount, new HashMap<>());
  //   int ans=0;
  //   for (List<Integer> c : uniqueCoin){
  //     if (ans == 0 ) ans = c.size();
  //     else{
  //       if (ans>c.size()) ans = c.size();
  //     }
  //   }
  //   return ans;
  // }
  private static Map <Integer,Integer> memo = new HashMap<>();
  private static int coinChange(int[] coins, int amount) {
    int ans = amount +1;
    Boolean canChange = false;
    if (amount ==0) return 0;
    if (amount < 0 ) return -1;
    if (memo.containsKey(amount)) return memo.get(amount);

    for (int coin : coins){
      int remainder = amount - coin;
      int result = coinChange(coins, remainder);
      if (result>=0) {
        result ++;
        canChange = true;
      }
      if (canChange && result!=-1) ans = ans<0?result:Math.min(ans, result);
      // else if (!canChange) ans = result;
      else if (!canChange) ans = -1;
    }
    memo.put(amount, ans);
    return ans;
  }
  
  private static List<Integer> minCoin(int[] coinCandidates, int coins){
    List<Integer> ans = new ArrayList<>();
    for (int coinCandidate:coinCandidates){
      while (coins>=coinCandidate){
        ans.add(coinCandidate);
        coins = coins-coinCandidate;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] coins = {7,405,436};
    int amount = 443;
    
    System.out.println( coinChange(coins,amount));

    int[] coins1 = {100,50,25,20,10,5};
    System.out.println( minCoin(coins1, 0).toString() );

  }

}
