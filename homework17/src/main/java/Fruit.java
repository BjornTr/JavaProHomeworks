import lombok.Data;

@Data
public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }
}