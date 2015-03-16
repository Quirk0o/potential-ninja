package eu.obrok;

import eu.obrok.counter.CountRunner;

public class Main {

  public static void main(String[] args) {

    int N = 1000000;

    CountRunner runner = new CountRunner(N);
    runner.test();
  }
}
