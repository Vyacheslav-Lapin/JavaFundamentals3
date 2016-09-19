package groups;

public class MyThread extends Thread {

    public MyThread(String threadName, ThreadGroup tgOb) {
        super(tgOb, threadName);
        System.out.println("New thread: " + this);
        start();
    }

    public void run() {

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1_000);
            }
        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }
        System.out.println(getName() + " exiting.");
    }
}