class lc1551{
  private static int minOperations(int n) {
    int lp = 0;
    int rp = n-1;
    int ans = 0;
    while (lp < rp)
      ans+= (getNum(rp--)-getNum(lp++))/2;
    return ans;
  }

  private static int getNum(int pos){
    return 2*pos+1;
  }
  
  public static void main(String[] args){
    int n =6;
    System.out.println(minOperations(n));
  }
}
