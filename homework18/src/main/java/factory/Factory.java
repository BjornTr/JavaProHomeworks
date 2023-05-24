package factory;

public interface Factory<T> {
    T build(String type);
}
