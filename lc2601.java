import java.util.Arrays;

public class lc2601 {

  private static boolean isPrime(int n) {
    int tmp = n;
    if (n == 2) return true;
    while (--n > 1) if (tmp % n == 0) return false;
    return true;
  }

  private static boolean isSorted(int[] nums) {
    for (int i = 0, n = nums.length; i < n - 1; i++) if (
      nums[i] >= nums[i + 1]
    ) return false;
    return true;
  }

  private static boolean primeSubOperation(int[] nums) {
    if (isSorted(nums)) return true;
    int maxNo = 0;
    for (int n : nums) maxNo = Math.max(maxNo, n);
    int l = nums.length;
    int primeNo = maxNo + 100;
    boolean[] sieve = new boolean[primeNo + 1];
    Arrays.fill(sieve, true);
    sieve[0] = false;
    sieve[1] = false;
    for (int i = 2, n = (int) Math.sqrt(primeNo); i <= n; i++) {
      if (!sieve[i]) continue;
      if (isPrime(i)) {
        sieve[i] = true;
        for (int j = i + i; j <= primeNo; j += i) sieve[j] = false;
      }
    }
    int tmp = 0;
    for (int i = 0; i < primeNo; i++) if (sieve[i]) tmp++;
    int[] prime = new int[tmp];
    for (int i = 0, n = 0; i < primeNo; i++) if (sieve[i]) prime[n++] = i;
    for (int i = l - 2; i >= 0; i--) {
      tmp = nums[i + 1] - nums[i];
      if (tmp > 0) continue;
      tmp--;
      tmp = Arrays.binarySearch(prime, -tmp);
      if (tmp >= 0) {
        while (nums[i] <= prime[tmp] && tmp >= 1) tmp--;
        if (nums[i] <= prime[tmp]) continue;
        nums[i] -= prime[tmp];
      } else {
        tmp = -tmp - 1;
        while (nums[i] <= prime[tmp] && tmp >= 1) tmp--;
        if (nums[i] <= prime[tmp]) continue;
        nums[i] -= prime[tmp];
      }
    }
    return isSorted(nums);
  }

  public static void main(String[] args) {
    int[] nums = { 4, 9, 6, 10 };
    System.out.println(primeSubOperation(nums));
  }
}
