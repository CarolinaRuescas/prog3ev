package org.ies.tierno.prog3ev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.prog3ev.exceptions.CourseNotFoundException;
import org.ies.tierno.prog3ev.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor

public class Highschool {
    private String name;
    private Map<String, Professor> professorByNif;
    private List<Course> courses;

    //Ejercicio 4: Añade un metodo que dado un NIF de
    //estudiante, devuelva los cursos en los que esta
    // matriculado el estudiante

    public List<Course> findStudentCourse (String nif){
        return courses
                .stream()
                .filter(course -> course.hasStudent(nif))
                .toList();
    }
    //  Ejercicio 5: dado un id de curso y un nif de estudiante,
    //  devuelva los datos de dicho estudiante

    public Student findStudent (int id, String nif) throws CourseNotFoundException, StudentNotFoundException {
        var course = findCourse(id);
        return course.findStudent(nif);

    }

    public Course findCourse (int id) throws CourseNotFoundException {
        for (var course : courses){
            if (course.getId() == id){
                return course;
            }
        }
        throw new CourseNotFoundException(id);
    }

}