/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logismasapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Víctor León
 */
public class sgcDashController implements Initializable {

    @FXML
    private AnchorPane sgcDashPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void fodaAction(ActionEvent event) throws IOException {
        data.tbName = "fodas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void kpiAction(ActionEvent event) {

    }

    @FXML
    private void riesgosAction(ActionEvent event) throws IOException {
        data.tbName = "riesgos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void mapeoAction(ActionEvent event) throws IOException {
        data.tbName = "mapeos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void misionAction(ActionEvent event) throws IOException {
        data.tbName = "misiones";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void visionAction(ActionEvent event) throws IOException {
        data.tbName = "visiones";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void topmanAction(ActionEvent event) throws IOException {
        data.tbName = "topmans";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void partesAction(ActionEvent event) throws IOException {
        data.tbName = "partes";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void tortugasAction(ActionEvent event) throws IOException {
        data.tbName = "tortugas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

}
