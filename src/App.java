import java.text.DecimalFormat;

public class App {

  public static void main(String[] args) {
    timeRunnable(
      "someAction",
      () -> someAction()
    );
  }

  static void someAction() {
    sleep(1000);
  }

  static void log(Object message) {
    System.out.println(message);
  }

  static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static String formatDecimal(final long number) {
    return new DecimalFormat("0.00").format((double) number / 1_000_000_000);
  }

  static void timeRunnable(String name, Runnable runnable) {
    log(String.format("Started %s", name));
    final long startTime = System.nanoTime();
    runnable.run();
    final long endTime = System.nanoTime();
    final long duration = endTime - startTime;
    log(String.format("Completed %s in %s second(s)", name, formatDecimal(duration)));
  }

}
