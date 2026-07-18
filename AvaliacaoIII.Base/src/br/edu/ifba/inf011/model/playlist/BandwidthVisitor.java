package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;

public class BandwidthVisitor implements PlaylistVisitor {
    
    // Variável interna para acumular os cálculos
    private Double totalBandwidth = 0.0;

    // Método para a Playlist resgatar o resultado final
    public Double getResult() {
        return totalBandwidth;
    }

    @Override
    public void visitFilme(Filme filme) {
        totalBandwidth += filme.getDuracao() * PlaylistItem.BAND_PER_SECOND;
    }

    @Override
    public void visitEpisodio(Episodio episodio) {
        totalBandwidth += episodio.getDuracao() * PlaylistItem.BAND_PER_SECOND;
    }

    @Override
    public void visitSerie(Serie serie) {
        totalBandwidth += serie.getDuracao() * PlaylistItem.BAND_PER_SECOND;
    }

    @Override
    public void visitPacote(Pacote pacote) {
        totalBandwidth += pacote.getDuracao() * PlaylistItem.BAND_PER_SECOND;
    }

    @Override
    public void visitMP3(MP3Adapter mp3Adapter) {
        totalBandwidth += mp3Adapter.getMP3().getTamanhoMegaBytes();
    }

    @Override
    public void visitVideo(VideoAdapter videoAdapter) {
        totalBandwidth += videoAdapter.getVideo().getTamanhoMegaBytes();
    }
}