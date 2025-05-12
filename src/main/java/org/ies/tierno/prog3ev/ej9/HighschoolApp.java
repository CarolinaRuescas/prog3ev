package org.ies.tierno.prog3ev.ej9;

import lombok.extern.log4j.Log4j;
import org.ies.tierno.prog3ev.exceptions.CourseNotFoundException;
import org.ies.tierno.prog3ev.exceptions.StudentNotFoundException;
import org.ies.tierno.prog3ev.model.Course;
import org.ies.tierno.prog3ev.model.Highschool;
import org.ies.tierno.prog3ev.model.Professor;
import org.ies.tierno.prog3ev.model.Student;

import java.util.*;

@Log4j
public class HighschoolApp {
    private final Scanner scanner;

    public HighschoolApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        var highschool = createTestHighschool();

        int option;
        do{
            option = chooseOption();
            if (option == 1){

                log.info("Introduce el nif del estudiante");
                String nif = scanner.nextLine();
                var courses = highschool.findStudentCourse(nif);
                log.info(courses);

            }else if (option == 2){
                try{
                    log.info("Introduce el id del curso: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    log.info("Introduce el nif del estudiante: ");
                    String nif = scanner.nextLine();

                    var student = highschool.findStudent(id, nif);
                    log.info(student);

                }catch (StudentNotFoundException | CourseNotFoundException e){
                    log.error(e.getMessage());
                }catch (InputMismatchException e){
                    log.error("El id del curso debe ser un número entero");
                    scanner.nextLine();
                }
            }else{
                log.info("Saliendoo.....");
            }
        }while (option != 3);
    }

    private int chooseOption(){
        int option = 0;
        do{
            try{
                log.info("ELIGE UNA OPCIÓN");
                log.info("1. Ver cursos de estudiante");
                log.info("2. Ver estudiante en curso");
                log.info("3. Salir");

                option = scanner.nextInt();

                if(option < 1 || option > 3){
                    log.error("la opcion en inválida");
                }
            }catch (InputMismatchException e){
                log.error("Debes introducir una de la opciones válidas");
            }finally {
                scanner.nextLine();
            }
        }while (option != 1 && option != 2 && option != 3);

        return option;
    }


    private Highschool createTestHighschool(){
        TreeSet<Student> dawStudents = new TreeSet<>();
        dawStudents.add(new Student("2x", "Calamardo", "Esponja", 5263 ));
        dawStudents.add(new Student("5x", "Maria", "gonzalez", 25362));

        TreeSet<Student> damStudents = new TreeSet<>();
        damStudents.add(new Student("6x", "Pepe", "Perez", 5263));
        damStudents.add(new Student("9x", "Sole", "Gutierrez", 6235));
        damStudents.add(new Student("8x", "Loles", "Leon", 25063));

        return new Highschool(
                "Tierno Galvan",
                Map.of(
                        "23x", new Professor("23x", "Jose", "Gonzalez"),
                        "25x", new Professor("25x", "Peppa", "Pig")
                ),
                List.of(
                        new Course(56, "Daw", 200, "52x", dawStudents),
                        new Course(58, "Dam", 2500, "68x", damStudents)
                )
        );
    }

}
