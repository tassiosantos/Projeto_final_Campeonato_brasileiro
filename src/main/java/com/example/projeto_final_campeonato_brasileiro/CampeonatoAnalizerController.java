package com.example.projeto_final_campeonato_brasileiro;

import com.example.projeto_final_campeonato_brasileiro.Services.CampeonatoAnalyzerService;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class CampeonatoAnalizerController implements Initializable {
    @FXML
    private TableView tabela;

    @FXML
    private TableColumn c1;

    @FXML
    private TableColumn c2;

    @FXML
    private ChoiceBox<String> itemParaAnalisar;
    @FXML
    private Label welcomeText;

    private CampeonatoAnalyzerService campeonatoAnalyzerService = new CampeonatoAnalyzerService();

    private String[] itens;



    @FXML
    protected void onHelloButtonClick() {
        int opcao = getItemIndex(itens, itemParaAnalisar.getValue());
        ObservableList<Map.Entry<String, Long>> data = FXCollections.observableArrayList();
        ObservableList<Map.Entry<String, String>> dataString = FXCollections.observableArrayList();

        switch (opcao){
            case(0):
                c1.setText("Time");
                c2.setText("Vitórias");
                setDataFormat(data, campeonatoAnalyzerService.getTimeMaisVenceu(2008));
                setCellString(c1);
                setCellLong(c2);
                break;
            case(1):
                c1.setText("Estado");
                c2.setText("Jogos");
                setDataFormat(data, campeonatoAnalyzerService.getEstadoMenosJogos());
                setCellString(c1);
                setCellLong(c2);
                break;
            case(2):
                c1.setText("Jogador");
                c2.setText("Gols");
                setDataFormat(data, campeonatoAnalyzerService.getJogadorMaisGols());
                setCellString(c1);
                setCellLong(c2);
                break;
            case(3):
                c1.setText("Jogador");
                c2.setText("Pênaltis");
                setDataFormat(data, campeonatoAnalyzerService.getJogadorMaisGolsPenalts());
                setCellString(c1);
                setCellLong(c2);
                break;
            case(4):
                c1.setText("Jogador");
                c2.setText("Gols Contra");
                setDataFormat(data, campeonatoAnalyzerService.getJogadorMaisGolsContra());
                setCellString(c1);
                setCellLong(c2);
                break;
            case(5):
                c1.setText("Jogador");
                c2.setText("Amarelos");
                setDataFormat(data, campeonatoAnalyzerService.getJogadorMaisAmarelos());
                setCellString(c1);
                setCellLong(c2);
                break;
            case(6):
                c1.setText("Jogador");
                c2.setText("Vermelhos");
                setDataFormat(data, campeonatoAnalyzerService.getJogadorMaisVermelhos());
                setCellString(c1);
                setCellLong(c2);
                break;
            case(7):
                c1.setText("Partida");
                c2.setText("Placar");
                setDataFormatString(dataString, campeonatoAnalyzerService.getPlacarPartidaMaisGols());
                setCellString(c1);
                setCellStringValue(c2);
                break;
        }
        if(opcao != 7 ){
            tabela.setItems(data);
        }else{
            tabela.setItems(dataString);
        }


       }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.itens = new String[]{
                "Time que mais venceu jogos em 2008.",
                "Estado com menos jogos entre 2003 e 2022.",
                "Jogador que mais fez gols.",
                "Jogador que mais fez gols de pênaltis.",
                "Jogador que mais fez gols contra.",
                "Jogador que mais recebeu cartões amarelos.",
                "Jogador que mais recebeu cartões vermelhos.",
                "Placar da partida com mais gols."
        };

        itemParaAnalisar.getItems().addAll(itens);

    }


    private void setDataFormat(ObservableList<Map.Entry<String, Long>> data, List<Map.Entry<String, Long>> lista){
        for (Map.Entry<String, Long> entry : lista) {
            data.add(entry);
        }
    }

    private void setDataFormatString(ObservableList<Map.Entry<String, String>> data, List<Map.Entry<String, String>> lista){
        for (Map.Entry<String, String> entry : lista) {
            data.add(entry);
        }
    }

    private void setCellString(TableColumn cell){
        try{
            cell.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Long>, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Long>, String> param) {
                    return new SimpleStringProperty(param.getValue().getKey());
                }
            });
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellStringValue(TableColumn cell){
        try{
            cell.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, SimpleStringProperty>() {
                @Override
                public SimpleStringProperty call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> param) {
                    return new SimpleStringProperty(param.getValue().getValue());
                }
            });
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void setCellLong(TableColumn cell){
        try{
            cell.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Long>, Long>, SimpleLongProperty>() {
                @Override
                public SimpleLongProperty call(TableColumn.CellDataFeatures<Map.Entry<String, Long>, Long> param) {
                    return new SimpleLongProperty(param.getValue().getValue());
                }
            });
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private int getItemIndex(String[] lista, String opcao){

        for (int i = 0; i < lista.length ; i++) {
            if(lista[i].equals(opcao)){return i;}
        }

        return -1;

    }





}