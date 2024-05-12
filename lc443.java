public class lc443 {
  private static int compress(char[] chars) {
    String a="";
    outloop:
    for (int i =0, n=chars.length; i<n;i++){
      int counter = 1;
      a += chars[i];
      for (int j=i+1; j<n;j++){
        if (chars[i] == chars[j]) counter++;
        else{
          i = j-1;
          break;
        }
        if (j==n-1) {
          if (counter>1) a+= counter;
          break outloop;
        }
      }
      if (counter>1)a+= counter;
    }
    // System.out.println(a);
    for(int i =0,n=a.length();i<n;i++){
      chars[i] = a.charAt(i);
    }
    return a.length();
  }
  public static void main(String[] args) {
    char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};

    System.out.println( compress(chars) );

  }
}
