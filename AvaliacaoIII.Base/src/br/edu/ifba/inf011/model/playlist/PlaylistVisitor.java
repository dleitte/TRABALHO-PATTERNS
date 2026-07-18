package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;

public interface PlaylistVisitor {
    public void visitFilme(Filme filme);
    public void visitPacote(Pacote pacote);
    public void visitSerie(Serie serie);
    public void visitEpisodio(Episodio episodio);
    public void visitMP3(MP3Adapter mp3Adapter);
    public void visitVideo(VideoAdapter videoAdapter);
}