import java.util.Arrays;

public class lc2043 {
  private long[] bal;

  public lc2043(long[] balance) {
    this.bal = Arrays.copyOf(balance, balance.length);
  }

  public boolean transfer(int account1, int account2, long money) {
    int l = this.bal.length;
    if (account1 > l || account2 > l)
      return false;
    if (money == 0)
      return true;
    if (this.bal[account1 - 1] < money)
      return false;
    this.bal[account1 - 1] -= money;
    this.bal[account2 - 1] += money;
    return true;
  }

  public boolean deposit(int account, long money) {
    int l = this.bal.length;
    if (account > l)
      return false;
    this.bal[account - 1] += money;
    return true;
  }

  public boolean withdraw(int account, long money) {
    int l = this.bal.length;
    if (account > l)
      return false;
    if (this.bal[account - 1] < money)
      return false;
    this.bal[account - 1] -= money;
    return true;
  }
}
