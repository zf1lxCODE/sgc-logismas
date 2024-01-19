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
public class caliDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button procesBtn;
    private Button checkBtn;
    private Button bitasBtn;
    @FXML
    private Button otrosBtn;
    private Button criteriosBtn;
    @FXML
    private Button certificadosBtn;
    private Button reportesBtn;
    @FXML
    private Button equipoBtn;
    @FXML
    private Button calenBtn;
    @FXML
    private Button fueraservicioBtn;
    @FXML
    private Button historialBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="caliDash.fxml";
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText = procesBtn.getText();
        data.tbName = "procescali";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText = otrosBtn.getText();
        data.tbName = "otroscali";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void certificadosAction(ActionEvent event) throws IOException {
        data.headText = certificadosBtn.getText();
        data.tbName = "certificadoscali";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void equipoAction(ActionEvent event) throws IOException {
        data.headText = equipoBtn.getText();
        data.tbName = "equipocali";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void calenAction(ActionEvent event) throws IOException {
        data.headText = calenBtn.getText();
        data.tbName = "calencali";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void fueraservicioAction(ActionEvent event) throws IOException {
        data.headText = fueraservicioBtn.getText();
        data.tbName = "fueraserviciocali";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void historialAction(ActionEvent event) throws IOException {
        data.headText = historialBtn.getText();
        data.tbName = "historialcali";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
