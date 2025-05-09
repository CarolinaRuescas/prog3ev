package org.ies.tierno.prog3ev.ej3;

import org.ies.tierno.prog3ev.model.Student;

import java.util.Comparator;

public class BySurnameNameNifStudentComparator implements Comparator <Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int compare = o1.getSurname().compareTo(o2.getSurname());
        if (compare == 0) {
            compare = o1.getName().compareTo(o2.getName());
            if (compare == 0){
                compare = o1.getNif().compareTo(o2.getNif());
            }
        }
        return compare;
    }





}
