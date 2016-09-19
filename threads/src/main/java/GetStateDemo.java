public class GetStateDemo implements Runnable{

    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " " + thread.getState());
    }

//    @SneakyThrows
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(new GetStateDemo());
        System.out.println(thread.getName() + " " + thread.getState());

        thread.start();
        System.out.println(thread.getName() + " " + thread.getState());

        try {
            Thread.sleep(1_000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(thread.getName() + " " + thread.getState());
        thread.join();
        System.out.println(thread.getName() + " " + thread.getState());
    }
}
