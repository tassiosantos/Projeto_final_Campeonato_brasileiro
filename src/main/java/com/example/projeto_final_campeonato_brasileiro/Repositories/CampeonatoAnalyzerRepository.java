package com.example.projeto_final_campeonato_brasileiro.Repositories;

import com.example.projeto_final_campeonato_brasileiro.Entities.*;
import com.example.projeto_final_campeonato_brasileiro.Services.CampeonatoAnalyzerService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CampeonatoAnalyzerRepository implements Repository<CampeonatoAnalyzer, Long> {

    String cartaoCsv;
    String estatisticaCsv;
    String golCsv;
    String jogoCsv;

    public CampeonatoAnalyzerRepository(String cartaoCsv, String estatisticaCsv, String golCsv, String jogoCsv){
        this.cartaoCsv = cartaoCsv;
        this.estatisticaCsv = estatisticaCsv;
        this.golCsv = golCsv;
        this.jogoCsv = jogoCsv;
    }


    public CampeonatoAnalyzerRepository(){
        cartaoCsv = "src/main/java/com/example/projeto_final_campeonato_brasileiro/Repositories/campeonato-brasileiro-cartoes.csv";
        estatisticaCsv = "src/main/java/com/example/projeto_final_campeonato_brasileiro/Repositories/campeonato-brasileiro-estatisticas-full.csv";
        golCsv = "src/main/java/com/example/projeto_final_campeonato_brasileiro/Repositories/campeonato-brasileiro-gols.csv";
        jogoCsv = "src/main/java/com/example/projeto_final_campeonato_brasileiro/Repositories/campeonato-brasileiro-full.csv";
    }


    @Override
    public CampeonatoAnalyzer get() {
        return new CampeonatoAnalyzer(setCartoes(), setEstatisticas(), setGols(), setJogos());
    }

    private List<Cartao> setCartoes(){
        String line;
        String csvSplitBy = ",";
        List<Cartao> cartoes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cartaoCsv))) {
            while ((line = br.readLine()) != null) {

                String[] cartaoString = line.split(csvSplitBy);

                cartaoString = tratarCSV(cartaoString);

                // Ignora cabeçalho
                if(!cartaoString[0].equals("partida_id")) {
                    Cartao cartao = new Cartao(
                            (!cartaoString[0].isEmpty() ?Integer.parseInt(cartaoString[0]):-1),
                            (!cartaoString[1].isEmpty()?Integer.parseInt(cartaoString[1]):-1),
                            cartaoString[2],
                            cartaoString[3],
                            cartaoString[4],
                            (!cartaoString[5].isEmpty()?Integer.parseInt(cartaoString[5]):-1),
                            cartaoString[6],
                            (!cartaoString[7].isEmpty()?tratarMinutos(cartaoString[7]):-1)
                    );

                    cartoes.add(cartao);

                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  cartoes;
    }


    private List<Estatistica> setEstatisticas(){
        String line;
        String csvSplitBy = ",";
        List<Estatistica> estatisticas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(estatisticaCsv))) {
            while ((line = br.readLine()) != null) {

                // Uso de vírgula como separador
                String[] estatisticaString = line.split(csvSplitBy);
                estatisticaString = tratarCSV(estatisticaString);

                // Ignora cabeçalho
                if(!estatisticaString[0].equals("partida_id")) {
                    Estatistica estatistica = new Estatistica(
                            (!estatisticaString[0].isEmpty() ?Integer.parseInt(estatisticaString[0]):-1),
                            (!estatisticaString[1].isEmpty() ?Integer.parseInt(estatisticaString[1]):-1),
                            estatisticaString[2],
                            (!estatisticaString[3].isEmpty() ?Integer.parseInt(estatisticaString[3]):-1),
                            (!estatisticaString[4].isEmpty() ?Integer.parseInt(estatisticaString[4]):-1),
                            estatisticaString[5],
                            (!estatisticaString[6].isEmpty() ?Integer.parseInt(estatisticaString[6]):-1),
                            estatisticaString[7],
                            (!estatisticaString[8].isEmpty() ?Integer.parseInt(estatisticaString[8]):-1),
                            (!estatisticaString[9].isEmpty() ?Integer.parseInt(estatisticaString[9]):-1),
                            (!estatisticaString[10].isEmpty() ?Integer.parseInt(estatisticaString[10]):-1),
                            (!estatisticaString[11].isEmpty() ?Integer.parseInt(estatisticaString[11]):-1),
                            (!estatisticaString[12].isEmpty() ?Integer.parseInt(estatisticaString[12]):-1)
                    );

                    estatisticas.add(estatistica);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  estatisticas;
    }

    private List<Gol> setGols(){
        String line;
        String csvSplitBy = ",";
        List<Gol> gols = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(golCsv))) {
            while ((line = br.readLine()) != null) {



                // Uso de vírgula como separador
                String[] golString = line.split(csvSplitBy);
                golString = tratarCSV(golString);

                // Ignora cabeçalho
                if(!golString[0].equals("partida_id")) {
                    Gol gol = new Gol(
                            (!golString[0].isEmpty()?Integer.parseInt(golString[0]):-1),
                            golString[1],
                            golString[2],
                            golString[3],
                            (!golString[0].isEmpty()?tratarMinutos(golString[0]):-1),
                            golString[5]
                    );

                    gols.add(gol);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  gols;
    }

    private List<Jogo> setJogos(){
        String line;
        String csvSplitBy = ",";
        List<Jogo> jogos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(jogoCsv))) {
            while ((line = br.readLine()) != null) {

                // Uso de vírgula como separador
                String[] jogoString = line.split(csvSplitBy);
                jogoString = tratarCSV(jogoString);

                // Ignora cabeçalho
                if(!jogoString[0].equals("ID")) {
                    Jogo jogo = new Jogo(
                            (!jogoString[0].isEmpty() ? Integer.parseInt(jogoString[0]) : -1), // ID
                            (!jogoString[1].isEmpty() ? Integer.parseInt(jogoString[1]) : -1), // rodada
                            LocalDate.parse(tratarData(jogoString[2]), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse(jogoString[3]), // hora
                            jogoString[4], // mandante
                            jogoString[5], // visitante
                            jogoString[6], // formacaoMandante
                            jogoString[7], // formacaoVisitante
                            jogoString[8], // tecnicoMandante
                            jogoString[9], // tecnicoVisitante
                            jogoString[10], // vencedor
                            jogoString[11], // arena
                            (!jogoString[12].isEmpty() ? Integer.parseInt(jogoString[12]) : -1), // mandantePlacar
                            (!jogoString[13].isEmpty() ? Integer.parseInt(jogoString[13]) : -1), // visitantePlacar
                            jogoString[14], // mandanteEstado
                            jogoString[15]  // visitanteEstado
                    );

                    jogos.add(jogo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  jogos;
    }

    private String tratarData(String data) {
        String dataAjustada = "";
        String[] dataSplit = data.split("/");
        if(dataSplit[0].length() == 1){
            dataAjustada += "0" + dataSplit[0] + "/";
        }else{
            dataAjustada += dataSplit[0] + "/";
        }
        if(dataSplit[1].length() == 1){
            dataAjustada += "0" + dataSplit[1] + "/";
        }else{
            dataAjustada += dataSplit[1] + "/";
        }

        dataAjustada += dataSplit[2];

        return dataAjustada;
    }


    public String[] tratarCSV(String[] csv){
        for (int i = 0; i < csv.length; i++) {
            csv[i] = csv[i].replace("\"", "");
        }
        return  csv;
    }

    public int tratarMinutos(String minutos){
        if(minutos.contains("+")){
            int tempo = Integer.parseInt(minutos.split("\\+")[0]);
            int acrescimo = Integer.parseInt(minutos.split("\\+")[1]);
            return tempo+acrescimo;
        }else if(minutos.equals("")){
            return -1;
        }else{
            return Integer.parseInt(minutos);
        }
    }



}
