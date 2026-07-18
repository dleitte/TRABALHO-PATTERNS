package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.List;

public class PacoteBuilder {
    
    private String titulo;
    private List<ComponenteComercial> itensTemporarios;

    public PacoteBuilder reset(String titulo) {
        this.titulo = titulo;
        this.itensTemporarios = new ArrayList<>();
        return this;
    }

    public PacoteBuilder adicionarItem(ComponenteComercial item) {
        this.itensTemporarios.add(item);
        return this;
    }

    public Pacote build() {
        return new Pacote(this.titulo, this.itensTemporarios);
    }
}