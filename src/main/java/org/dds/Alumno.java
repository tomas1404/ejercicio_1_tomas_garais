package org.dds;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
    String nombre;
    String mail;
    List<Materia> materias_aprobadas = new ArrayList<>();
    List<Inscripcion> inscripciones = new ArrayList<>();

    public Alumno(String nombre, String mail, List<Materia> materias_aprobadas, List<Inscripcion> inscripciones) {
        this.nombre = nombre;
        this.mail = mail;
        this.materias_aprobadas = materias_aprobadas;
        this.inscripciones = inscripciones;
    }

    public void inscribir(List<Materia> materias_seleccionadas) {
        this.inscripciones.add(new Inscripcion(materias_seleccionadas, this.materias_aprobadas));
    }

}

