package es.iesfranciscodelosrios.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import es.iesfranciscodelosrios.model.Read;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class PrimaryController implements Initializable{
    private Read r = new Read();
    private Thread t= new Thread(r);
    private boolean pausado = false;
    private boolean isShowm= false;
    private boolean isDM= false;
    private int contador = -1;
    private LocalDate hola = LocalDate.now();
    private ArrayList<String> guardar = new ArrayList<>();
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Label horas;
    @FXML
    private Label guardado;
    @FXML
    private Label status;
    @FXML
    private Label fecha;
    @FXML
    private Label minutos;
    @FXML
    private Label segundos;
    @FXML
    private Label puntos;
    @FXML
    private Label puntos2;
    @FXML
    private Rectangle startB;
    @FXML
    private Rectangle rec;
    @FXML
    private Rectangle pauseB;
    @FXML
    private Rectangle resetB;
    @FXML
    private Rectangle blackM;
    @FXML
    private Rectangle fech;

    @FXML
    private void Start(){
        startB.setVisible(false);
        pauseB.setVisible(true);
        t.start();
        r.suspendido.setSuspendido(false);

        horas.textProperty().bind(r.getFraseHora());
        minutos.textProperty().bind(r.getFraseMinuto());
        segundos.textProperty().bind(r.getFraseSegundo());
    }
    @FXML
    private void Pause(){
        if (pausado==false){
            startB.setVisible(false);
            pauseB.setVisible(true);

            r.suspendido.setSuspendido(true);

            horas.textProperty().bind(r.getFraseHora());
            minutos.textProperty().bind(r.getFraseMinuto());
            segundos.textProperty().bind(r.getFraseSegundo());

            contador++;
            guardar.add(horas.getText()+":"+minutos.getText()+":"+segundos.getText());

            guardado.setText(guardar.get(contador));
            guardado.setVisible(true);
            pausado=true;
        } else if (pausado){
            startB.setVisible(false);
            pauseB.setVisible(true);
            r.suspendido.setSuspendido(false);
            horas.textProperty().bind(r.getFraseHora());
            minutos.textProperty().bind(r.getFraseMinuto());
            segundos.textProperty().bind(r.getFraseSegundo());
            pausado=false;
            guardado.setVisible(false);
        }

    }

    @FXML
    private void Reset(){
        r.suspendido.setSuspendido(true);
        t.interrupt();
        pausado=true;

        horas.textProperty().bind(r.getFraseHora());
        minutos.textProperty().bind(r.getFraseMinuto());
        segundos.textProperty().bind(r.getFraseSegundo());

        r.setHora(new SimpleIntegerProperty(00));
        r.setMinuto(new SimpleIntegerProperty(00));
        r.setSegundo(new SimpleIntegerProperty(00));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        horas.textProperty().bind(r.getFraseHora());
        minutos.textProperty().bind(r.getFraseMinuto());
        segundos.textProperty().bind(r.getFraseSegundo());
    }

    @FXML
    public void showF(){
        if (!isShowm){
            fecha.setText(hola.getDayOfMonth()+"/"+hola.getMonthValue());
            fecha.setVisible(true);
            isShowm=true;
        }else{
            fecha.setVisible(false);
            isShowm=false;
        }

    }

    @FXML
    public void DarkMode(){
        if (!isDM){
            rec.setStyle("-fx-fill:  #404040;");
            startB.setStyle("-fx-rotate: 45; -fx-fill:  #404040;");
            pauseB.setStyle("-fx-rotate: 45; -fx-fill:  #404040;");
            blackM.setStyle("-fx-rotate: 45; -fx-fill:  #404040;");
            resetB.setStyle("-fx-rotate: 130;-fx-fill:  #404040;");
            fech.setStyle("-fx-rotate: 130;-fx-fill:  #404040;");
            anchor.setStyle("-fx-background-color: #282828;-fx-background-radius: 250;-fx-border-color: black;-fx-border-radius: 250;");
            pane1.setStyle("-fx-background-color:  #282828;-fx-background-radius: 250;");
            pane2.setStyle("-fx-background-color:  #282828;-fx-background-radius: 250;");
            pane3.setStyle("-fx-background-color:  #282828;-fx-background-radius: 250;");
            pane4.setStyle("-fx-background-color:  #282828;-fx-background-radius: 250;");
            isDM=true;
        }else{
            rec.setStyle("-fx-fill:  E8C98B;");
            startB.setStyle("-fx-rotate: 45; -fx-fill:  E8C98B;");
            pauseB.setStyle("-fx-rotate: 45; -fx-fill:  E8C98B;");
            blackM.setStyle("-fx-rotate: 45; -fx-fill:  E8C98B;");
            resetB.setStyle("-fx-rotate: 130;-fx-fill:  E8C98B;");
            fech.setStyle("-fx-rotate: 130;-fx-fill:  E8C98B;");
            anchor.setStyle("-fx-background-color: FFE7B9;-fx-background-radius: 250;-fx-border-color: black;-fx-border-radius: 250;");
            pane1.setStyle("-fx-background-color:  FFE7B9;-fx-background-radius: 250;");
            pane2.setStyle("-fx-background-color:  FFE7B9;-fx-background-radius: 250;");
            pane3.setStyle("-fx-background-color:  FFE7B9;-fx-background-radius: 250;");
            pane4.setStyle("-fx-background-color:  FFE7B9;-fx-background-radius: 250;");
            isDM=false;
        }

    }
}
