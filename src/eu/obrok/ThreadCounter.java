package eu.obrok;

public class ThreadCounter {

  private static int count = 0;

  private static synchronized void add() {
    count++;
    System.out.println("New thread #" + count);
  }

  public static void main(String[] argv){

    while (true) {
      new Thread(() -> {
        add();

        while (true) {
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
            System.err.println(e);
          }
        }
      }).start();
    }
  }
}
