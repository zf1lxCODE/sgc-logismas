/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logismasapp;

import com.mysql.cj.jdbc.exceptions.PacketTooBigException;
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
import java.sql.SQLSyntaxErrorException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MensajesController implements Initializable {

    @FXML
    private TableColumn<Mensaje, Integer> idCol;

    Alertas a = new Alertas();
    JdbcDao jdbc = new JdbcDao();
    @FXML
    private Label topLabel;
    @FXML
    private Button volverBtn;
    @FXML
    private AnchorPane docusPane;
    @FXML
    private TableColumn<Mensaje, String> remitenteCol;
    @FXML
    private TableColumn<Mensaje, String> asuntoCol;
    @FXML
    private TableColumn<Mensaje, String> fechaCol;
    @FXML
    private TableColumn<Mensaje, String> estadoCol;
    private int c = 0;
    Mensaje aux1;
    @FXML
    private TableView<Mensaje> tablaMensajes;

    void showMensajes() {
        ObservableList<Mensaje> list = a.getMsjList();
        idCol.setCellValueFactory(new PropertyValueFactory<Mensaje, Integer>("id"));
        remitenteCol.setCellValueFactory(new PropertyValueFactory<Mensaje, String>("remitente"));
        asuntoCol.setCellValueFactory(new PropertyValueFactory<Mensaje, String>("asunto"));
        fechaCol.setCellValueFactory(new PropertyValueFactory<Mensaje, String>("fecha"));
        estadoCol.setCellValueFactory(new PropertyValueFactory<Mensaje, String>("estado"));
        tablaMensajes.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        topLabel.setText(data.headText);
        showMensajes();
    }

    @FXML
    private void actualizarAction(ActionEvent event) {
        showMensajes();
    }

    @FXML
    private void eliminarAction(ActionEvent event) throws SQLException {
        if (tablaMensajes.getSelectionModel().getSelectedItem() != null) {
            Mensaje msj = tablaMensajes.getSelectionModel().getSelectedItem();
            if (msj != null) {
                if (a.confirmDelete()) {
                    String query = "DELETE FROM mensajes WHERE id = " + msj.getId() + "";
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    int auxc = 0;
                    try {
                        ps.executeLargeUpdate();
                    } catch (SQLSyntaxErrorException ex) {
                        auxc = 1;
                        a.noPermitido();
                    }
                    showMensajes();
                }
            }
        } else {
            a.noSelection();
        }
    }

    @FXML
    private void openMensaje(ActionEvent event) throws IOException, IOException, SQLException, SQLException {
        if (tablaMensajes.getSelectionModel().getSelectedItem() != null) {
            Mensaje mensaje = tablaMensajes.getSelectionModel().getSelectedItem();
            a.openMsj(mensaje);
            showMensajes();
        } else {
            a.noSelection();
            showMensajes();
        }
        showMensajes();
    }

    @FXML
    private void volverAction(ActionEvent event) throws IOException {
        AnchorPane panek = FXMLLoader.load(getClass().getResource(data.escenaAnt));
        docusPane.getChildren().setAll(panek);
    }

    @FXML
    private void dobleClick(MouseEvent event) throws IOException, SQLException {
        if (tablaMensajes.getSelectionModel().getSelectedItem() != null && c == 1) {
            if (tablaMensajes.getSelectionModel().getSelectedItem() == aux1) {
                a.openMsj(aux1);
                c = 0;
            }
        }
        if (tablaMensajes.getSelectionModel().getSelectedItem() != null && c == 0) {
            aux1 = tablaMensajes.getSelectionModel().getSelectedItem();
            c = c + 1;
        } else {
            c = 0;
        }
    }

    @FXML
    private void mensajesAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MensajeDialog.fxml"));
        Parent root = loader.load();
        a.openWindow(root);
        showMensajes();
    }


}
