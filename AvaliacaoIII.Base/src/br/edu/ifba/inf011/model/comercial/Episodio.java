package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.model.playlist.PlaylistVisitor;

public class Episodio implements ComponenteComercial {
    
    private String titulo;
    private Double preco;
    private Timeline timeline;
    private Integer numero;

    public Episodio(String titulo, Double preco, Integer numero, Timeline timeline) {
        this.titulo = titulo;
        this.preco = preco;
        this.timeline = timeline;
        this.numero = numero;
    }
    
    @Override
    public Double getPreco() {
        return this.preco; 
    }
    
    @Override
    public Integer getDuracao() { 
        return this.timeline.getDurationInSeconds();
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    public Integer getNumero() {
        return this.numero;
    }     
    
    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visitEpisodio(this);
    }
}