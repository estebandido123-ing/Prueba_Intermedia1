package com.edu.ec.Prueba.Extensiones;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("vip")
public class DescuentoVIP implements DescuentoExtension {


    @Override
    public double aplicarDescuento(double valorOriginal){
        return valorOriginal * 0.10;
    }



}