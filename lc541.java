public class lc541 {
  
  private static String reverse(String a) {
    int len = a.length();
    String ans = "";
    for (int i =len-1; i>=0;i--) ans += String.valueOf(a.charAt(i));
    return ans;
  }

  public static void main(String[] args) {
    String s = "abcdefg";
    int k = 3;

    Boolean rev= true;
    String ans = "";
    int repNo = s.length()/k-1; 

    for (int i=0;i<=repNo;i++){
      if (rev){
        ans += reverse( s.substring(k*i, (i+1)*k) );
        rev=false;
      }else{
        ans += s.substring( k*i, (i+1)*k );
        rev = true;
      }
    }
    if (rev) ans += reverse( s.substring( k*(repNo+1), s.length() ) );
    else ans += s.substring( k*(repNo+1), s.length() );
    System.out.println(ans);
  }
}