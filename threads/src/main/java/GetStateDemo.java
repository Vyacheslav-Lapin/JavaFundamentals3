import lombok.SneakyThrows;

public class GetStateDemo implements Runnable {

    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " " + thread.getState());
    }

    @SneakyThrows
    public static void main(String args[]) {
        Thread thread = new Thread(new GetStateDemo());
        System.out.println(thread.getName() + " " + thread.getState());

        thread.start();
        System.out.println(thread.getName() + " " + thread.getState());

        Thread.sleep(1_000);

        System.out.println(thread.getName() + " " + thread.getState());
        thread.join();
        System.out.println(thread.getName() + " " + thread.getState());
    }
}
