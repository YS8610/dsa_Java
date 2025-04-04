public class lc2594 {
  static public long repairCars(int[] ranks, int cars) {
    long lo = 1;
    long hi = (long)ranks[0]*cars*cars;
    long mid = 0;
    while (lo <hi){
      mid = (hi-lo)/2+lo;
      if (can(ranks, cars, mid))
        hi = mid;
      else
        lo = mid+1;
    }
    return can(ranks, cars,mid)?mid:lo;
  }

  private static boolean can(int[] ranks, int cars, long t){
    long repaired = 0;
    for (int r : ranks)
      repaired += (long)Math.sqrt(t/r);
    return repaired>=cars;
  }

  public static void main(String[] args) {
    int[] ranks = {4,2};
    int cars = 1000000;
    System.out.println(repairCars(ranks, cars));
  }
}
