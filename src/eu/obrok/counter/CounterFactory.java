package eu.obrok.counter;

public class CounterFactory {

  public enum CounterType {
    DEFAULT, SYNCHRONIZED, ATOMIC;

    @Override
    public String toString() {
      return this.name().toLowerCase();
    }
  }

  private static CounterFactory instance = new CounterFactory();

  public static CounterFactory getInstance() {
    return instance;
  }

  private CounterFactory() {
  }

  public Incrementable getCounter(CounterType type) {
    switch (type) {
      case DEFAULT:
        return new Counter(0);
      case ATOMIC:
        return new AtomicCounter(0);
      case SYNCHRONIZED:
        return new SynchronizedCounter(0);
      default:
        return null;
    }
  }
}
