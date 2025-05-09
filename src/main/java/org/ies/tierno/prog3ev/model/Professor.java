package org.ies.tierno.prog3ev.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Professor {
    private String nif;
    private String name;
    private String surname;
}
