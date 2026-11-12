package com.edu.ec.Prueba.Interceptores;

import com.edu.ec.Prueba.Pedido;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 1)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();
        Object resultado = context.proceed(); 
        long fin = System.currentTimeMillis();

        Object[] valores = context.getParameters();
        if (valores.length > 0 && valores[0] instanceof Pedido) {
            Pedido pedido = (Pedido) valores[0];
            System.out.println("DURACION: " + pedido.getCodigo() + " MS:" + (fin - inicio));
            System.out.println("TIEMPO: " + pedido.getCodigo() + " OK");
            System.out.println();
        }

        return resultado;
    }
}
