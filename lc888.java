import java.util.Arrays;

public class lc888 {
  
  private static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes){
    // Arrays.sort(aliceSizes);
    Arrays.sort(bobSizes);
    int sumAlice = 0;
    int sumBob = 0;
    for (int a : aliceSizes) sumAlice +=a;
    for (int b : bobSizes) sumBob +=b;
    int avg = (sumAlice+sumBob)/2;
    for (int a : aliceSizes){
      int exchangeSize = avg -sumAlice + a;
      if (avg>0) {
        int index = Arrays.binarySearch(bobSizes, exchangeSize);
        if (index>=0) return new int[]{a, bobSizes[index]};
      }
    }
    return new int[]{0,0};
  }

  public static void main(String[] args) {
    int[] aliceSizes = {1,1}, bobSizes = {2,2};
    System.out.println( Arrays.toString( fairCandySwap(aliceSizes, bobSizes) ) );
  }
}
