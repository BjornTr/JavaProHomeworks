package Homework5.geometricalfigures;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<GeometricFigure> figures = new ArrayList<>();
        figures.add(new Circle(5));
        figures.add(new Triangle(6, 8));
        figures.add(new Square(7));

        printAreas(figures);

    }

    public static void printAreas(List<GeometricFigure> figures) {
        for (GeometricFigure figure : figures) {
            double area = figure.getArea();
            System.out.println("Area of " + figure.getClass().getSimpleName() + ": " + area);
        }
    }
}
