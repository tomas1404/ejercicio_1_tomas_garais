package org.dds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionesTest {
    Materia ingles_3;
    Materia ingles_2;
    Materia ingles_1;
    Materia fisica_1;
    Materia fisica_2;
    List<Materia> correlativas_fisica2;
    List<Materia> correlativas_ingles3;

    @BeforeEach
    void setUp() {
        ingles_1 = new Materia("ingles 1", new ArrayList<>());
        List<Materia> correlativas_ingles2 = new ArrayList<>();
        correlativas_ingles2.add(ingles_1);
        ingles_2 = new Materia("ingles 2", correlativas_ingles2);
        correlativas_ingles3 = new ArrayList<>();
        correlativas_ingles3.add(ingles_1);
        correlativas_ingles3.add(ingles_2);
        ingles_3 = new Materia("ingles 3", correlativas_ingles3);

        fisica_1 = new Materia("fisica 1", new ArrayList<>());
        correlativas_fisica2 = new ArrayList<>();
        correlativas_fisica2.add(fisica_1);
        fisica_2 = new Materia("fisica 2", correlativas_fisica2);

    }

    @Test
    void inscripcion_sin_correlativas() {
        List<Materia> materias_seleccionadas = new ArrayList<>();
        materias_seleccionadas.add(fisica_1);
        materias_seleccionadas.add(ingles_1);
        Inscripcion inscripcion = new Inscripcion(materias_seleccionadas ,new ArrayList<>());
        assertEquals(true, inscripcion.aprobada());
    }

    @Test
    void inscripcion_aprobada() {
        List<Materia> materias_seleccionadas = new ArrayList<>();
        materias_seleccionadas.add(fisica_2);
        materias_seleccionadas.add(ingles_3);
        List<Materia> materias_aprobadas = new ArrayList<>(correlativas_fisica2);
        materias_aprobadas.addAll(correlativas_ingles3);
        Inscripcion inscripcion = new Inscripcion(materias_seleccionadas, materias_aprobadas);
        assertEquals(true, inscripcion.aprobada());
    }

    @Test
    void inscripcion_no_aprobada() {
        List<Materia> materias_seleccionadas = new ArrayList<>();
        materias_seleccionadas.add(fisica_2);
        materias_seleccionadas.add(ingles_3);
        List<Materia> materias_aprobadas = new ArrayList<>(correlativas_fisica2);
        Inscripcion inscripcion = new Inscripcion(materias_seleccionadas, materias_aprobadas);
        assertEquals(false, inscripcion.aprobada());
    }


}