class lc2381{
  private static String shiftingLetters1(String s, int[][] shifts) {
		char[] schar = s.toCharArray();
		int tmp;
		for (int[] shift:shifts){
			for (int i=shift[0], n=shift[1]+1;i<n;i++){
				tmp = (int)schar[i] + (shift[2]==1?1:-1);
				if (tmp == 'a'-1)
					tmp = 'z';
				else if (tmp == 'z'+1)
					tmp = 'a';
				schar[i] =(char)tmp;
			}
		}
		return String.valueOf(schar);
  }

	private static String shiftingLetters(String s, int[][] shifts) {
		int[] prefix = new int[s.length()+1];
		int tmp;
		for (int[] shift:shifts){
			tmp = shift[2]==0?-1:1;
			prefix[shift[0]] += -tmp;
			prefix[shift[1]+1] += tmp;
		}
		char[] schar = s.toCharArray();
		tmp = prefix[s.length()];
		for (int i=s.length()-1;i>=0;i--){
			schar[i] = shifting(schar[i], tmp);
			tmp += prefix[i];
		}
		return String.valueOf(schar);
	}

	private static char shifting(char c, int amt){
		amt %= 26;
		if (amt == 0) return c;
		int tmp = c -'a';
		if (amt >=0)
			tmp = (tmp+amt)%26;
		else{
			tmp += amt;
			if (tmp < 0)
				tmp += 26;
		}
		return (char)(tmp+'a');
	}

  public static void main(String[] args){
    String s = "abc";
    int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
    System.out.println(shiftingLetters(s, shifts));
  }

}
