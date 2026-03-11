package exercicio7.entities;

import exercicio7.interfaces.Forma;

public class Triangulo implements Forma {
    private double ladoUm, ladoDois, ladoTres;

    public Triangulo(double ladoUm, double ladoDois, double ladoTres) {
        this.ladoUm = ladoUm;
        this.ladoDois = ladoDois;
        this.ladoTres = ladoTres;
    }

    public double getLadoUm() {
        return ladoUm;
    }

    public void setLadoUm(double ladoUm) {
        this.ladoUm = ladoUm;
    }

    public double getLadoDois() {
        return ladoDois;
    }

    public void setLadoDois(double ladoDois) {
        this.ladoDois = ladoDois;
    }

    public double getLadoTres() {
        return ladoTres;
    }

    public void setLadoTres(double ladoTres) {
        this.ladoTres = ladoTres;
    }

    @Override
    public double area() {
        double s = (ladoUm + ladoDois + ladoTres) / 2;
        return Math.sqrt(s * (s - ladoUm) * (s - ladoDois) * (s - ladoTres));
    }

    @Override
    public double perimetro() {
        return ladoUm + ladoDois + ladoTres;
    }
}
