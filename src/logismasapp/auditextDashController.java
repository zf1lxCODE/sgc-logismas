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
public class auditextDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    private Button procesBtn;
    private Button checkBtn;
    private Button ordenesBtn;
    private Button bitasBtn;
    private Button ambiBtn;
    @FXML
    private Button otrosBtn;
    @FXML
    private Button orgBtn;
    @FXML
    private Button clientesBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="prodDash.fxml";
    }

    @FXML
    private void orgAction(ActionEvent event) throws IOException {
        data.headText=orgBtn.getText();
        data.tbName = "orgauditext";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void clientesAction(ActionEvent event) throws IOException {
        data.headText=clientesBtn.getText();
        data.tbName = "clientesauditext";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosAction(ActionEvent event) throws IOException {
        data.headText=otrosBtn.getText();
        data.tbName = "otrosauditext";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
