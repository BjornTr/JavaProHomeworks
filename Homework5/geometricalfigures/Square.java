package Homework5.geometricalfigures;

public class Square implements GeometricFigure {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
