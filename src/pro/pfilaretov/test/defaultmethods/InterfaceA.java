package pro.pfilaretov.test.defaultmethods;

public interface InterfaceA {

    default void doSomething() {
        System.out.println(this.getClass().getName() + ".doSomething()");
    }
}
