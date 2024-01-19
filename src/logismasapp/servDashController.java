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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class servDashController implements Initializable {

    @FXML
    private AnchorPane servDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button comuBtn;
    @FXML
    private Button encuBtn;
    @FXML
    private Button ordenesBtn;
    @FXML
    private Button inciBtn;
    @FXML
    private Button reviBtn;
    @FXML
    private Button otrosBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="servDash.fxml";
    }

    @FXML
    private void procesAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "processerv";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        servDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void satisclienteAction(ActionEvent event) throws IOException {
        data.headText=encuBtn.getText();
        data.tbName = "satiscliente";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        servDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void ordenestrabajoAction(ActionEvent event) throws IOException {
        data.headText=ordenesBtn.getText();
        data.tbName = "ordenestrabajo";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        servDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void incipropiAction(ActionEvent event) throws IOException {
        data.headText=inciBtn.getText();
        data.tbName = "incipropis";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        servDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrodocsAction(ActionEvent event) throws IOException {
        data.headText=otrosBtn.getText();
        data.tbName = "otrosdocsserv";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        servDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void matcomuclienteAction(ActionEvent event) throws IOException {
        data.headText=comuBtn.getText();
        data.tbName = "matcomuclientserv";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        servDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void revisionrecursosAction(ActionEvent event) throws IOException {
        data.headText=reviBtn.getText();
        data.tbName = "revisionrecursos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        servDashPane.getChildren().setAll(pane);
    }

}
