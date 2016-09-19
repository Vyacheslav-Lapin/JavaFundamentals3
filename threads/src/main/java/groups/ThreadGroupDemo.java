package groups;

import lombok.extern.java.Log;

@Log
public class ThreadGroupDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        new MyThread("One", groupA);
        new MyThread("Two", groupA);
        new MyThread("Three", groupB);
        new MyThread("Four", groupB);

        Thread.sleep(2_500);

        groupA.interrupt();
    }
}
