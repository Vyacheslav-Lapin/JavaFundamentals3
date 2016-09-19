import lombok.extern.java.Log;
import lombok.val;

@Log
public class SimpleThreadDemo {
    public static void main(String[] args) {

        val walking = new Thread(() -> {
            try {
                for (int i = 0; i < 8; i++) {
                    log.info("Walking");
                    Thread.sleep(400); // 0.4 seconds
                }
            } catch (InterruptedException e) {
                log.warning(() -> Thread.currentThread() + " was interrupted!");
            }
        });

        val talking = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 8; i++) {
                        log.info("Talking");
                        Thread.sleep(400); // 0.4 seconds
                    }
                } catch (InterruptedException e) {
                    log.warning(() -> Thread.currentThread() + " was interrupted!");
                }
            }
        };

        walking.start();
        talking.start();
    }
}