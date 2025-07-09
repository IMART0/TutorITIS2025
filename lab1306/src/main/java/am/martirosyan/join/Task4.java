package am.martirosyan.join;

class Task4 extends Thread {
    private int result;
    public void run() {
        for (int i = 1; i <= 100; i++) result += i;
    }
    public int getResult() { return result; }

    public static void main(String[] args) throws InterruptedException {
        Task4 t = new Task4();
        t.start();
        t.join(); // дождаться завершения
//        Thread.sleep(1);
        System.out.println("Sum: " + t.getResult());
    }
}