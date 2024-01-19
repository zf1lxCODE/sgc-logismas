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
public class prodDashController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button checkBtn;
    @FXML
    private Button ordenesBtn;
    @FXML
    private Button bitasBtn;
    @FXML
    private Button ambiBtn;
    @FXML
    private Button otrosBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "procedimientosprod";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void checklistsAction(ActionEvent event) throws IOException {
        data.headText=checkBtn.getText();
        data.tbName = "checklistprod";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void ordenesAction(ActionEvent event) throws IOException {
        data.headText=ordenesBtn.getText();
        data.tbName = "ordenesproduc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void bitacorasAction(ActionEvent event) throws IOException {
        data.headText=bitasBtn.getText();
        data.tbName = "bitacorasprod";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void ambienteAction(ActionEvent event) throws IOException {
        data.headText=ambiBtn.getText();
        data.tbName = "ambienteprod";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText=otrosBtn.getText();
        data.tbName = "otrosdocsprod";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

}
