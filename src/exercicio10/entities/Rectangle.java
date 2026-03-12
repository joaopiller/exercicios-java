package exercicio10.entities;

import exercicio10.interfaces.Shape;

public class Rectangle implements Shape {
    // o Rectangle é uma forma não colorida
    private double altura;
    private double largura;

    public Rectangle(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    @Override
    public double area() {
        return altura * largura;
    }
}
