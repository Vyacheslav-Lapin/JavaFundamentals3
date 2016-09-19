import lombok.SneakyThrows;

public class CurrentThreadDemo {

    @SneakyThrows
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток: " + t);
        t.setName("My Thread");
        System.out.println("После изменения имени: " + t);
        for (int n = 5; n > 0; n--) {
            System.out.println(n);
            Thread.sleep(1000);
        }
    }
}