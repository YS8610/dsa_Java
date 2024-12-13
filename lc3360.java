class lc3360{
  private static boolean canAliceWin(int n) {
    if (n < 10) return false;
    n -=10;
    int alice = 10;
    int bob = alice-1;
    boolean aliceturn = false;
    while (n >= 0){
      if (aliceturn){
        n-= alice;
        bob = alice -1;
        if (n==0) return true;
        if (n<0) return false;
      }
      else{
        n-=bob;
        alice = bob -1;
        if (n==0) return false;
        if (n < 0) return true;
      }
      aliceturn = !aliceturn;
    }
    return false;
  }

  public static void main(String[] args) {
    int n =40;
    System.out.println(canAliceWin(n));
  }
}