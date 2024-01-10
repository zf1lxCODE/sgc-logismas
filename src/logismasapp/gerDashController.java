/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class gerDashController implements Initializable {

    @FXML
    private AnchorPane gerDashPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void poliAction(ActionEvent event) throws IOException {
        data.tbName = "politicas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void organiAction(ActionEvent event) throws IOException {
        data.tbName = "organigramas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void alcanceAction(ActionEvent event) throws IOException {
        data.tbName = "alcances";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void descripAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Puestos.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void objeticalAction(ActionEvent event) throws IOException {
        data.tbName = "objetivos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void matrespisoAction(ActionEvent event) throws IOException {
        data.tbName = "respoisos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void matcomuAction(ActionEvent event) throws IOException {
        data.tbName = "comunicaciones";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);

    }

}
