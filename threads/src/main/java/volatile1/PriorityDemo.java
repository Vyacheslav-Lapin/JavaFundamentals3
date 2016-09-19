package volatile1;

public class PriorityDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Clicker hi = new Clicker();
        Clicker lo = new Clicker();

        hi.setPriority(Thread.NORM_PRIORITY + 2);
        lo.setPriority(Thread.NORM_PRIORITY - 2);

        hi.start();
        lo.start();

        Thread.sleep(50);

        lo.stopClick();
        hi.stopClick();

        hi.join();
        lo.join();

        System.out.println("Low-priority thread: " + lo.click);
        System.out.println("High-priority thread: " + hi.click);
    }

}