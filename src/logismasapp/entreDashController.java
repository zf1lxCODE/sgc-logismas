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
public class entreDashController implements Initializable {
    @FXML
    private Button procesBtn;
    @FXML
    private AnchorPane compDashPane;
    @FXML
    private Button evalBtn;
    @FXML
    private Button planBtn;
    @FXML
    private Button guiasBtn;
    @FXML
    private Button registroBtn;
    @FXML
    private Button otroBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="entreDash.fxml";
    }


    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText = otroBtn.getText();
        data.tbName = "otrosentre";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void procesAction(ActionEvent event) throws IOException {
        data.headText = procesBtn.getText();
        data.tbName = "procesentre";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void evalAction(ActionEvent event) throws IOException {
        data.headText = evalBtn.getText();
        data.tbName = "evalentre";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void planAction(ActionEvent event) throws IOException {
        data.headText = planBtn.getText();
        data.tbName = "planentre";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void guiasAction(ActionEvent event) throws IOException {
        data.headText = guiasBtn.getText();
        data.tbName = "guiasentre";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void registroAction(ActionEvent event) throws IOException {
        data.headText = registroBtn.getText();
        data.tbName = "registroentre";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

}
