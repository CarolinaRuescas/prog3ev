package org.ies.tierno.prog3ev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.prog3ev.exceptions.CourseNotFoundException;
import org.ies.tierno.prog3ev.exceptions.ProfessorNotFoundException;
import org.ies.tierno.prog3ev.exceptions.StudentNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

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

    // Ejercicio 7: dado un código postal, devuelve todos los estudiantes que viven en ese
    //código postal.

    public TreeSet<Student> findStudentZipCode (int zipCode){
        return courses
                .stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getZipCode()==zipCode)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // Ejercicio 10: Dado un id de curso, devuelve el profesor que imparte el curso.
    // Si no existe el curso, lanza la excepción CourseNotFoundException.

    public Professor findProfessorCourse (int id) throws CourseNotFoundException, ProfessorNotFoundException {
            var course = findCourse(id);
            if (professorByNif.containsKey(course.getProfessorNif())){
                return professorByNif.get(course.getProfessorNif());
            }
            throw new ProfessorNotFoundException(course.getProfessorNif());
    }
}