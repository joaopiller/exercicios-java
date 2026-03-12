package exercicio10;

import exercicio10.entities.Circle;
import exercicio10.entities.Rectangle;
import exercicio10.enums.Color;
import exercicio10.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Shape> shapeList = new ArrayList<>();

        IO.print("Quantas formas serão inseridas? ");
        int shapeNum = sc.nextInt();

        for (int i = 0; shapeNum > i; i++) {
            IO.print("\nQual será o tipo da forma #" + (i+1) + " (circulo/retangulo)? ");
            String type = sc.next();
            switch (type) {
                case "circulo":
                    IO.print("Informe o raio do círulo: ");
                    double radius = sc.nextDouble();
                    IO.print("Informe a cor do círculo (azul/verde/vermelho): ");
                    Color color = Color.valueOf(sc.next().toUpperCase());
                    shapeList.add(new Circle(color, radius));
                    break;
                case "retangulo":
                    IO.print("Informe a largura do retângulo: ");
                    double largura = sc.nextDouble();
                    IO.print("Informe a altura do retângulo: ");
                    double altura = sc.nextDouble();
                    shapeList.add(new Rectangle(altura, largura));
                    break;
                default:
                    IO.println("Insira uma forma válida!");
                    i--;
            }
        }

        for (Shape shape : shapeList) {
            IO.println(String.format("%.2f", shape.area()));
            if (shape instanceof Circle c) {
                IO.println(c.getColor().toString().toLowerCase());
            }
        }
    }
}
