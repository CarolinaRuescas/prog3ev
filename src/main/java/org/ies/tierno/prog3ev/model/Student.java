package org.ies.tierno.prog3ev.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student implements Comparable<Student> {
    private String nif;
    private String name;
    private String surname;
    private int zipCode;

    @Override
    public int compareTo(Student o) {
        return this.getNif().compareTo(o.getNif());
    }
}

