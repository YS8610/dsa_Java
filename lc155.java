import java.util.LinkedList;
import java.util.PriorityQueue;

public class lc155 {
  LinkedList<Integer> stack;
  PriorityQueue<Integer> q;

  public lc155(){
    this.q = new PriorityQueue<>();
    this.stack = new LinkedList<>();
  }

  public void push(int val) {
    this.q.offer(val);
    this.stack.offerLast(val);
  }
  
  public void pop() {
    int a = this.stack.removeLast();
    this.q.remove(a);
  }
  
  public int top() {
    return this.stack.peekLast();
  }
  
  public int getMin() {
    
    return this.q.peek();
  }

  public static void main(String[] args) {
    
  }
}
