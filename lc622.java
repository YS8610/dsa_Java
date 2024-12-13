import java.util.Arrays;

public class lc622 {

  int[] q;
  int head;
  int tail;
  int size;

  public lc622(int k) {
    q = new int[k];
    Arrays.fill(q, -1);
    size = 0;
    head = 0;
    tail = 0;
  }

  public boolean enQueue(int value) {
    if (size >= q.length) return false;
    if (size == 0)
      q[tail] = value;
    else{
      tail = (tail + 1)%q.length;
      q[tail] = value;
    }
    size++;
    return true;
  }

  public boolean deQueue() {
    if (size < 1 ) return false;
    if (size==1)
      q[head] = -1;
    else{
      q[head] = -1;
      head = (head + 1)%q.length;
    }
    size--;
    return true;
  }

  public int Front() {
    return q[head];
  }

  public int Rear() {
    return q[tail];
  }

  public boolean isEmpty() {
    return size==0;
  }

  public boolean isFull() {
    return size >= q.length;
  }

  public static void main(String[] args) {
    lc622 myCircularQueue = new lc622(3);
    System.out.println(myCircularQueue.enQueue(1)); // return True
    System.out.println(myCircularQueue.enQueue(2)); // return True
    System.out.println(myCircularQueue.enQueue(3)); // return True
    System.out.println(myCircularQueue.enQueue(4)); // return False
    System.out.println(myCircularQueue.Rear());     // return 3
    System.out.println(myCircularQueue.isFull());   // return True
    System.out.println(myCircularQueue.deQueue());  // return True
    System.out.println(myCircularQueue.enQueue(4)); // return True
    System.out.println(myCircularQueue.Rear());     // return 4
    System.out.println(myCircularQueue.enQueue(5)); // return True
  }
}
