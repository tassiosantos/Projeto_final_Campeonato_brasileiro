package com.example.projeto_final_campeonato_brasileiro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CampeonatoAnalizerController implements Initializable {
    @FXML
    private ChoiceBox itemParaAnalisar;
    @FXML
    private Label exibirSelecionado;

    @FXML
    protected void onHelloButtonClick() {


        exibirSelecionado.setText("asd");



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] itensParaAnalisar = {
                "Time que mais venceu jogos em 2008.",
                "Estado com menos jogos entre 2003 e 2022.",
                "Jogador que mais fez gols.",
                "Jogador que mais fez gols de pênaltis.",
                "Jogador que mais fez gols contra.",
                "Jogador que mais recebeu cartões amarelos.",
                "Jogador que mais recebeu cartões vermelhos.",
                "Placar da partida com mais gols."
        };

        itemParaAnalisar.getItems().addAll(itensParaAnalisar);

    }
}