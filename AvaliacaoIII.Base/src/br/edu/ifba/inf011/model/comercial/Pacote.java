package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.PlaylistVisitor;

public class Pacote implements ComponenteComercial, PlaylistItem {

    protected String titulo;
    protected List<ComponenteComercial> itens;
    
    public Pacote(String titulo) {
        this.titulo = titulo;
        this.itens = new ArrayList<>();
    }
    
    public Pacote(String titulo, List<ComponenteComercial> itens) {
        this.titulo = titulo;
        this.itens = itens;
    }       
    
    public void adicionarItem(ComponenteComercial item) {
        this.itens.add(item);
    }

    public void removerItem(ComponenteComercial item) {
        this.itens.remove(item);
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
        
    @Override
    public Double getPreco() {
        double soma = this.itens.stream().mapToDouble(ComponenteComercial::getPreco).sum();
        return soma * 0.9;
    }
        
    @Override
    public Integer getDuracao() {
        return this.itens.stream().mapToInt(ComponenteComercial::getDuracao).sum();
    }      
    
    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visitPacote(this);
    }
    
    public List<ComponenteComercial> getItens() {
        return this.itens;
    }
}