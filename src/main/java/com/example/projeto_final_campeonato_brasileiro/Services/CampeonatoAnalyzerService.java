package com.example.projeto_final_campeonato_brasileiro.Services;

import com.example.projeto_final_campeonato_brasileiro.Entities.Cartao;
import com.example.projeto_final_campeonato_brasileiro.Entities.Estatistica;
import com.example.projeto_final_campeonato_brasileiro.Entities.Gol;
import com.example.projeto_final_campeonato_brasileiro.Entities.Jogo;
import com.example.projeto_final_campeonato_brasileiro.Repositories.CampeonatoAnalyzerRepository;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CampeonatoAnalyzerService {
    private static CampeonatoAnalyzerRepository campeonatoAnalyzerRepository;

    private String cartaoCsv;
    private String estatisticaCsv;
    private String golCsv;
    private String jogoCsv;

    public CampeonatoAnalyzerService(){
        campeonatoAnalyzerRepository = new CampeonatoAnalyzerRepository();
    }

    public List<Map.Entry<String, Long>> getTimeMaisVenceu(int ano){

        List<Jogo> jogos = campeonatoAnalyzerRepository.get().getListaJogos();

        Map<String, Long> listaVitorias = jogos.stream()
                .filter(jogo -> jogo.getData().getYear() == ano)
                .filter(jogo -> !jogo.getVencedor().equals("-"))
                .collect(Collectors.groupingBy(Jogo::getVencedor,Collectors.counting()));

        Long maisVitorias = listaVitorias.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);



        List<Map.Entry<String, Long>> timesMaisVitorias = listaVitorias
                .entrySet().stream()
                .filter(entry -> entry.getValue() == maisVitorias)
                .toList();

        return timesMaisVitorias;
    }

    public List<Map.Entry<String,Long>> getEstadoMenosJogos(){
        List<Jogo> jogos = campeonatoAnalyzerRepository.get().getListaJogos();
        Map<String, Long> listaMandos = jogos.stream()
                .collect(Collectors.groupingBy(Jogo::getMandante,Collectors.counting()));

        Long menosMando = listaMandos.values().stream()
                .mapToLong(v -> v)
                .min()
                .orElse(0);



        List<Map.Entry<String, Long>> estadosMenosMandos = listaMandos
                .entrySet().stream()
                .filter(entry -> entry.getValue() == menosMando)
                .toList();

        return estadosMenosMandos;

    }


    public List<Map.Entry<String, Long>> getJogadorMaisGols(){
        List<Gol> golsFeitos = campeonatoAnalyzerRepository.get().getListaGols();

        Map<String, Long> listaGolsJogadores = golsFeitos.stream()
                .collect(Collectors.groupingBy(Gol::getAtleta,Collectors.counting()));

        Long maisGols = listaGolsJogadores.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);
        List<Map.Entry<String, Long>> jogadoresMaisGols = listaGolsJogadores
                .entrySet().stream()
                .filter(entry-> entry.getValue() == maisGols)
                .toList();



        return jogadoresMaisGols;
    }


    public List<Map.Entry<String, Long>> getJogadorMaisGolsPenalts(){
        List<Gol> golsFeitos = campeonatoAnalyzerRepository.get().getListaGols();

        Map<String, Long> listaGolsPenalty = golsFeitos.stream()
                .filter(gol -> gol.getTipoDeGol().equals("Penalty"))
                .collect(Collectors.groupingBy(Gol::getAtleta,Collectors.counting()));

        Long maisGolsPenalty = listaGolsPenalty.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);

        List<Map.Entry<String, Long>> jogadoresMaisGolsPenalty = listaGolsPenalty
                .entrySet().stream()
                .filter(entry-> entry.getValue() == maisGolsPenalty)
                .toList();



        return jogadoresMaisGolsPenalty;
    }

    public List<Map.Entry<String, Long>> getJogadorMaisGolsContra(){
        List<Gol> golsFeitos = campeonatoAnalyzerRepository.get().getListaGols();

        Map<String, Long> listaGolsContra = golsFeitos.stream()
                .filter(gol -> gol.getTipoDeGol().equals("Gol Contra"))
                .collect(Collectors.groupingBy(Gol::getAtleta,Collectors.counting()));

        Long maisGolsContra = listaGolsContra.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);

        List<Map.Entry<String, Long>> jogadoresMaisGolsContra = listaGolsContra
                .entrySet().stream()
                .filter(entry-> entry.getValue() == maisGolsContra)
                .toList();

        return jogadoresMaisGolsContra;
    }

    public List<Map.Entry<String, Long>> getJogadorMaisCartao(String corCartao){
        List<Cartao> cartoesTotais = campeonatoAnalyzerRepository.get().getListaCartoes();

        Map<String, Long> cartoesJogador = cartoesTotais.stream()
                .filter(cartao -> cartao.getCartao().equals(corCartao))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        Long maisCartao = cartoesJogador.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);

        List<Map.Entry<String, Long>> jogadoresMaisCartao = cartoesJogador.entrySet().stream()
                .filter(jogador -> jogador.getValue() == maisCartao).toList();


        return jogadoresMaisCartao;
    }


    public List<Map.Entry<String, Long>> getPlacarPartidaMaisGols(){
        List<Jogo> jogos = campeonatoAnalyzerRepository.get().getListaJogos();

        int maxGols = jogos.stream()
                .mapToInt(jogo -> jogo.getMandantePlacar() + jogo.getVisitantePlacar())
                .max()
                .orElse(0);


        List<Jogo> jogosComMaisGols = jogos.stream()
                .filter(jogo -> jogo.getMandantePlacar() + jogo.getVisitantePlacar() == maxGols)
                .collect(Collectors.toList());


        List<Map.Entry<String, Long>> listaFinal = jogosComMaisGols.stream()
                .map(jogo -> new AbstractMap.SimpleEntry<>(
//                        jogo.getMandante() + " x " + jogo.getVisitante(),
                        jogo.getMandante() + " " + jogo.getMandantePlacar() + " x " + jogo.getVisitantePlacar() + " " +  jogo.getVisitante(),
                        Long.valueOf(jogo.getData().getYear())
                ))
                .collect(Collectors.toList());

        return listaFinal;
    }




}
