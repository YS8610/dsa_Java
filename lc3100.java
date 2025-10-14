public class lc3100 {
  public int maxBottlesDrunk(int numBottles, int numExchange) {
    int empty = numBottles;
    int drunk = numBottles;
    while (empty >= numExchange) {
      empty -= numExchange;
      drunk++;
      empty++;
      numExchange++;
    }
    return drunk;
  }
}
