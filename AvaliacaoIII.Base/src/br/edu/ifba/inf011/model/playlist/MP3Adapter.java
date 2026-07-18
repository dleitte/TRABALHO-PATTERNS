package br.edu.ifba.inf011.model.playlist;

public class MP3Adapter implements PlaylistItem {
    
    private MP3 mp3;

    public MP3Adapter(MP3 mp3) {
        this.mp3 = mp3;
    }

    public MP3 getMP3() {
        return this.mp3;
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visitMP3(this);
    }
}