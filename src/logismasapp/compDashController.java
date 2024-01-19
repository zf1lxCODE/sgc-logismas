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
public class compDashController implements Initializable {

    @FXML
    private AnchorPane compDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button provesBtn;
    @FXML
    private Button requisBtn;
    @FXML
    private Button listaBtn;
    @FXML
    private Button evalBtn;
    @FXML
    private Button otroBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    data.escenaAnt="compDash.fxml";
    }

    @FXML
    private void proveedoresAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Proveedores.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void procesadquiAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "procesadqui";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void requisAction(ActionEvent event) throws IOException {
        data.headText=requisBtn.getText();
        data.tbName = "requis";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void listaprovesAction(ActionEvent event) throws IOException {
        data.headText=listaBtn.getText();
        data.tbName = "listaproves";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void evaluacionprovesAction(ActionEvent event) throws IOException {
        data.headText=evalBtn.getText();
        data.tbName = "evalproves";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText=otroBtn.getText();
        data.tbName = "otrosdocsadqui";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

}
