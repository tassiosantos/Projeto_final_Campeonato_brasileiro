package com.example.projeto_final_campeonato_brasileiro.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Jogo {
    private int ID;
    private int rodada;
    private LocalDate data;
    private LocalTime hora;
    private String mandante;
    private String visitante;
    private String formacaoMandante;
    private String formacaoVisitante;
    private String tecnicoMandante;
    private String tecnicoVisitante;
    private String vencedor;
    private String arena;
    private int mandantePlacar;
    private int visitantePlacar;
    private String mandanteEstado;
    private String visitanteEstado;


    public Jogo(int ID, int rodada, LocalDate data, LocalTime hora, String mandante, String visitante, String formacaoMandante, String formacaoVisitante, String tecnicoMandante, String tecnicoVisitante, String vencedor, String arena, int mandantePlacar, int visitantePlacar, String mandanteEstado, String visitanteEstado) {
        this.ID = ID;
        this.rodada = rodada;
        this.data = data;
        this.hora = hora;
        this.mandante = mandante;
        this.visitante = visitante;
        this.formacaoMandante = formacaoMandante;
        this.formacaoVisitante = formacaoVisitante;
        this.tecnicoMandante = tecnicoMandante;
        this.tecnicoVisitante = tecnicoVisitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.mandantePlacar = mandantePlacar;
        this.visitantePlacar = visitantePlacar;
        this.mandanteEstado = mandanteEstado;
        this.visitanteEstado = visitanteEstado;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getFormacaoMandante() {
        return formacaoMandante;
    }

    public void setFormacaoMandante(String formacaoMandante) {
        this.formacaoMandante = formacaoMandante;
    }

    public String getFormacaoVisitante() {
        return formacaoVisitante;
    }

    public void setFormacaoVisitante(String formacaoVisitante) {
        this.formacaoVisitante = formacaoVisitante;
    }

    public String getTecnicoMandante() {
        return tecnicoMandante;
    }

    public void setTecnicoMandante(String tecnicoMandante) {
        this.tecnicoMandante = tecnicoMandante;
    }

    public String getTecnicoVisitante() {
        return tecnicoVisitante;
    }

    public void setTecnicoVisitante(String tecnicoVisitante) {
        this.tecnicoVisitante = tecnicoVisitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public int getMandantePlacar() {
        return mandantePlacar;
    }

    public void setMandantePlacar(int mandantePlacar) {
        this.mandantePlacar = mandantePlacar;
    }

    public int getVisitantePlacar() {
        return visitantePlacar;
    }

    public void setVisitantePlacar(int visitantePlacar) {
        this.visitantePlacar = visitantePlacar;
    }

    public String getMandanteEstado() {
        return mandanteEstado;
    }

    public void setMandanteEstado(String mandanteEstado) {
        this.mandanteEstado = mandanteEstado;
    }

    public String getVisitanteEstado() {
        return visitanteEstado;
    }

    public void setVisitanteEstado(String visitanteEstado) {
        this.visitanteEstado = visitanteEstado;
    }
}
