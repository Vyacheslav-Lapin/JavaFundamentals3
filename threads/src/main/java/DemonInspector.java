public class DemonInspector {
    public static void main(String[] args) {
        System.out.println("Start main thread.");
        Thread daemon = new Thread(() -> {

            Thread notDemon = new Thread(() -> {
                try {
                    System.out.println("Демон? - " + Thread.currentThread().isDaemon());
                    Thread.sleep(6_666);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("А я - не ДЕМОН!!!");
            });
            notDemon.setDaemon(false);
            notDemon.start();

            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End main thread.");
    }
}
