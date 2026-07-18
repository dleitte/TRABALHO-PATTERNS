package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.model.playlist.PlaylistItem;

public interface ComponenteComercial extends PlaylistItem {
    public String getTitulo();
    public Double getPreco();
    public Integer getDuracao(); 
}