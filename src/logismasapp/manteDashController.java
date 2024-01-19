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
public class manteDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button otrosBtn;
    @FXML
    private Button fueraservicioBtn;
    @FXML
    private Button historialBtn;
    @FXML
    private Button calendarioBtn;
    @FXML
    private Button correctivoBtn;
    @FXML
    private Button tablerosBtn;
    @FXML
    private Button bitasBtn;
    @FXML
    private Button checkBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="manteDash.fxml";
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText = procesBtn.getText();
        data.tbName = "procesmante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText = otrosBtn.getText();
        data.tbName = "otrosmante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void fueraservicioAction(ActionEvent event) throws IOException {
        data.headText = fueraservicioBtn.getText();
        data.tbName = "fueraserviciomante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void historialAction(ActionEvent event) throws IOException {
        data.headText = historialBtn.getText();
        data.tbName = "historialmante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void calendarioAction(ActionEvent event) throws IOException {
        data.headText = calendarioBtn.getText();
        data.tbName = "calendariomante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void correctivoAction(ActionEvent event) throws IOException {
        data.headText = correctivoBtn.getText();
        data.tbName = "correctivomante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void tablerosAction(ActionEvent event) throws IOException {
        data.headText = tablerosBtn.getText();
        data.tbName = "tablerosmante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void bitasAction(ActionEvent event) throws IOException {
        data.headText = bitasBtn.getText();
        data.tbName = "bitasmante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void checkAction(ActionEvent event) throws IOException {
        data.headText = checkBtn.getText();
        data.tbName = "checkmante";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
