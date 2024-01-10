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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Víctor León
 */
public class DashboardMainController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private AnchorPane showPane;
    @FXML
    private ImageView imgUser;
    @FXML
    private Label lblUser;

    String username;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayUsername();
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DashboardMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        showPane.getChildren().setAll(pane);
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public AnchorPane getShowPane() {
        return showPane;
    }

    public void setShowPane(AnchorPane showPane) {
        this.showPane = showPane;
    }

    @FXML
    private void sgcAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sgcDash.fxml"));
        showPane.getChildren().setAll(pane);
    }

    @FXML
    private void inicioAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        showPane.getChildren().setAll(pane);
    }

    @FXML
    private void prodAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("prodDash.fxml"));
        showPane.getChildren().setAll(pane);
    }

    private void compAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("compDash.fxml"));
        showPane.getChildren().setAll(pane);
    }

    @FXML
    private void ingAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ingDash.fxml"));
        showPane.getChildren().setAll(pane);
    }

    @FXML
    private void respgerAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("gerDash.fxml"));
        showPane.getChildren().setAll(pane);
    }

    @FXML
    private void servicioAction(ActionEvent event) {
    }

    @FXML
    private void infodocAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("docuDash.fxml"));
        showPane.getChildren().setAll(pane);
    }

    @FXML
    private void adquiAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("compDash.fxml"));
        showPane.getChildren().setAll(pane);
    }

    @FXML
    private void importAction(ActionEvent event) {
    }

    @FXML
    private void inspecAction(ActionEvent event) {
    }

    @FXML
    private void caliAction(ActionEvent event) {
    }

    @FXML
    private void manteAction(ActionEvent event) {
    }

    @FXML
    private void almacenAction(ActionEvent event) {
    }

    @FXML
    private void producnoconAction(ActionEvent event) {
    }

    @FXML
    private void entrenaAction(ActionEvent event) {
    }

    @FXML
    private void accionescoAction(ActionEvent event) {
    }

    @FXML
    private void mejoracontiAction(ActionEvent event) {
    }

    @FXML
    private void auditoriasAction(ActionEvent event) {
    }

    public void displayUsername() {
        String user = data.username;
        lblUser.setText(user);
        System.out.println(user);
        System.out.println(lblUser.getText());
        System.out.println(lblUser.getText());
    }

}
