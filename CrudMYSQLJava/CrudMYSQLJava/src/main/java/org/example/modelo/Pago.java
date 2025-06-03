package org.example.modelo;

import java.time.LocalDate;

public class Pago {
    private Integer id;
    private String nroplaca;
    private String idprop;
    private LocalDate fecha;

    public Pago() {
    }

    public Pago(Integer id, String nroplaca, String idprop, LocalDate fecha) {
        this.id = id;
        this.nroplaca = nroplaca;
        this.idprop = idprop;
        this.fecha = fecha;
    }
}
