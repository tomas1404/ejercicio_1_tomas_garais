package org.dds;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {

    List<Materia> materias_seleccionadas = new ArrayList<>();
    List<Materia> materias_aprobadas = new ArrayList<>();

    public Inscripcion(List<Materia> materias_seleccionadas, List<Materia> materias_aprobadas) {
        this.materias_seleccionadas = materias_seleccionadas;
        this.materias_aprobadas = materias_aprobadas;
    }

    boolean aprobada(){
        return materias_seleccionadas.stream().allMatch(mate_selec ->
                mate_selec.sonLasCorrelativas(materias_aprobadas));
    }
}
