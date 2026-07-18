package br.edu.ifba.inf011.model.playlist;

public class VideoAdapter implements PlaylistItem {
    
    private Video video;

    public VideoAdapter(Video video) {
        this.video = video;
    }

    public Video getVideo() {
        return this.video;
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visitVideo(this);
    }
}