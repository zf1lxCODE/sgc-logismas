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
public class docuDashController implements Initializable {

    @FXML
    private AnchorPane rhDashPane;
    @FXML
    private Button docusintBtn;
    @FXML
    private Button docusextBtn;
    @FXML
    private Button instrucBtn;
    @FXML
    private Button regisBtn;
    @FXML
    private Button bitacoraBtn;
    @FXML
    private Button customBtn;
    @FXML
    private Button otrosBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    data.escenaAnt="docuDash.fxml";
    }

    @FXML
    private void instruAction(ActionEvent event) throws IOException {
        data.headText=instrucBtn.getText();
        data.tbName="listamaestrainstruc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void listadocuintAction(ActionEvent event) throws IOException {
        data.headText=docusintBtn.getText();
        data.tbName="listamaestradocint";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void listadodocuextAction(ActionEvent event) throws IOException {
        data.headText=docusextBtn.getText();
        data.tbName="listamaestradocext";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void registrosAction(ActionEvent event) throws IOException {
        data.headText=regisBtn.getText();
        data.tbName="listamaestraregis";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void cambiosintAction(ActionEvent event) throws IOException {
        data.headText=bitacoraBtn.getText();
        data.tbName="cambiosinternossgc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void customerchanAction(ActionEvent event) throws IOException {
        data.headText=customBtn.getText();
        data.tbName="changeslogsgc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocsdocsAction(ActionEvent event) throws IOException {
        data.headText=otrosBtn.getText();
        data.tbName="otrosdocsdocs";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        rhDashPane.getChildren().setAll(pane);
    }

}
