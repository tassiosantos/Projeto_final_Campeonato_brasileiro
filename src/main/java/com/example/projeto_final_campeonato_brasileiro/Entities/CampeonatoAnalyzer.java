package com.example.projeto_final_campeonato_brasileiro.Entities;

import java.util.List;

public class CampeonatoAnalyzer {


    private List<Cartao> listaCartoes;
    private List<Estatistica> listaEstatistias;

    private List<Gol> listaGols;

    private List<Jogo> listaJogos;

    public CampeonatoAnalyzer(List<Cartao> listaCartoes, List<Estatistica> listaEstatistias, List<Gol> listaGols, List<Jogo> listaJogos) {
        this.listaCartoes = listaCartoes;
        this.listaEstatistias = listaEstatistias;
        this.listaGols = listaGols;
        this.listaJogos = listaJogos;
    }


    public List<Cartao> getListaCartoes() {
        return listaCartoes;
    }

    public void setListaCartoes(List<Cartao> listaCartoes) {
        this.listaCartoes = listaCartoes;
    }

    public List<Estatistica> getListaEstatistias() {
        return listaEstatistias;
    }

    public void setListaEstatistias(List<Estatistica> listaEstatistias) {
        this.listaEstatistias = listaEstatistias;
    }

    public List<Gol> getListaGols() {
        return listaGols;
    }

    public void setListaGols(List<Gol> listaGols) {
        this.listaGols = listaGols;
    }

    public List<Jogo> getListaJogos() {
        return listaJogos;
    }

    public void setListaJogos(List<Jogo> listaJogos) {
        this.listaJogos = listaJogos;
    }
}
