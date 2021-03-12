package pro.pfilaretov.ti.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(new Integer(1));
        set1.add(new Integer(1));
        set1.add(new Integer(1));
        System.out.println(set1.size());

        Set<MyClass> set2 = new HashSet<>();
        set2.add(new MyClass(1));
        set2.add(new MyClass(1));
        set2.add(new MyClass(1));
        System.out.println(set2.size());


    }
}

class MyClass {
    private Integer i;

    // getter and setter here


    public MyClass(Integer i)
    {
        this.i = i;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MyClass myClass = (MyClass)o;

        return i.equals(myClass.i);
    }

    @Override
    public int hashCode()
    {
        return i.hashCode();
    }


}
