package ru.pfilaretov.ti.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * The task to calculate Fibonacci numbers
 */
public class FibonacciTask extends RecursiveTask<Integer>
{
    private int n;

    public FibonacciTask(int n)
    {
        this.n = n;
    }

    @Override
    protected Integer compute()
    {
//        printPoolDetails();

        if (n <= 1)
        {
            return n;
        }

        FibonacciTask f1 = new FibonacciTask(n - 1);
        f1.fork();

        FibonacciTask f2 = new FibonacciTask(n - 2);
        return f2.compute() + f1.join();
    }

    private void printPoolDetails()
    {
        int parallelism = getPool().getParallelism();
        int poolSize = getPool().getPoolSize();
        int activeThreads = getPool().getActiveThreadCount();
        int runningThreads = getPool().getRunningThreadCount();
        int queuedSubmissions = getPool().getQueuedSubmissionCount();
        long queuedTasks = getPool().getQueuedTaskCount();
        long steals = getPool().getStealCount();

        System.out.println(
                "parallelism=" + parallelism +
                ", poolSize=" + poolSize +
                ", activeThreads=" + activeThreads +
                ", runningThreads=" + runningThreads +
                ", queuedSubmissions=" + queuedSubmissions +
                ", queuedTasks=" + queuedTasks +
                ", steals=" + steals);
    }

    public static void main(String[] args) {
        int n = 20;
        ForkJoinTask<Integer> task = new FibonacciTask(n);

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        Integer result = task.join();
        System.out.println("Fibonacci(" + n + ") = " + result);

        pool.shutdown();
    }
}
