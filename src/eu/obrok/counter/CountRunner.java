package eu.obrok.counter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CountRunner {

  int it;
  CounterFactory counterFactory = CounterFactory.getInstance();
  Increaser i;
  Decreaser d;

  public CountRunner(int iterations) {
    this.it = iterations;
    i = new Increaser(it);
    d = new Decreaser(it);
  }

  private void setCounter(Incrementable counter) {
    this.i.setCounter(counter);
    this.d.setCounter(counter);
  }

  private void run() {
    Thread a = new Thread(i);
    Thread b = new Thread(d);
    a.start(); b.start();

    try {
      a.join(); b.join();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void test() {

    for (CounterFactory.CounterType type : CounterFactory.CounterType.values()) {

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(type + ".log"))) {

        for (int it = 0; it < 100; it++) {
          double start = System.currentTimeMillis();
          Incrementable c = counterFactory.getCounter(type);
          setCounter(c);
          run();

          writer.write(String.format("%d\t\t%f\n", c.getCount(), System.currentTimeMillis() - start));
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
