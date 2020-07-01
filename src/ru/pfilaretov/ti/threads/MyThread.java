package ru.pfilaretov.ti.threads;

public class MyThread extends Thread {
    @Override
    public void run()
    {
        System.out.println(getName() + ": running");
    }

    public static void main(String[] args) throws InterruptedException
    {
        MyThread thread = new MyThread();
        thread.start();

        System.out.println(Thread.currentThread().getName() + ": waiting...");
        thread.join();
        System.out.println(Thread.currentThread().getName() + ": done");
    }
}
