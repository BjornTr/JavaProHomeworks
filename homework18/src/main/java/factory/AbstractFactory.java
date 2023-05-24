package factory;

public class AbstractFactory {
    public Factory<?> getFactory(String type) {
        return switch (type) {
            case "furniture" -> new FurnitureFactory();
            case "car" -> new CarFactory();
            default -> throw new IllegalArgumentException("Invalid factory type: " + type);
        };
    }
}
