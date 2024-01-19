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
public class accionesDashController implements Initializable {

    @FXML
    private AnchorPane compDashPane;
    @FXML
    private Button procesBtn;
    private Button sugerBtn;
    @FXML
    private Button otroBtn;
    @FXML
    private Button internasBtn;
    @FXML
    private Button externasBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    data.escenaAnt="accionesDash.fxml";
    }    

    @FXML
    private void procesAction(ActionEvent event) throws IOException {
        data.headText=procesBtn.getText();
        data.tbName = "procesacc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }


    @FXML
    private void otrosdocsAction(ActionEvent event) throws IOException {
        data.headText=otroBtn.getText();
        data.tbName = "otrosacc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void internasAction(ActionEvent event) throws IOException {
        data.headText=internasBtn.getText();
        data.tbName = "intacc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void externasAction(ActionEvent event) throws IOException {
        data.headText=externasBtn.getText();
        data.tbName = "extacc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        compDashPane.getChildren().setAll(pane);
    }
    
}
