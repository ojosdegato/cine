package cine.cartelera.cine.enums;

import java.math.BigDecimal; // Importa la clase BigDecimal para manejar precios con precisión decimal

public enum PrecioEntrada { //

    PRECIO_NORMAL(new BigDecimal("7.50")), // Precio normal de una entrada
    PRECIO_DIA_ESPECTADOR(new BigDecimal("3.00")); // Precio especial para el día del espectador

    private final BigDecimal valor;

    PrecioEntrada(BigDecimal valor) {
        this.valor = valor; // Inicializa el valor del precio de la entrada
    }

    public BigDecimal getValor() {
        return valor;
    }
}


