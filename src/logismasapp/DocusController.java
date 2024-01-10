/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logismasapp;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DocusController implements Initializable {

    @FXML
    private TableColumn<Docu, String> codigoCol;
    @FXML
    private TableColumn<Docu, String> nombreCol;
    @FXML
    private TableColumn<Docu, String> revCol;
    @FXML
    private TableColumn<Docu, String> lastupdateCol;
    @FXML
    private TableColumn<Docu, String> fregistroCol;
    @FXML
    private TableView<Docu> tablaDocus;
    @FXML
    private TableColumn<Docu, Integer> idCol;

    Alertas a = new Alertas();
    JdbcDao jdbc = new JdbcDao();

    private void showDocus() {
        ObservableList<Docu> list = a.getDocuList();
        idCol.setCellValueFactory(new PropertyValueFactory<Docu, Integer>("id"));
        codigoCol.setCellValueFactory(new PropertyValueFactory<Docu, String>("codigo"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<Docu, String>("nombre"));
        revCol.setCellValueFactory(new PropertyValueFactory<Docu, String>("rev"));
        fregistroCol.setCellValueFactory(new PropertyValueFactory<Docu, String>("fecharegistro"));
        lastupdateCol.setCellValueFactory(new PropertyValueFactory<Docu, String>("last_update"));
        tablaDocus.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDocus();
    }

    @FXML
    private void agregaAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DocuDialog.fxml"));
        Parent root = loader.load();
        a.openWindow(root);
    }

    @FXML
    private void editarAction(ActionEvent event) throws IOException {
        Docu docu = tablaDocus.getSelectionModel().getSelectedItem();
        if (docu != null) {
            ObservableList<Docu> list = a.getDocuList();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DocuDialog.fxml"));
            Parent root = loader.load();
            DocuDialogController controlador = loader.getController();
            controlador.inicializaDocus(list, docu);
            a.openWindow(root);
        }
    }

    @FXML
    private void actualizarAction(ActionEvent event) {
        showDocus();
    }

    @FXML
    private void eliminarAction(ActionEvent event) {
        Docu docu = tablaDocus.getSelectionModel().getSelectedItem();
        if (docu != null) {
            if (a.confirmDelete()) {
                String query = "DELETE FROM " + data.tbName + " WHERE id = " + docu.getId() + "";
                jdbc.executeQuery(query);
                System.out.println(query);
                showDocus();
            }
        }
    }

    @FXML
    private void openSelected(ActionEvent event) {
        Docu docu = tablaDocus.getSelectionModel().getSelectedItem();
        a.openFile(docu);
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }

}
