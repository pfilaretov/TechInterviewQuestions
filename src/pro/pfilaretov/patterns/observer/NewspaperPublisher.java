package pro.pfilaretov.patterns.observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class NewspaperPublisher {

    private Map<Subscriber, Set<Newspaper>> subscribersMap;

    public NewspaperPublisher() {
        subscribersMap = new HashMap<>();
    }

    public void addSubscriber(Subscriber subscriber, Newspaper newspaper) {
        Set<Newspaper> newspapers = subscribersMap.get(subscriber);
        if (newspapers == null) {
            newspapers = new HashSet<>();
        }

        newspapers.add(newspaper);
        subscribersMap.put(subscriber, newspapers);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribersMap.remove(subscriber);
    }

    /**
     * A new issue of the Newspaper is ready
     */
    public void newIssueIsReady(Newspaper newspaper) {
        subscribersMap.entrySet().forEach(entry -> {
            Set<Newspaper> subscriptions = entry.getValue();
            if (subscriptions.contains(newspaper)) {
                Subscriber subscriber = entry.getKey();
                subscriber.update(newspaper);
            }
        });
    }
}
