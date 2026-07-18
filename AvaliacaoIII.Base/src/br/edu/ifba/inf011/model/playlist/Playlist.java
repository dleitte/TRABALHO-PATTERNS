package br.edu.ifba.inf011.model.playlist;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    
    private List<PlaylistItem> items;
    
    public Playlist() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(PlaylistItem item) {
        this.items.add(item);
    }
    
    public String toXML() {
        XMLVisitor visitor = new XMLVisitor();
        for(PlaylistItem item : this.items) {
            item.accept(visitor);
        }
        return "<playlist>\n" + visitor.getResult() + "</playlist>\n";
    }

    public Double getBandaTotal() {
        BandwidthVisitor visitor = new BandwidthVisitor();
        for(PlaylistItem item : this.items) {
            item.accept(visitor);
        }
        return visitor.getResult();
    }
}