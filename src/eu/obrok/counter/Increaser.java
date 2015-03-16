package eu.obrok.counter;

public class Increaser implements Runnable {

  private Incrementable counter;
  private int n;

  public Increaser(int iterations) {
    this.counter = new Counter(0);
    this.n = iterations;
  }

  public Increaser(Incrementable counter, int iterations) {
    this.counter = counter;
    this.n = iterations;
  }

  public void setCounter(Incrementable counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for(int i = 0; i < n; i++) {
      counter.inc();
    }
  }
}
