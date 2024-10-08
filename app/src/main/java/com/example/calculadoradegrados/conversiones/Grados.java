package com.example.calculadoradegrados.conversiones;

public abstract class Grados {
    protected double cantidad;

    public Grados(double cantidad) { // Constructor
        this.cantidad = cantidad;
    }

    public double getCantidad() { // Devuelve la cantidad en la unidad actual
        return cantidad;
    }


    public abstract Grados parse(String unidad);
}
