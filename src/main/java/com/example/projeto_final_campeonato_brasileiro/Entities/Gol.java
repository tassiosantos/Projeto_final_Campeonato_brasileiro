package com.example.projeto_final_campeonato_brasileiro.Entities;

public class Gol {
    private int partidaId;
    private String rodada;
    private String clube;
    private String atleta;
    private int minuto;
    private String tipoDeGol;

    // Construtor
    public Gol(int partidaId, String rodada, String clube, String atleta, int minuto, String tipoDeGol) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipoDeGol = tipoDeGol;
    }

    // Métodos Getters
    public int getPartidaId() { return partidaId; }
    public String getRodada() { return rodada; }
    public String getClube() { return clube; }
    public String getAtleta() { return atleta; }
    public int getMinuto() { return minuto; }
    public String getTipoDeGol() { return tipoDeGol; }

    // Métodos Setters
    public void setPartidaId(int partidaId) { this.partidaId = partidaId; }
    public void setRodata(String rodada) { this.rodada = rodada; }
    public void setClube(String clube) { this.clube = clube; }
    public void setAtleta(String atleta) { this.atleta = atleta; }
    public void setMinuto(int minuto) { this.minuto = minuto; }
    public void setTipoDeGol(String tipoDeGol) { this.tipoDeGol = tipoDeGol; }
}
