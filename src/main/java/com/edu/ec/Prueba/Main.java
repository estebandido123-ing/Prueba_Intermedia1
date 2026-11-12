package com.edu.ec.Prueba;


import com.edu.ec.Prueba.Extensiones.DescuentoExtension;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@QuarkusMain
public class Main implements QuarkusApplication {

   @Inject
    private PedidoService pedidoService;

    @Inject
    @Named("vip")
    private DescuentoExtension descuentoVIP;

    @Inject
    @Named("normal")
    private DescuentoExtension descuentoNormal;

    @Inject
    @Named("especial")
    private DescuentoExtension descuentoFeriado;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("INICIO");


        Pedido p001 = new Pedido("P001", "Laptop", 1000.00, "VIP");
        this.pedidoService.realizar(p001, this.descuentoVIP);

        Pedido p002 = new Pedido("P002", "Mouse", 100.00, "NORMAL");
        this.pedidoService.realizar(p002, this.descuentoNormal);

        Pedido p003 = new Pedido("P003", "Teclado", 200.00, "VIP");
        this.pedidoService.realizar(p003, this.descuentoVIP);

        Pedido p004 = new Pedido("P004", "Monitor", 500.00, "ESPECIAL");
        this.pedidoService.realizar(p004, this.descuentoFeriado);


        System.out.println("FIN");

        System.out.println("CODIGO:  172219_EC");


        return 0;

        

    }
}
