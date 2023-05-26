package factory;

public class FurnitureFactory implements Factory<Furniture>{

    public Furniture build(String type) {

        return switch (type) {
            case ("Chair") -> new Chair();
            case ("Table") -> new Table();
            case ("Sofa") -> new Sofa();
            default -> new Furniture();
        };
    }
}
