class lc9 {
  
  public static void main(String[] args) {
    int x = 121;
    String y = ""+x;
    String z = "";

    for(int i=y.length()-1; i>=0;i--){
      z += y.charAt(i);
    }

    if (z.equals(y)){
      System.out.println("true");
    }
    else{
      System.out.println("false");
    }

  }

}