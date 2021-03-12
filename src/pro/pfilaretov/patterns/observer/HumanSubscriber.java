package pro.pfilaretov.patterns.observer;

/**
 *
 */
public class HumanSubscriber implements Subscriber {

    private String name;

    public HumanSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Newspaper newspaper) {
        System.out.println(name + " received " + newspaper + " newspaper");
    }
}
