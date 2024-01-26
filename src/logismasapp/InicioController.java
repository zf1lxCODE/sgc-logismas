/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logismasapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import jdk.jfr.internal.tool.Main;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InicioController implements Initializable {

    @FXML
    private AnchorPane prodDashPane;
    @FXML
    private Button mensajesBtn;
    @FXML
    private Button tareasBtn;
    @FXML
    private Button docuspendientesBtn;
    @FXML
    private Label mensajespendientesQty;
    @FXML
    private Label tareaspendientesQty;
    @FXML
    private Label docuspendientesQty;
    JdbcDao jdbc = new JdbcDao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.escenaAnt = "Inicio.fxml";
        try {
            getMsjsRecibidos();
        } catch (SQLException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mensajespendientesQty.setText(String.valueOf(data.cantidadMsjsRecibidos));
    }

    @FXML
    private void mensajesAction(ActionEvent event) throws IOException {
        data.headText = mensajesBtn.getText();
        data.tbName = "mensajes";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Mensajes.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void tareasAction(ActionEvent event) throws IOException {
        data.headText = tareasBtn.getText();
        data.tbName = "tareas";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Tareas.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    @FXML
    private void docuspendientesAction(ActionEvent event) throws IOException {
        data.headText = docuspendientesBtn.getText();
        data.tbName = "docuspendientes";
        AnchorPane pane = FXMLLoader.load(getClass().getResource("DocusPendientes.fxml"));
        prodDashPane.getChildren().setAll(pane);
    }

    private void getMsjsRecibidos() throws SQLException {
        data.cantidadMsjsRecibidos = 0;
        String query = "SELECT * FROM mensajes WHERE destinatario='" + data.username + "' AND estado= 'SIN LEER'";
        System.out.println(query);
        Statement st;
        ResultSet rs;
        try {
            st = jdbc.getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                data.cantidadMsjsRecibidos = data.cantidadMsjsRecibidos + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
