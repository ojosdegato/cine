package cine.cartelera.cine.enums;

/**
 * Enum que define los tipos de precios de entradas disponibles
 * y sus valores correspondientes
 */
public enum PrecioEntrada {
    NORMAL(7.50),
    DIA_ESPECTADOR(3.00);

    private final double precio;

    PrecioEntrada(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}



