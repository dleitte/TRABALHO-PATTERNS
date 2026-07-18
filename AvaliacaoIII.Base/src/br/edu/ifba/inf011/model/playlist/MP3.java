package br.edu.ifba.inf011.model.playlist;

public class MP3 {
    public String nome;
    public double tamanhoMegaBytes;

    public MP3(String nome, double tamanho) { 
        this.nome = nome; 
        this.tamanhoMegaBytes = tamanho; 
    }
    
    public double getTamanhoMegaBytes() {
        return this.tamanhoMegaBytes;
    }

    public String getNome() {
        return this.nome;
    }
}