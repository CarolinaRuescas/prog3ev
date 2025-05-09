# Colecciones

## Configuración

Hay que añadir las siguientes dependencias

### JUnit

#### Dependencia

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-engine</artifactId>
  <version>5.13.0-M2</version>
  <scope>test</scope>
</dependency>
```

### Lombok

#### Propiedades

```xml
<lombok.version>1.18.34</lombok.version>
<maven-plugin.version>3.8.1</maven-plugin.version>
```

#### Dependencia

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>${lombok.version}</version>
  <scope>provided</scope>
</dependency>
```

#### Plugin

**ATENCION** - Solo debe haber una etiqueta build en un pom.xml, si quieren configurar varias cosas dentro se deben mantener
en la misma etiqueta build.

```xml
<build>
  <pluginManagement>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>${maven-plugin.version}</version>
        <configuration>
          <annotationProcessorPaths>
            <path>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
              <version>${lombok.version}</version>
            </path>
          </annotationProcessorPaths>
        </configuration>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```

### Slf4j

#### Dependencia

```xml
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
  <version>2.0.13</version>
</dependency>
```
#### log4j.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

<log4j:configuration debug="true">
  <appender name="fileAppender" class="org.apache.log4j.RollingFileAppender"   >

    <param name="File" value="out.log"/>
    <layout class="org.apache.log4j.PatternLayout">
      <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss} %-5p %c:%L - %m%n" />
    </layout>
  </appender>

  <appender name="consoleAppender" class="org.apache.log4j.ConsoleAppender">
    <param name="Target" value="System.out"/>
    <layout class="org.apache.log4j.PatternLayout">
      <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss} %-5p %c:%L - %m%n" />
    </layout>
  </appender>
  <root>
    <priority value="info" />
    <appender-ref ref="consoleAppender" />
    <appender-ref ref="fileAppender" />
  </root>
</log4j:configuration>
```

## PRIMERA PARTE (HACER ANTES)

### Ejercicio 1 (1 punto)

Configura JUnit, Lombok y Slf4j, siguiendo las instrucciones anteriores.

Añade anotaciones a las clases del paquete `org.ies.tierno.prog3ev.model` para que generen automáticamente:
- Constructor con todos los campos
- Getters, setters, hashCode, equals...

Configura un logger en la clase Ej1, muestra en pantalla el mensaje "Hola mundo"

### Ejercicio 2 (1 punto)

Añade los siguientes campos a los POJOs del modelo:
- Añade un campo a Highschool que almacene los profesores indexados por nif.
- Añade un campo a Highschool que almacene un listado de cursos.
- Añade un campo a Course que almacene los alumnos que están matriculados ordenados por nif (usando Comparable<T>)

### Ejercicio 3 (HACER ANTES EJERCICIO 2)  (1 punto)

En el método principal de Ej3:
- Crea una colección de alumnos (usando la clase Student), **la colección debe ordenar** los alumnos por: apellidos, nombre y nif
- Añade tres alumnos a la colección que acabas de crear 
- Recorre la colección mostrando los alumnos en pantalla

## SEGUNDA PARTE (HACER ANTES LA PRIMERA PARTE)

### Ejercicio 4 (1 punto) findStudentCourses

Añade un método a la clase Highschool que, dado un nif de estudiante, devuelva los cursos en los que está matriculado el estudiante

### Ejercicio 5  (1 punto) 

Añade un método a la clase Highschool que, dado un id de curso y un nif de estudiante, devuelva los datos de dicho estudiante.
En caso de que no exista el curso lanza la excepción CourseNotFoundException, en caso de que no se encuentre al estudiante
lanza la excepción StudentNotFoundException.

### Ejercicio 6 (1 punto)

Crea los tests unitarios necesarios para cubrir los casos relevantes del método del ejercicio 5

### Ejercicio 7 - STREAMS (1 punto)

Añade un método a la clase Highschool que, dado un código postal, devuelve todos los estudiantes que viven en ese
código postal.

### Ejercicio 8 (1 punto)

Crea los tests unitarios necesarios para cubrir los casos relevantes del método del ejercicio 7

### Ejercicio 9 (2 punto)

Implementa el método `run` del componente HighschoolApp:
- Crea un instituto hardcodeado (puedes usar el mismo que has creado para el ejercicio 6)
- Bucle de menú con las siguientes opciones:
  - Ver cursos de estudiante (Ej 4)
  - Ver estudiante en curso (Ej 5) 
  - Salir

En caso de excepción muestra al usuario un mensaje informativo. 

# prog3ev
