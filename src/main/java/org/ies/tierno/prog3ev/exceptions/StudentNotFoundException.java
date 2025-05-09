package org.ies.tierno.prog3ev.exceptions;


import lombok.Getter;

@Getter
public class StudentNotFoundException extends Exception {
    private final String nif;

    public StudentNotFoundException(String nif) {
        super("No se ha encontrado al estudiante con el nif" + nif);
        this.nif = nif;
    }
}
