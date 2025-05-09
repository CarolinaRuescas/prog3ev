package org.ies.tierno.prog3ev.exceptions;

import lombok.Getter;

@Getter
public class CourseNotFoundException extends Exception {
    private final int id;

    public CourseNotFoundException(int id) {
        super("No existe el curso buscado con ese id" + id);
        this.id = id;
    }
}
