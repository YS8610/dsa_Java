class lc3340{
  private static boolean isBalanced(String num) {
    int even=0;
    int odd= 0;
    for (int i=0,n=num.length();i<n;i++){
      if ((i & 1)==0) even += num.charAt(i) - '0';
      else odd += num.charAt(i) - '0';
    }
    return odd == even;
  }

  public static void main(String[] args) {
    String num = "24123";
    System.out.println(isBalanced(num));
  }

}