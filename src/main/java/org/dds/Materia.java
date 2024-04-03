package org.dds;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    String nombre;
    List<Materia> materias_correlativas = new ArrayList<>();

    public Materia(String nombre, List<Materia> materias_correlativas) {
        this.nombre = nombre;
        this.materias_correlativas = materias_correlativas;
    }

    boolean esCorrelativa(Materia materia){
        return this.materias_correlativas.stream().anyMatch(m -> m.getNombre().equals(materia.getNombre()));
    }

    boolean sonLasCorrelativas(List<Materia> correlativas){
        return materias_correlativas.stream().allMatch(mc -> correlativas.stream().anyMatch(c -> mc.getNombre().equals(c.getNombre())));
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getMaterias_correlativas() {
        return materias_correlativas;
    }
}
