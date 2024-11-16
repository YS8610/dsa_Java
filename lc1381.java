public class lc1381 {
  
	int[] stack;
	int pos;

	public lc1381(int maxSize) {
		pos = 0;
		stack = new int[maxSize];
	}
	
	public void push(int x) {
		if (pos < stack.length){
			stack[pos] = x;
			pos++;
		}
	}
	
	public int pop() {
		if (pos == 0) return -1;
		pos--;
		return stack[pos];
	}
	
	public void increment(int k, int val) {
		for (int i=0, n = Math.min(pos,k); i < n; i++){
			stack[i] += val;
		}
	}
}
