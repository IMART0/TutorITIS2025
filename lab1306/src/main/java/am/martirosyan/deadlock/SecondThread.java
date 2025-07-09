package am.martirosyan.deadlock;

public class SecondThread extends Thread{
    @Override
    public void run() {
        synchronized (Task5.lock2) {
            System.out.println("SecondThread заблокировал lock2");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Task5.lock1) {
                System.out.println("SecondThread заблокировал lock1");
            }
        }
    }
}
