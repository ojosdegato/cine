package cine.cartelera.cine.enums;

/**
 * Enum que define los tipos de precios de entradas disponibles
 * y sus valores correspondientes
 */
public enum Precio_Entrada {
    NORMAL(7.50),
    DIA_ESPECTADOR(3.00);

    private final double precio;

    Precio_Entrada(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}



