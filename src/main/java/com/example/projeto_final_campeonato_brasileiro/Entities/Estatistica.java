package com.example.projeto_final_campeonato_brasileiro.Entities;

public class Estatistica {
    int partidaId;
    int rodada;
    String clube;
    int chutes;
    int chutesNoAlvo;
    String posseDeBola;
    int passes;
    String precisaoPasses;
    int faltas;
    int cartaoAmarelo;
    int cartaoVermelho;
    int impedimentos;
    int escanteios;



    public Estatistica(int partidaId,
                       int rodada,
                       String clube,
                       int chutes,
                       int chutesNoAlvo,
                       String posseDeBola,
                       int passes,
                       String precisaoPasses,
                       int faltas,
                       int cartaoAmarelo,
                       int cartaoVermelho,
                       int impedimentos,
                       int escanteios) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.chutes = chutes;
        this.chutesNoAlvo = chutesNoAlvo;
        this.posseDeBola = posseDeBola;
        this.passes = passes;
        this.precisaoPasses = precisaoPasses;
        this.faltas = faltas;
        this.cartaoAmarelo = cartaoAmarelo;
        this.cartaoVermelho = cartaoVermelho;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
    }

    public int getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(int partidaId) {
        this.partidaId = partidaId;
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public int getChutes() {
        return chutes;
    }

    public void setChutes(int chutes) {
        this.chutes = chutes;
    }

    public int getChutesNoAlvo() {
        return chutesNoAlvo;
    }

    public void setChutesNoAlvo(int chutesNoAlvo) {
        this.chutesNoAlvo = chutesNoAlvo;
    }

    public String getPosseDeBola() {
        return posseDeBola;
    }

    public void setPosseDeBola(String posseDeBola) {
        this.posseDeBola = posseDeBola;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public String getPrecisaoPasses() {
        return precisaoPasses;
    }

    public void setPrecisaoPasses(String precisaoPasses) {
        this.precisaoPasses = precisaoPasses;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public void setCartaoAmarelo(int cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    public int getCartaoVermelho() {
        return cartaoVermelho;
    }

    public void setCartaoVermelho(int cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
    }

    public int getImpedimentos() {
        return impedimentos;
    }

    public void setImpedimentos(int impedimentos) {
        this.impedimentos = impedimentos;
    }

    public int getEscanteios() {
        return escanteios;
    }

    public void setEscanteios(int escanteios) {
        this.escanteios = escanteios;
    }
}
