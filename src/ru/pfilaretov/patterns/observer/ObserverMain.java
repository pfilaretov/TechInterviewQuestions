package ru.pfilaretov.patterns.observer;

/**
 * Main class for Observer pattern
 * https://refactoring.guru/design-patterns/observer
 */
public class ObserverMain {
    public static void main(String[] args) throws InterruptedException {
        NewspaperPublisher publisher = new NewspaperPublisher();

        System.out.println("Publisher is ready");


        Subscriber john = new HumanSubscriber("John Smith");
        publisher.addSubscriber(john, Newspaper.EXTRA_BALT);
        publisher.addSubscriber(john, Newspaper.DAILY_POST);

        Subscriber annie = new HumanSubscriber("Annie Lou");
        publisher.addSubscriber(annie, Newspaper.DAILY_POST);
        publisher.addSubscriber(annie, Newspaper.METRO);

        System.out.println("Subscribers are ready");
        Thread.sleep(3000);

        System.out.println("Issuing " + Newspaper.EXTRA_BALT + "...");
        publisher.newIssueIsReady(Newspaper.EXTRA_BALT);
        Thread.sleep(3000);

        System.out.println("Issuing " + Newspaper.DAILY_POST + "...");
        publisher.newIssueIsReady(Newspaper.DAILY_POST);
        Thread.sleep(3000);

        System.out.println("Issuing " + Newspaper.METRO + "...");
        publisher.newIssueIsReady(Newspaper.METRO);
    }
}
