package am.martirosyan.run_and_start_different;

class Task1 extends Thread {

    // !!!ФУНКЦИОНАЛЬНОСТЬ!!!
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ": " + i);
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        }
    }

    public static void main(String[] args) {
        Task1 t = new Task1();

        t.start();   // последовательно, НЕ создаёт новый поток
        t.start();   // последовательно, НЕ создаёт новый поток
        t.start();   // последовательно, НЕ создаёт новый поток
        t.start();   // последовательно, НЕ создаёт новый поток

//        t.start(); // создаёт новый поток
    }
}