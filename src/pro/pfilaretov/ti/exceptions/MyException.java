package pro.pfilaretov.ti.exceptions;

/**
 *
 */
public class MyException
{
    public MyException()
    {
        new Exception().printStackTrace();
    }
}

class A
{
    public A()
    {
        MyException e = new MyException();
    }
}

class B
{
    public B()
    {
        A a = new A();
    }

    public void doSomething()
    {
        System.out.println("Done");
    }

    public static void main(String[] args)
    {
        B b = new B();
        b.doSomething();
    }
}