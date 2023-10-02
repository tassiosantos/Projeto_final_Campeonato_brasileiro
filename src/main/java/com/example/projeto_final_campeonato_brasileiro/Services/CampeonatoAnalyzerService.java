package com.example.projeto_final_campeonato_brasileiro.Services;

import com.example.projeto_final_campeonato_brasileiro.Entities.Cartao;
import com.example.projeto_final_campeonato_brasileiro.Entities.Estatistica;
import com.example.projeto_final_campeonato_brasileiro.Entities.Gol;
import com.example.projeto_final_campeonato_brasileiro.Entities.Jogo;
import com.example.projeto_final_campeonato_brasileiro.Repositories.CampeonatoAnalyzerRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    public static List<Map.Entry<String, Long>> getTimeMaisVenceu(int ano){

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

    public static List<Map.Entry<String,Long>> getEstadoMenosJogos(){
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


    public static List<Map.Entry<String, Long>> getJogadorMaisGols(){
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


    public static List<Map.Entry<String, Long>> getJogadorMaisGolsPenalts(){
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

    public static List<Map.Entry<String, Long>> getJogadorMaisGolsContra(){
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

    public static  List<Map.Entry<String, Long>> getJogadorMaisAmarelos(){
        List<Cartao> cartoesTotais = campeonatoAnalyzerRepository.get().getListaCartoes();

        Map<String, Long> cartoesJogador = cartoesTotais.stream()
                .filter(cartao -> cartao.getCartao().equals("Amarelo"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        Long maisAmarelos = cartoesJogador.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);

        List<Map.Entry<String, Long>> jogadoresMaisAmarelos = cartoesJogador.entrySet().stream()
                .filter(jogador -> jogador.getValue() == maisAmarelos).toList();


     return jogadoresMaisAmarelos;
    }


    public static List<Map.Entry<String, Long>> getJogadorMaisVermelhos(){
        List<Cartao> cartoesTotais = campeonatoAnalyzerRepository.get().getListaCartoes();

        Map<String, Long> cartoesJogador = cartoesTotais.stream()
                .filter(cartao -> cartao.getCartao().equals("Vermelho"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        Long maisVermelhos = cartoesJogador.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);

        List<Map.Entry<String, Long>> jogadoresMaisVermelhos = cartoesJogador.entrySet().stream()
                .filter(jogador -> jogador.getValue() == maisVermelhos).toList();


        return jogadoresMaisVermelhos;
    }


    public String getPlacarPartidaMaisGols(){

        return null;
    }


    public static void main(String[] args) {
        CampeonatoAnalyzerService campeonatoAnalyzerService = new CampeonatoAnalyzerService();
        System.out.println(getJogadorMaisGolsPenalts());
    }




}
