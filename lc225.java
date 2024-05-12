import java.util.ArrayDeque;
import java.util.Queue;

public class lc225 {

  Queue<Integer> q0;
  Queue<Integer> q1;
  boolean isQ0Default;

  public lc225() {
    this.q0 = new ArrayDeque<>();
    this.q1 = new ArrayDeque<>();
    this.isQ0Default = true;
  }

  public void push(int x) {
    int temp = 0;
    Queue<Integer> tempD;
    Queue<Integer> tempNonDefault;

    if (isQ0Default) {
      tempD = q0;
      tempNonDefault = q1;
    } else {
      tempD = q1;
      tempNonDefault = q0;
    }

    while (!tempD.isEmpty()) {
      int top = q0.poll();
      if (top == x) temp = x; else tempNonDefault.add(top);
    }
    tempNonDefault.add(temp);
    this.isQ0Default = false;
  }

  public int pop() {
    Queue<Integer> tempD;
    Queue<Integer> tempNonDefault;
    if (isQ0Default) {
      tempD = q0;
      tempNonDefault = q1;
    } else {
      tempD = q1;
      tempNonDefault = q0;
    }
    return 0;
  }

  public int top() {
    return 0;
  }

  public boolean empty() {
    return false;
  }
}
