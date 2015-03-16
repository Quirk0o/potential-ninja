package eu.obrok.counter;

public class SynchronizedCounter extends Counter {

  public SynchronizedCounter(int initialValue) {
    super(initialValue);
  }

  @Override
  public synchronized void inc() {
    super.inc();
  }

  @Override
  public synchronized void dec() {
    super.dec();
  }

  @Override
  public synchronized int getCount() {
    return super.getCount();
  }
}
