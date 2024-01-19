/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logismasapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class auditintDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button checkBtn;
    @FXML
    private Button otrosBtn;
    @FXML
    private Button lineamientosBtn;
    @FXML
    private Button guiaBtn;
    @FXML
    private Button formatosBtn;
    @FXML
    private Button resultadosBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    data.escenaAnt="auditintDash.fxml";
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "procesaudint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText=otrosBtn.getText();
        data.tbName = "otrosaudint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void lineamientosAction(ActionEvent event) throws IOException {
        data.headText=lineamientosBtn.getText();
        data.tbName = "lineaaudint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void guiaAction(ActionEvent event) throws IOException {
        data.headText=guiaBtn.getText();
        data.tbName = "guiaaudint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void checkAction(ActionEvent event) throws IOException {
        data.headText=checkBtn.getText();
        data.tbName = "checkaudint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void formatosAction(ActionEvent event) throws IOException {
        data.headText=formatosBtn.getText();
        data.tbName = "formatosaudint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void resultadosAction(ActionEvent event) throws IOException {
        data.headText=resultadosBtn.getText();
        data.tbName = "resultadosaudint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
