package exercicio17;

import exercicio17.entities.Circle;
import exercicio17.entities.Rectangle;
import exercicio17.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));

        IO.println("Total area: " + totalArea(myCircles));
    }

    // o extends permite o get na lista, mas não permite o put
    // a lista é de Shape ou qualquer subtipo de Shape
    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}
