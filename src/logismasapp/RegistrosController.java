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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class RegistrosController implements Initializable {

    @FXML
    private TableView<Registro> tablaRegistros;
    @FXML
    private TableColumn<Registro, Integer> idCol;
    @FXML
    private TableColumn<Registro, String> codigoCol;
    @FXML
    private TableColumn<Registro, String> nombreCol;
    @FXML
    private TableColumn<Registro, String> revCol;
    @FXML
    private TableColumn<Registro, String> deptoCol;
    @FXML
    private TableColumn<Registro, String> lastupdateCol;
    @FXML
    private TableColumn<Registro, String> fregistroCol;
    @FXML
    private TableColumn<Registro, String> descCol;

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logismasdatabase", "root", "Fileton2015");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void showRegistros() {
        ObservableList<Registro> list = getRegistrosList();

        idCol.setCellValueFactory(new PropertyValueFactory<Registro, Integer>("id"));
        codigoCol.setCellValueFactory(new PropertyValueFactory<Registro, String>("codigo"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<Registro, String>("nombre"));
        descCol.setCellValueFactory(new PropertyValueFactory<Registro, String>("descripcion"));
        deptoCol.setCellValueFactory(new PropertyValueFactory<Registro, String>("departamento"));
        revCol.setCellValueFactory(new PropertyValueFactory<Registro, String>("rev"));
        fregistroCol.setCellValueFactory(new PropertyValueFactory<Registro, String>("fecharegistro"));
        lastupdateCol.setCellValueFactory(new PropertyValueFactory<Registro, String>("last_update"));

        tablaRegistros.setItems(list);

    }

    public ObservableList<Registro> getRegistrosList() {
        ObservableList<Registro> registroList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM registros";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Registro registro;
            while (rs.next()) {
                registro = new Registro(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("departamento"), rs.getString("rev"), rs.getString("fecharegistro"), rs.getString("last_update"));
                registroList.add(registro);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return registroList;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showRegistros();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Registro registro = tablaRegistros.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void agregaAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegistroDialog.fxml"));
        Scene fxmlFile = new Scene(root);
        Stage window = new Stage();
        window.setScene(fxmlFile);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("LOGISMAS REGISTROS");
        window.showAndWait();
    }

    @FXML
    private void editarAction(ActionEvent event) throws IOException {
        if (tablaRegistros.getSelectionModel().getSelectedItem() != null) {
            Registro registro = tablaRegistros.getSelectionModel().getSelectedItem();
            ObservableList<Registro> list = getRegistrosList();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistroDialog.fxml"));
            Parent root = null;
            root = loader.load();
            RegistroDialogController controlador = loader.getController();
            controlador.inicializaregistros(list, registro);
            Scene fxmlFile = new Scene(root);
            Stage window = new Stage();
            window.setScene(fxmlFile);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("LOGISMAS REGISTROS");
            window.showAndWait();
        }
    }

    @FXML
    private void actualizarAction(ActionEvent event) {
        showRegistros();
    }

    @FXML
    private void eliminarAction(ActionEvent event) {
        Registro registro = tablaRegistros.getSelectionModel().getSelectedItem();//Se toma el objeto "Registro" del elemento seleccionado en la tabla
        String query = "DELETE FROM `registros` WHERE id= " + registro.getId() + "";
        System.out.println(query);
        executeQuery(query);
        showRegistros();
    }

    @FXML
    private void openSelected(ActionEvent event) {

        Registro registro = tablaRegistros.getSelectionModel().getSelectedItem();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = conn.prepareStatement("SELECT archivo FROM registros WHERE id = ?;");
            ps.setInt(1, registro.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.xlsx");
            out.write(datosPDF);
            //abrir archivo
            out.close();
            bos.close();
            Desktop.getDesktop().open(new File("new.xlsx"));

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }

}
