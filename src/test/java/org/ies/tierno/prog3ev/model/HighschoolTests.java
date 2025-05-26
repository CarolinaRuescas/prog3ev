package org.ies.tierno.prog3ev.model;

import org.ies.tierno.prog3ev.exceptions.CourseNotFoundException;
import org.ies.tierno.prog3ev.exceptions.StudentNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class HighschoolTests {
    //  Ejercicio6: Utilizando el ejercicio5 dado un id de curso y un nif de estudiante,
    //  devuelva los datos de dicho estudiante
    // Hay tres escenarios poasibles de test, 1º que encuentra al estudiante y se
    // cumple todos, 2º que como no se encuentra el curso no hay estudiante y el 3º
    // que el curso si esta pero se busca al estudiante y no esta

    //1º hago la clase en la que creamos los TreeSet, con los datos correspondientes

    private Highschool createTestHighschool(){
        TreeSet<Student> dawStudents = new TreeSet<>();
        dawStudents.add(new Student("2x", "Calamardo", "Esponja", 25));
        dawStudents.add(new Student("5x", "Maria", "gonzalez", 25));

        TreeSet<Student> damStudents = new TreeSet<>();
        damStudents.add(new Student("6x", "Pepe", "Perez", 52));
        damStudents.add(new Student("9x", "Sole", "Gutierrez", 52));
        damStudents.add(new Student("8x", "Loles", "Leon", 52));

        return new Highschool(
                "Tierno Galvan",
                Map.of(
                        "23x", new Professor("23x", "Jose", "Gonzalez"),
                        "25x", new Professor("25x", "Peppa", "Pig")
                ),
                List.of(
                        new Course(56, "Daw", 200, "23x", dawStudents),
                        new Course(58, "Dam", 2500, "25x", damStudents)
                )
        );
    }

    // este test es el 1º (cuando se encuentra al estudiante en el curso)
    @Test
    public void findStudentTest() throws CourseNotFoundException, StudentNotFoundException{
        var highschool = createTestHighschool();

        var result = highschool.findStudent(56, "2x");

        var expected = new Student("2x", "Calamardo", "Esponja", 25);

        Assertions.assertEquals(result,expected);

    }

    // en este caso se busca al estudiante pero no se encuentra el curso
    @Test
    public void findStudentNotFoundCourseTest(){
        Assertions.assertThrows(
                CourseNotFoundException.class,
                ()->{
                    var highschool = createTestHighschool();
                    highschool.findStudent(2,"23x");
                }
        );
    }

    // se busca al estudiante y no se encuentra
    @Test
    public void findStudentNotFoundStudentTest(){
        Assertions.assertThrows(
                StudentNotFoundException.class,
                ()->{
                    var highschool = createTestHighschool();
                    highschool.findStudent(56, "30x");
                }
        );
    }

    @Test
    public void findZipCodeStudentsTest(){
        var highschool = createTestHighschool();

        var result = highschool.findStudentZipCode(52);

        var expected = new TreeSet<Student>();

        expected.add(new Student("6x", "Pepe", "Perez", 52));
        expected.add(new Student("9x", "Sole", "Gutierrez", 52));
        expected.add(new Student("8x", "Loles", "Leon", 52));

        Assertions.assertEquals(result,expected);
    }












}