package com.edu.ec.Prueba.Extensiones;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("normal")
public class DescuentoNormal implements DescuentoExtension {


    
    @Override
    public double aplicarDescuento(double valorOriginal) {
        return 0.0;
    }


}