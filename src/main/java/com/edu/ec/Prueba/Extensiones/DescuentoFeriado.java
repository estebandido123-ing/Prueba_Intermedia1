package com.edu.ec.Prueba.Extensiones;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("especial")
public class DescuentoFeriado implements DescuentoExtension {



    @Override
    public double aplicarDescuento(double valorOriginal) {
        return valorOriginal * 0.20;
    }
    
}
