import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BoxTest {
    @Test
    public void testToList() {
        Integer[] array = {1, 2, 3};
        List<Integer> list = Arrays.asList(array);
        Assertions.assertEquals(Arrays.asList(1, 2, 3), list);
    }

    @Test
    public void testAddFruits() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> appleBox = new Box<>();
        List<Apple> appleList = Arrays.asList(apple1, apple2);
        appleBox.addFruits(appleList);

        Box<Orange> orangeBox = new Box<>();
        List<Orange> orangeList = Arrays.asList(orange1, orange2);
        orangeBox.addFruits(orangeList);

        Assertions.assertEquals(2.0f, appleBox.getWeight());
        Assertions.assertEquals(3.0f, orangeBox.getWeight());
    }


    @Test
    public void testBoxOperations() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(apple1);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange);

        Assertions.assertEquals(2.0f, appleBox1.getWeight(), 0.0001f);
        Assertions.assertEquals(1.0f, appleBox2.getWeight(), 0.0001f);
        Assertions.assertEquals(1.5f, orangeBox.getWeight(), 0.0001f);

        Assertions.assertFalse(appleBox1.compare(appleBox2));
        Assertions.assertFalse(appleBox1.compare(orangeBox));

        appleBox1.merge(appleBox2);
        Assertions.assertEquals(3.0f, appleBox1.getWeight(), 0.0001f);
    }

}
