public class lc134 {
  
  private static int canCompleteCircuit1(int[] gas, int[] cost){
    int n = gas.length;
    int[] netGain = new int[n];
    int sumCost=0;
    int highestLoc =0;
    for (int i=0; i<n;i++){
      int gain =  gas[i] - cost[i];
      netGain[i] = gain;
      sumCost += gain;
      if (gain > netGain[highestLoc]) highestLoc = i;
    }
    if (sumCost<0) return -1;
    outloop:
    for (int i =0;i<n;i++ ){
      int totalGain = 0;
      for (int j =i; j<n;j++){
        totalGain += netGain[j];
        if (totalGain<0) continue outloop;
      }
      return i;
    }
    return highestLoc;
  }

  private static int canCompleteCircuit(int[] gas, int[] cost){
    int n = gas.length;
    if (n==1) return gas[0]>=cost[0]?0:-1; 
    outloop:
    for (int i=0;i<n;i++){
      int gain =  gas[i] - cost[i];
      int netGain = 0;
      if(gain<=0) continue;
      int counter =0;
      for(int j=i;j<n;j++){
        netGain += gas[j] - cost[j];
        counter ++;
        if (counter<n && netGain<=0) continue outloop;
        if (counter==n && netGain<0) continue outloop;
      }
      for (int j=0; j<i;j++){
        netGain += gas[j] - cost[j];
        counter ++;
        if (counter<n && netGain<=0) continue outloop;
        if (counter==n && netGain<0) continue outloop;
      }

      return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] gas = {5,8,2,8}, cost = {6,5,6,6};
    System.out.println( canCompleteCircuit1(gas,cost) );
    System.out.println( canCompleteCircuit(gas,cost) );
  }
}
