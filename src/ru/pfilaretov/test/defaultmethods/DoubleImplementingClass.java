package ru.pfilaretov.test.defaultmethods;

public class DoubleImplementingClass implements InterfaceA, InterfaceB {

    /**
     * Must override the default method inherited from both interfaces
     */
    @Override
    public void doSomething() {

    }
}
