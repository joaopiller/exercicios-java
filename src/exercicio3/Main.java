package exercicio3;

import exercicio3.utils.Conversor;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        IO.print("Insira um valor em celcius: ");
        double celcius = sc.nextDouble();
        IO.println(String.format("%.2f", celcius) + "°C = " + String.format("%.2f", Conversor.celsiusParaFahrenheit(celcius)) + "°F");

        IO.print("Insira um valor em quilometros: ");
        double km = sc.nextDouble();
        IO.println(String.format("%.2f", km) + "km = " + String.format("%.2f", Conversor.kmParaMilhas(km)) + " milhas");
    }
}
