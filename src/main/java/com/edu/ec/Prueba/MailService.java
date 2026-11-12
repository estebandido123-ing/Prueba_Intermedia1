package com.edu.ec.Prueba;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("mail")
public class MailService implements Notificacion {

    @Override
    public void enviar(String codigoPedido) {
        System.out.println("NOTIFICACION: " + codigoPedido);
    }
}
