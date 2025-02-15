class lc2116{

	private static boolean canBeValid(String s, String locked) {
		int l = s.length();
		if (l%2 != 0) return false;
		int unlocked = 0;
		int lockedClose = 0;
		int lockedOpen = 0;
		for (int i =0; i<l;i++){
			if (locked.charAt(i) == '0')
				unlocked++;
			else if (locked.charAt(i) == '1' && s.charAt(i) == ')')
				lockedClose++;
			else 
				lockedOpen++;
			if (lockedClose > unlocked + lockedOpen)
				return false;
		}
		unlocked = 0;
		lockedClose = 0;
		lockedOpen = 0;
		for (int i =l-1;i>=0;i--){
			if (locked.charAt(i) == '0')
				unlocked++;
			else if (locked.charAt(i) == '1' && s.charAt(i) == ')')
				lockedClose++;
			else 
				lockedOpen++;
			if (lockedOpen > unlocked + lockedClose)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String s = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(";
		String locked = "100011110110011011010111100111011101111110000101001101001111";
		System.out.println(canBeValid(s, locked));
	}
}