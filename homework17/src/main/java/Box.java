import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        if (fruits.isEmpty() || fruit.getClass().equals(fruits.get(0).getClass())) {
            fruits.add(fruit);
        } else {
            throw new IllegalArgumentException("Cannot add fruits of different types to the same box");
        }
    }

    public void addFruits(List<T> fruits) {
        for (T fruit : fruits) {
            addFruit(fruit);
        }
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        if (fruits.isEmpty() && otherBox.fruits.isEmpty()) {
            return true;
        } else if (fruits.isEmpty() || otherBox.fruits.isEmpty()) {
            return false;
        } else {
            return fruits.get(0).getClass().equals(otherBox.fruits.get(0).getClass()) &&
                    Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
        }
    }


    public void merge(Box<T> otherBox) {
        if (this == otherBox) {
            return;
        }

        if (fruits.isEmpty() || otherBox.fruits.isEmpty()) {
            fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else if (fruits.get(0).getClass().equals(otherBox.fruits.get(0).getClass())) {
            fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else {
            throw new IllegalArgumentException("Cannot merge boxes with fruits of different types");
        }
    }
}
