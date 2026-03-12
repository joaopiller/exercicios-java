package exercicio10.entities;

import exercicio10.enums.Color;
import exercicio10.interfaces.Shape;

public abstract class ColoredShape implements Shape {
    private Color color;

    public ColoredShape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
