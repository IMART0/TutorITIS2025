package am.martirosyan.many_threads;

class Task2 extends Thread {
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
    public static void main(String[] args) {
        new Task2().start();
        new Task2().start();
        new Task2().start();
    }
}