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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class gerDashController implements Initializable {

    @FXML
    private AnchorPane gerDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button politicabBtn;
    @FXML
    private Button organiBtn;
    @FXML
    private Button descripBtn;
    @FXML
    private Button objeticalBtn;
    @FXML
    private Button matrespoisoBtn;
    @FXML
    private Button matcomuBtn;
    @FXML
    private Button revgerenBtn;
    @FXML
    private Button climaBtn;
    @FXML
    private Button otrosBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="gerDash.fxml";
    }

    @FXML
    private void descripAction(ActionEvent event) throws IOException {
        data.headText=descripBtn.getText();
        data.tbName = "";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Puestos.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void poliAction(ActionEvent event) throws IOException {
        data.headText=politicabBtn.getText();
        data.tbName = "politicas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void organiAction(ActionEvent event) throws IOException {
        data.headText=organiBtn.getText();
        data.tbName = "organigramas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
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
        data.headText=matrespoisoBtn.getText();
        data.tbName = "respoisos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void matcomuAction(ActionEvent event) throws IOException {
        data.headText=matcomuBtn.getText();
        data.tbName = "comunicaciones";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsgerAction(ActionEvent event) throws IOException {
        data.headText=otrosBtn.getText();
        data.tbName = "otrosdocsger";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void revgerencialAction(ActionEvent event) throws IOException {
        data.headText=revgerenBtn.getText();
        data.tbName = "revgerencial";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void climaAction(ActionEvent event) throws IOException {
        data.headText=climaBtn.getText();
        data.tbName = "climalaboral";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void procesAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "procesger";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        gerDashPane.getChildren().setAll(pane);
    }
    
}
