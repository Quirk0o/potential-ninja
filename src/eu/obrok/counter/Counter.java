package eu.obrok.counter;

public class Counter implements Incrementable {

  private int count;

  public Counter(int initialValue) {
    this.count = initialValue;
  }

  @Override
  public void inc() {
    count++;
  }

  @Override
  public void dec() {
    count--;
  }

  @Override
  public int getCount() {
    return count;
  }
}
