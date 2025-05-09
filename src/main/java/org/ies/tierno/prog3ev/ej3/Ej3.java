package org.ies.tierno.prog3ev.ej3;


import lombok.extern.log4j.Log4j;
import org.ies.tierno.prog3ev.model.Student;

import java.util.TreeSet;

@Log4j
public class Ej3 {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>(
                new BySurnameNameNifStudentComparator()
        );

        students.add(
                new Student("49x", "Pepe", "Perez", 2631)
        );

        students.add(
                new Student("12x", "Maria", "Martinez", 28563)
        );

        students.add(
                new Student("52x", "Sofia", "Soria", 52136)
        );

        for (var student : students){
            log.info(student);
        }
    }


   
}
