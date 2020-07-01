package ru.pfilaretov.test.env;

/**
 *
 */
public class TestEnvVar
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.err.println("provide an env var name");
            System.exit(1);
        }

        String var = args[0];
        String value = System.getenv(var);
        System.out.println(var + " = " + value);

        System.out.println("All env vars:");
        System.out.println(System.getenv());
    }
}
