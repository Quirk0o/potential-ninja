package eu.obrok;

import eu.obrok.counter.CounterFactory;
import eu.obrok.counter.CounterFactory.CounterType;
import eu.obrok.counter.Decreaser;
import eu.obrok.counter.Increaser;
import eu.obrok.counter.Incrementable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

    int N = 1000000;
    double start;

    Increaser i = new Increaser(N);
    Decreaser d = new Decreaser(N);
    CounterFactory counterFactory = CounterFactory.getInstance();

    for (CounterType type : CounterType.values()) {

      Incrementable c = counterFactory.getCounter(type);

      System.out.println("Using " + type + " counter.");
      start = System.currentTimeMillis();

      i.setCounter(c);
      d.setCounter(c);
      Thread a = new Thread(i);
      Thread b = new Thread(d);
      a.start();
      b.start();

      try {
        a.join();
        b.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(String.format("Count: %d\nTime: %f", c.getCount(), (System.currentTimeMillis()) - start));
    }
  }
}
