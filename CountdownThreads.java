class CountdownThread extends Thread {
private final int start;
private final String threadName;
public CountdownThread(String name, int start) {
this.threadName = name;
this.start = start;
}
@Override
public void run() {
synchronized(System.out) {
System.out.print("Start " + threadName + ": ");
for (int i = start; i >= 1; i--) {
System.out.print(i + " ");
}
System.out.println("End");
}
}
}
public class CountdownThreads {
public static void main(String[] args) {
Thread thread1 = new CountdownThread("thread_1", 15);
Thread thread2 = new CountdownThread("thread_2", 10);
Thread thread3 = new CountdownThread("thread_3", 5);
thread1.start();
thread2.start();
thread3.start();
}
}
