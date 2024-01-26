/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Víctor León
 */
public class sgcDashController implements Initializable {

    @FXML
    private AnchorPane sgcDashPane;
    @FXML
    private Button fodaBtn;
    @FXML
    private Button resultadosBtn;
    @FXML
    private Button perfKpiBtn;
    @FXML
    private Button riesgosBtn;
    @FXML
    private Button procesosBtn;
    @FXML
    private Button misionBtn;
    @FXML
    private Button visionBtn;
    @FXML
    private Button topmanBtn;
    @FXML
    private Button partesBtn;
    @FXML
    private Button tortugasBtn;
    @FXML
    private Button otrossgcBtn;
    @FXML
    private Button procedimientosBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt="sgcDash.fxml";
    }

    @FXML
    private void fodaAction(ActionEvent event) throws IOException {
        data.headText=fodaBtn.getText();
        data.tbName = "fodas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void kpiAction(ActionEvent event) throws IOException {
        data.headText=resultadosBtn.getText();
        data.tbName = "kpis";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void riesgosAction(ActionEvent event) throws IOException {
        data.headText=riesgosBtn.getText();
        data.tbName = "riesgos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void mapeoAction(ActionEvent event) throws IOException {
        data.headText=procesosBtn.getText();
        data.tbName = "mapeos";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void misionAction(ActionEvent event) throws IOException {
        data.headText=misionBtn.getText();
        data.tbName = "misiones";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void visionAction(ActionEvent event) throws IOException {
        data.headText=visionBtn.getText();
        data.tbName = "visiones";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void topmanAction(ActionEvent event) throws IOException {
        data.headText=topmanBtn.getText();
        data.tbName = "topmans";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void partesAction(ActionEvent event) throws IOException {
        data.headText=partesBtn.getText();
        data.tbName = "partes";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void tortugasAction(ActionEvent event) throws IOException {
        data.headText=tortugasBtn.getText();
        data.tbName = "tortugas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void perfileskpiAction(ActionEvent event) throws IOException {
        data.headText=perfKpiBtn.getText();
        data.tbName = "perfileskpi";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void otrosdocssgcsAction(ActionEvent event) throws IOException {
        data.headText=otrossgcBtn.getText();
        data.tbName = "otrosdocssgc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void procedimientosAction(ActionEvent event) throws IOException {
        data.headText=procedimientosBtn.getText();
        data.tbName = "processgc";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Docus.fxml"));
        sgcDashPane.getChildren().setAll(pane);
    }

}
