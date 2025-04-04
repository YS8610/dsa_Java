class lc2579 {
    static public long coloredCells(int n) {
        if (n==1) return 1;
        if (n==2) return 5;
        long base = n*2-1;
        for (long i=base-2; i> 0;i-=2)
            base+= i<<1;
        return base;
    }
	
	public static void main(String[] args){
		int n =2;
		System.out.println(coloredCells(n));
	}
}