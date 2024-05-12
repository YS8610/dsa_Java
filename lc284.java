import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class lc284 implements Iterator<Integer>{

  List<Integer> list;
  int counter;
  
  public lc284(Iterator<Integer> iterator)  {
    // initialize any member here.
    this.counter = 0;
    this.list = new ArrayList<>();
    iterator.forEachRemaining(this.list::add);
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return this.list.get(this.counter);
  }

// hasNext() and next() should behave the same as in the Iterator interface.
// Override them if needed.
  @Override
  public Integer next() {
    this.counter++;
    return this.list.get(this.counter-1);
  }

  @Override
  public boolean hasNext() {
    if (this.counter>=this.list.size()) return false;
    return true;

  }
}