package ru.pfilaretov.ti.exceptions;

/**
 * Check which exception is thrown and which one is suppressed
 */
public class TryCatchFinallySuppress
{
    public static void main(String[] args)
    {
        try
        {
            run();
        }
        catch (Exception e)
        {
            System.err.println("=== GOT IT! ===");
            printExceptionInfo(e);
        }
    }

    private static void run()
    {
        try
        {
            System.err.println("1");

            if (true)
            {
                throw new RuntimeException("Oops_try");
            }

            System.err.println("2");
        }
        /*catch (Exception e)
        {
            System.err.println("3");
            printExceptionInfo(e);

//            if (true)
//            {
//                throw new RuntimeException("Oops_catch");
//            }

            System.err.println("4");

        }*/
        finally
        {
            System.err.println("5");

            if (true)
            {
                throw new RuntimeException("Oops_finally");
            }

            System.err.println("6");
        }
    }

    private static void printExceptionInfo(Throwable t)
    {
        t.printStackTrace();

        Throwable[] suppressed = t.getSuppressed();
        if (suppressed != null && suppressed.length > 0)
        {
            for (Throwable s : suppressed)
            {
                System.err.println("Suppressed: ");
                s.printStackTrace();
            }
        }
    }
}
