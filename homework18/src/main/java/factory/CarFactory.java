package factory;

public class CarFactory implements Factory<Car>{

    @Override
    public Car build(String type) {
        return switch (type) {
            case ("BMW") -> new BMW();
            case ("Toyota") -> new Toyota();
            default -> new Car();
        };
    }
}
