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
public class prodnoDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button otrosBtn;
    @FXML
    private Button detenidoBtn;
    @FXML
    private Button retornopBtn;
    @FXML
    private Button retornocBtn;
    @FXML
    private Button pncinternoBtn;
    @FXML
    private Button pncextBtn;
    private Button alertasBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="prodnoDash.fxml";
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "procespnc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText=otrosBtn.getText();
        data.tbName = "otrospnc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void detenidoAction(ActionEvent event) throws IOException {
        data.headText=detenidoBtn.getText();
        data.tbName = "detenidopnc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void retornopAction(ActionEvent event) throws IOException {
        data.headText=retornopBtn.getText();
        data.tbName = "retornop";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void retornocAction(ActionEvent event) throws IOException {
        data.headText=retornocBtn.getText();
        data.tbName = "retornoc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void pncinternoAction(ActionEvent event) throws IOException {
        data.headText=pncinternoBtn.getText();
        data.tbName = "pncinterno";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void pncextBtn(ActionEvent event) throws IOException {
        data.headText=pncextBtn.getText();
        data.tbName = "pncext";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    private void alertasAction(ActionEvent event) throws IOException {
        data.headText=alertasBtn.getText();
        data.tbName = "alertasprodno";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
