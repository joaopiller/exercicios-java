package exercicio3.utils;

public final class Conversor {
    private Conversor() {}

    public static double celsiusParaFahrenheit(double c) {
        return c * 9.0/5 + 32;
    }

    public static double fahrenheitParaCelsius(double f) {
        return (f - 32) * 5.0/9;
    }

    public static double kmParaMilhas(double km) {
        return km * 0.621371;
    }

    public static double kgParaLibras(double kg) {
        return kg * 2.20462;
    }

    public static double metrosParaPes(double m) {
        return m * 3.28084;
    }
}