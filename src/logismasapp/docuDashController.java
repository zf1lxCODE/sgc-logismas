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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class docuDashController implements Initializable {

    @FXML
    private AnchorPane rhDashPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void listadocuAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Procedimientos.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void registroAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Registros.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void instruAction(ActionEvent event) {

    }

    @FXML
    private void cambiosAction(ActionEvent event) {

    }

    @FXML
    private void customerchanAction(ActionEvent event) {

    }

}
