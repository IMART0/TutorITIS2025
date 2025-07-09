package am.martirosyan.sleep;

class Task3 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " iteration " + i);
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
    }
    public static void main(String[] args) {
        new Task3().start();
    }
}