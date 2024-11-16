public class lc641 {
  int maxsize;
  int size;
  ListNode a;
  ListNode head;
  ListNode tail;

  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

  public lc641(int k) {
    this.maxsize = k;
    this.size = 0;
    head = null;
    tail = null;
    a = null;
  }
  
  public boolean insertFront(int value) {
    if (size== 0){
      a = new ListNode(value);
      head = a;
      tail = a;
      size++;
      return true;
    }
    if (size < maxsize){
      ListNode front = new ListNode(value);
      front.next = head;
      head = front;
      size++;
      return true;
    }
    return false;
  }
  
  public boolean insertLast(int value) {
    if (size== 0){
      a = new ListNode(value);
      head = a;
      tail = a;
      size++;
      return true;
    }
    if (size < maxsize){
      ListNode back = new ListNode(value);
      tail.next = back;
      tail = back;
      size++;
      return true;
    }
    return false;
  }
  
  public boolean deleteFront() {
    if (size == 0) return false;
    if (size == 1){
      head = null;
      tail = null;
      size--;
      return true;
    }
    ListNode cp = head;
    ListNode np = head.next;
    cp.next = null;
    head = np;
    size--;
    return true;
  }
  
  public boolean deleteLast() {
    if (size == 0) return false;
    if (size == 1){
      head = null;
      tail = null;
      size--;
      return true;
    }
    ListNode cp = head;
    while (cp !=null){
      if (cp.next == tail) break;
      cp = cp.next;
    }
    if (cp !=null) cp.next = null;
    tail = cp;
    size--;
    return true;
  }
  
  public int getFront() {
    if (head != null) return head.val;
    return -1;
  }
  
  public int getRear() {
    if (tail !=null) return tail.val;
    return -1;
  }
  
  public boolean isEmpty() {
    if (size==0) return true;
    return false;
  }
  
  public boolean isFull() {
    if (size < maxsize) return false;
    return true;
  }
}
