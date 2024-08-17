public class lc393 {
  private static boolean validUtf8(int[] data) {
    int[] map = new int[8];
    int no = 0;
    int bitmask = 1;
    for (int i=0;i<8;i++){
      map[i] = bitmask;
      bitmask <<=1; 
    }
    for (int i =0, n=data.length; i<n ;i++){
      if (data[i] >= 254) return false;
      if ((map[7] & data[i]) == 0) continue;
      no = 0;
      // find no of byte
      while ( (map[7-no] & data[i])>0) no++;
      // utf8 at most 4 byte even though it is possible to have more byte
      if (no == 1 || no == 5) return false;
      // no of byte - 1 as current byte is included
      if (i + no -1 >= n) return false;
      for (int j =1; j<no;j++){
        if ( !((data[j+i] & map[7]) > 0 && (data[j+i] & map[6]) ==0) ) return false;
      }
      i +=no-1;
    }
    return true;
  }

  public static void main(String[] args) {
    int[] data = {235,140,4};
    System.out.println(validUtf8(data));
  }
}
