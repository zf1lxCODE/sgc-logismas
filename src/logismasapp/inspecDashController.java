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
public class inspecDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button checkBtn;
    @FXML
    private Button bitasBtn;
    @FXML
    private Button otrosBtn;
    @FXML
    private Button criteriosBtn;
    @FXML
    private Button certificadosBtn;
    @FXML
    private Button reportesBtn;
    @FXML
    private Button alertasBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="inspecDash.fxml";
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText = procesBtn.getText();
        data.tbName = "procesinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText = otrosBtn.getText();
        data.tbName = "otrosinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void criteriosAction(ActionEvent event) throws IOException {
        data.headText = criteriosBtn.getText();
        data.tbName = "criteriosinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void checkAction(ActionEvent event) throws IOException {
        data.headText = checkBtn.getText();
        data.tbName = "checkinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void bitasAction(ActionEvent event) throws IOException {
        data.headText = bitasBtn.getText();
        data.tbName = "bitasinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void certificadosAction(ActionEvent event) throws IOException {
        data.headText = certificadosBtn.getText();
        data.tbName = "certificadosinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void reportesAction(ActionEvent event) throws IOException {
        data.headText = reportesBtn.getText();
        data.tbName = "reportesinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void alertasAction(ActionEvent event) throws IOException {
        data.headText = alertasBtn.getText();
        data.tbName = "alertasinspec";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
