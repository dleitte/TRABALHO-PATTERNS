package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;

public class XMLVisitor implements PlaylistVisitor {
    
    // Variável interna para acumular o resultado
    private StringBuilder xml = new StringBuilder();

    // Método para a Playlist resgatar o resultado final
    public String getResult() {
        return xml.toString();
    }

    @Override
    public void visitFilme(Filme filme) {
        xml.append("<filme titulo=\"").append(filme.getTitulo()).append("\"/>\n");
    }

    @Override
    public void visitEpisodio(Episodio episodio) {
        xml.append("<episodio titulo=\"").append(episodio.getTitulo())
           .append("\" numero=\"").append(episodio.getNumero()).append("\"/>\n");
    }

    @Override
    public void visitPacote(Pacote pacote) {
        xml.append("<pacote titulo=\"").append(pacote.getTitulo()).append("\">\n");
        for(br.edu.ifba.inf011.model.comercial.ComponenteComercial item : pacote.getItens()) {
            item.accept(this);
        }
        xml.append("</pacote>\n");
    }

    @Override
    public void visitSerie(Serie serie) {
        xml.append("\t<serie titulo=\"").append(serie.getTitulo())
           .append("\" temporada=\"").append(serie.getTemporada()).append("\">\n");
        for(br.edu.ifba.inf011.model.comercial.ComponenteComercial ep : serie.getEpisodios()) {
            ep.accept(this);
        }
        xml.append("\t</serie>\n");
    }

    @Override
    public void visitMP3(MP3Adapter mp3Adapter) {
        xml.append("<mp3 nome=\"").append(mp3Adapter.getMP3().getNome()).append("\"/>\n");
    }

    @Override
    public void visitVideo(VideoAdapter videoAdapter) {
        xml.append("  <video nome=\"").append(videoAdapter.getVideo().getNome())
           .append("\" link=\"").append(videoAdapter.getVideo().getLink()).append("\"/>\n");
    }
}