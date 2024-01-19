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
public class mejoraDashController implements Initializable {

    @FXML
    private AnchorPane compDashPane;
    @FXML
    private Button procesBtn;
    @FXML
    private Button sugerBtn;
    @FXML
    private Button otroBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    data.escenaAnt="mejoraDash.fxml";
    }    

    @FXML
    private void procesAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "procesmej";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void sugerAction(ActionEvent event) throws IOException {
        data.headText=sugerBtn.getText();
        data.tbName = "sugermej";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText=otroBtn.getText();
        data.tbName = "otrosmej";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }
    
}
