package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.CinemaTimelineBuilder;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.TimelineBuilder;
import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.PacoteBuilder;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.MP3Adapter;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.Video;
import br.edu.ifba.inf011.model.playlist.VideoAdapter;

public class ClienteAval3 {

    public void run() {
        
        TimelineBuilder tBuilder = new CinemaTimelineBuilder();
        Timeline cinemaTimeline = tBuilder.reset().addClassAdapterVideo("MainShot_4K.mov").build();
        
        // ==========================================
        // QUESTÃO I: COMPOSITE + BUILDER
        // ==========================================
        
        Filme matrix1 = new Filme("Matrix", 20.0, cinemaTimeline);
        Filme matrix2 = new Filme("Matrix Reloaded", 25.0, cinemaTimeline);
        Filme matrix3 = new Filme("Matrix Revolutions", 15.0, cinemaTimeline);
        Filme bladeRunner = new Filme("Blade Runner", 30.0, cinemaTimeline);
        
        Episodio bmEp1 = new Episodio("Hino Nacional", 5.0, 1, cinemaTimeline);
        Episodio bmEp2 = new Episodio("Quinze Milhões de Méritos", 5.0, 2, cinemaTimeline);

        Serie blackMirror = new Serie("Black Mirror", 1);
        blackMirror.adicionarEpisodio(bmEp1);
        blackMirror.adicionarEpisodio(bmEp2);

        PacoteBuilder builder = new PacoteBuilder();
        Pacote pacoteMatrix = builder.reset("Trilogia Matrix")
                                     .adicionarItem(matrix1)
                                     .adicionarItem(matrix2)
                                     .adicionarItem(matrix3)
                                     .build();

        Pacote superPacote = builder.reset("Coleção Sci-Fi")
                                    .adicionarItem(pacoteMatrix)
                                    .adicionarItem(blackMirror) 
                                    .adicionarItem(bladeRunner)
                                    .build();

        System.out.println("====== QUESTÃO I: COMPOSITE + BUILDER ======");
        System.out.println("Super Pacote: " + superPacote.getTitulo());
        System.out.println("Preço Total (com descontos em cascata): R$ " + superPacote.getPreco());
        System.out.println("Duração Total: " + superPacote.getDuracao() + " segundos");


        // ==========================================
        // QUESTÃO II: ADAPTER + VISITOR
        // ==========================================
        
        System.out.println("\n====== QUESTÃO II: ADAPTER + VISITOR ======");
        Playlist playlist = new Playlist();
        
        playlist.addItem(superPacote);
        
        MP3 meuMp3 = new MP3("Podcast de Tecnologia", 120.0);
        Video meuVideo = new Video("Gatinhos Fofos", 500.0, "http://youtube.com/cat");
        
        playlist.addItem(new MP3Adapter(meuMp3));
        playlist.addItem(new VideoAdapter(meuVideo));
        
        double largura = playlist.getBandaTotal();
        System.out.println("Consumo de Largura de Banda Total: " + largura);
        
        String xml = playlist.toXML();
        System.out.println("Exportador XML Gerado:\n" + xml);
    }       

    public static void main(String[] args) {
        new ClienteAval3().run();
    }
}