package com.example.calculadoradegrados.conversiones;

public class Celsius extends Grados {

    public Celsius(double cantidad) {

        super(cantidad);
    }

    @Override
    public Grados parse(String unidadDestino) {
        switch (unidadDestino.toLowerCase()) {
            case "fahrenheit":
                return new Fahrenheit((getCantidad() * 9 / 5) + 32);
            case "kelvin":
                return new Kelvin(getCantidad() + 273.15);
            default:
                return null;
        }
    }
}
