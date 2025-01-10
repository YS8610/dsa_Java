import java.util.Arrays;

class lc1769{
  private static int[] minOperations(String boxes) {
    int l = boxes.length();
    int[] ans = new int[l];
    for (int box=0;box<l;box++){
      for (int j =0; j<l;j++){
        if (boxes.charAt(j)=='0')
          continue;
        ans[box] += Math.abs(box-j);
      } 
    }
    return ans;
  }

  private static int[] minOperations1(String boxes) {
    int l = boxes.length();
    int[] prefix = new int[l];
    int[] postfix = new int[l];
    int[] ans = new int[l];
    int tmp= boxes.charAt(0)=='0'?0:1;
    for (int i =1;i<l;i++){
      prefix[i] += tmp+prefix[i-1];
      if (boxes.charAt(i)=='1')
        tmp++;
    }
    tmp = boxes.charAt(l-1)=='0'?0:1;
    for (int i=l-2;i>=0;i--){
      postfix[i] += tmp+postfix[i+1];
      if (boxes.charAt(i) == '1')
        tmp++;
    }
    for (int i =0;i<l;i++)
      ans[i] = prefix[i] + postfix[i];
    return ans;
  }

  public static void main(String[] args){
    String boxes = "001011";
    System.out.println(Arrays.toString(minOperations(boxes)));
    System.out.println(Arrays.toString(minOperations1(boxes)));
  }
}
