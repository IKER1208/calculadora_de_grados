package com.example.calculadoradegrados.conversiones;

public class Kelvin extends Grados {

    public Kelvin(double cantidad) {
        super(cantidad);
    }

    @Override
    public Grados parse(String unidadDestino) {
        switch (unidadDestino.toLowerCase()) {
            case "celsius":
                return new Celsius(getCantidad() - 273.15);
            case "fahrenheit":
                return new Fahrenheit((getCantidad() - 273.15) * 9 / 5 + 32);
            default:
                return null;
        }
    }
}
