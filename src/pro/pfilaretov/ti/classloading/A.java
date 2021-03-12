package pro.pfilaretov.ti.classloading;


class A {
    static {
        System.out.println("A static block");
    }

    public A() {
        System.out.println("A constructor");
    }
}

class B extends A {
    static {
        System.out.println("B static block");
    }

    {
        System.out.println("B instance block");
    }
}

class C extends B {
    {
        System.out.println("C instance block");
    }

    public C() {
        System.out.println("C constructor");
    }

    public void doSomeStuff() {
        System.out.println("Working...");
    }

    public static void main(String args[]) {
        System.out.println("Starting...");
        C c = new C();
        c.doSomeStuff();
        System.out.println("Done");
    }
}
