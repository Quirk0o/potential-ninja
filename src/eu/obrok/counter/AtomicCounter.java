package eu.obrok.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Incrementable {

  private AtomicInteger count;

  public AtomicCounter(int initialValue) {
    this.count = new AtomicInteger(initialValue);
  }

  @Override
  public void inc() {
    count.incrementAndGet();
  }

  @Override
  public void dec() {
    count.decrementAndGet();
  }

  @Override
  public int getCount() {
    return count.get();
  }
}
