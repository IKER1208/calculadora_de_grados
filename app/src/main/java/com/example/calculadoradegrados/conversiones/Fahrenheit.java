package com.example.calculadoradegrados.conversiones;

public class Fahrenheit extends Grados {

    public Fahrenheit(double cantidad) {
        super(cantidad);
    }

    @Override
    public Grados parse(String unidadDestino) {
        switch (unidadDestino.toLowerCase()) {
            case "celsius":
                return new Celsius((getCantidad() - 32) * 5 / 9);
            case "kelvin":
                return new Kelvin((getCantidad() - 32) * 5 / 9 + 273.15);
            default:
                return null;
        }
    }
}
