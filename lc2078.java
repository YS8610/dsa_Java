public class lc2078 {

  private static int timeRequiredToBuy(int[] tickets, int k) {
    int ans = 0;
    int i = 0;
    int l = tickets.length;
    while (tickets[k] != 0) {
      if (tickets[i] > 0) {
        tickets[i]--;
        ans++;
      }
      i++;
      if (i >= l) i = 0;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] tickets = {5,1,1,1};
    int k = 0;
    System.out.println(timeRequiredToBuy(tickets, k));
  }
}
