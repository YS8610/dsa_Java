public class lc319 {
  
  private static int bulbSwitch(int n) {
    if (n==0) return 0;
    if (n==1) return 1;
    if (n==2) return 1;
    if (n==3) return 1;
    int[] a = new int[n+1];
    a[0] = 0;
    a[1] = 1;
    a[2] = 0;
    int sum = 0;
    for (int i =3; i<=n;i++){
      if (i%2==0 && i%3==0) a[i]=1;
      else if (i%2!=0 && i%3==0) a[i]=0;
      else if (i%2==0) a[i]=0;
      else a[i]= 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    int n =3;
    System.out.println( bulbSwitch(n) );
  }
}
