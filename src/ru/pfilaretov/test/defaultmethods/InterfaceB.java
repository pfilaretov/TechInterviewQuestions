package ru.pfilaretov.test.defaultmethods;

public interface InterfaceB {

    default void doSomething() {
        System.out.println(this.getClass().getName() + ".doSomething()");
    }
}
