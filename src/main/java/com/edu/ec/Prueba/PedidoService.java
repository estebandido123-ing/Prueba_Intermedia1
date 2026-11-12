package com.edu.ec.Prueba;

import com.edu.ec.Prueba.Extensiones.DescuentoExtension;
import com.edu.ec.Prueba.Interceptores.MedirTiempo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class PedidoService {

    @Inject
    @Named("mail")
    private Notificacion correoService;

    @MedirTiempo
    public void realizar(Pedido pedido, DescuentoExtension descuentoExtension) {
        double descuento = descuentoExtension.aplicarDescuento(pedido.getValorOriginal());
        double total = pedido.getValorOriginal() - descuento;

        System.out.println("Nombre del producto:" + pedido.getProducto());
        System.out.println("PEDIDO: " + pedido.getCodigo() + "TOTAL: " + total + "0");
        
        this.correoService.enviar(pedido.getCodigo());

    }
}
