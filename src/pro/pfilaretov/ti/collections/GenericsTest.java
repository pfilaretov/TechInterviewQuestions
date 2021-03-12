package pro.pfilaretov.ti.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class GenericsTest {

    public static void main(String[] args) {
        // 1. ? extends Food

        List<? extends Food> foods = new ArrayList<>();
//        foods.add(new Food("Food"));
//        foods.add(new Fruit("Fruit"));
//        foods.add(new Apple("Apple"));

        // 1.1 How to add something to foods?
//        List<? extends Food> foods = Arrays.asList(new Food("Food"), new Fruit("Fruit"), new Apple("Apple"));
        List cast = (List) foods;
        cast.add(new Food("Food"));
        cast.add(new Fruit("Fruit"));
        System.out.println("foods: " + foods);

        // 1.2 Can we get something from foods? And if so what can we get?
        Food food = foods.get(0);
//        Fruit fruit = foods.get(1); // compilation error
        Fruit fruit = (Fruit) foods.get(1);

        // 1.3 Sort foods
//        Collections.sort(foods); // compile error, or need to implement Comparable in Food class

        foods.sort(Comparator.comparing(Food::getName));
        System.out.println("foods: " + foods);

        // 2. ? super Apple
        List<? super Apple> things = new ArrayList<>();
//        things.add(new Food("Food")); // compilation error
//        things.add(new Fruit("Fruit")); // compilation error
        things.add(new Apple("Apple"));

        // 2.2 Can we get something from foods? And if so what can we get?
//        Apple apple2 = things.get(0); // compilation error
//        Fruit fruit2 = things.get(0); // compilation error
//        Food food2 = things.get(0); // compilation error
        Object object = things.get(0);

        // TODO - 2.3 Sort things
//        Collections.sort(things, (o1, o2) -> o1.get);
//        things.sort(Comparator.comparing(Food::getName));

    }
}

class Food {

    protected final String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Fruit extends Food {

    public Fruit(String name) {
        super(name);
    }
}

class Apple extends Fruit {

    public Apple(String name) {
        super(name);
    }
}
/*

interface MessageServiceDAO {
    List<Message> loadAll();
    Message load(Long id);
    void remove(Long id);
    void save(Message message);
    void saveAll(List<Message> messages);
}*/
