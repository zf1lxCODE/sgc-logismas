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
public class almaDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button otrosBtn;
    @FXML
    private Button insumosBtn;
    @FXML
    private Button montaBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="almaDash.fxml";
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText = procesBtn.getText();
        data.tbName = "procesalma";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText = otrosBtn.getText();
        data.tbName = "otrosalma";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void insumosAction(ActionEvent event) throws IOException {
        data.headText = insumosBtn.getText();
        data.tbName = "insualma";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void montaAction(ActionEvent event) throws IOException {
        data.headText = montaBtn.getText();
        data.tbName = "montaalma";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
