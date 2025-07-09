package am.martirosyan.deadlock;

public class FirstThread extends Thread {
    @Override
    public void run() {
        ///
        ///
        ///
        //

        synchronized (Task5.lock1) {
            System.out.println("FirstThread заблокировал lock1");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Task5.lock2) {
                System.out.println("FirstThread заблокировал lock2");
            }
        }
    }
}
