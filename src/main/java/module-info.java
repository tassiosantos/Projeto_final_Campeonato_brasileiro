module com.example.projeto_final_campeonato_brasileiro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projeto_final_campeonato_brasileiro to javafx.fxml;
    exports com.example.projeto_final_campeonato_brasileiro;
}