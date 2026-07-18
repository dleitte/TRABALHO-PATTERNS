package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifba.inf011.model.playlist.PlaylistVisitor;

public class Serie implements ComponenteComercial {

    protected String titulo;
    protected Integer temporada;
    protected List<ComponenteComercial> episodios;
    
    public Serie(String titulo, Integer temporada) {
        this.titulo = titulo;
        this.temporada = temporada;
        this.episodios = new ArrayList<>();
    }
    
    public void adicionarEpisodio(ComponenteComercial episodio) {
        this.episodios.add(episodio);
    }

    public void removerEpisodio(ComponenteComercial episodio) {
        this.episodios.remove(episodio);
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
        
    @Override
    public Double getPreco() {
        double soma = this.episodios.stream().mapToDouble(ComponenteComercial::getPreco).sum();
        return soma * 0.9; 
    }
        
    @Override
    public Integer getDuracao() {
        return this.episodios.stream().mapToInt(ComponenteComercial::getDuracao).sum();
    }    
    
    public Integer getTemporada() {
        return this.temporada;
    }
    
    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visitSerie(this);
    }
    
    public List<ComponenteComercial> getEpisodios() {
        return this.episodios;
    }
}
