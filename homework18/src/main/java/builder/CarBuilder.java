package builder;

public class CarBuilder {
    private String engine;
    private String wheels;
    private String body;

    public CarBuilder() {
    }

    public CarBuilder engine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder wheels(String wheels) {
        this.wheels = wheels;
        return this;
    }

    public CarBuilder body(String body) {
        this.body = body;
        return this;
    }

    public Car build() {
        return new Car(engine, wheels, body);
    }
}
