/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logismasapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logismasapp.Proveedor;
import logismasapp.Proveedor;
import logismasapp.Proveedor;

/**
 * FXML Controller class
 *
 * @author Víctor León
 */
public class ProveedoresController implements Initializable {

    @FXML
    private TableView<Proveedor> tablaProveedores;
    @FXML
    private TableColumn<Proveedor, Integer> idproveedorCol;
    @FXML
    private TableColumn<Proveedor, String> nombreproveedorCol;
    @FXML
    private TableColumn<Proveedor, String> descripcionproveedorCol;
    @FXML
    private TableColumn<Proveedor, String> contactoproveedorCol;
    @FXML
    private TableColumn<Proveedor, String> telefonoproveedorCol;
    @FXML
    private TableColumn<Proveedor, String> emailproveedorCol;
    @FXML
    private TableColumn<Proveedor, String> comentariosproveedorCol;
    @FXML
    private TableColumn<Proveedor, String> fecharegistroproveedoresCol;
    @FXML
    private TableColumn<Proveedor, String> fechaultimaactualizacionCol;

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logismasdatabase", "root", "Fileton2015");
            return conn;
        } catch (Exception ex) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ObservableList<Proveedor> getProveedoresList() {
        ObservableList<Proveedor> proveedorList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM proveedores";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Proveedor proveedor;
            while (rs.next()) {
                proveedor = new Proveedor(rs.getInt("idProveedor"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("contacto"), rs.getString("telefono"), rs.getString("email"), rs.getString("comentarios"), rs.getString("recorded"), rs.getString("last_update"));
                proveedorList.add(proveedor);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return proveedorList;
    }

    public void showProveedores() {
        ObservableList<Proveedor> list = getProveedoresList();

        idproveedorCol.setCellValueFactory(new PropertyValueFactory<Proveedor, Integer>("idProveedor"));
        nombreproveedorCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));
        descripcionproveedorCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("descripcion"));
        contactoproveedorCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("contacto"));
        telefonoproveedorCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("telefono"));
        emailproveedorCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("email"));
        comentariosproveedorCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("comentarios"));
        fecharegistroproveedoresCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("recorded"));
        fechaultimaactualizacionCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("last_update"));

        tablaProveedores.setItems(list);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showProveedores();

    }

    @FXML
    private void agregaAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProveedorDialog.fxml"));
        Scene fxmlFile = new Scene(root);
        Stage window = new Stage();
        window.setScene(fxmlFile);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("LOGISMAS PROVEEDORES");
        window.showAndWait();
    }

    @FXML
    private void editarAction(ActionEvent event) throws IOException {
        if (tablaProveedores.getSelectionModel().getSelectedItem() != null) {
            Proveedor proveedor = tablaProveedores.getSelectionModel().getSelectedItem();
            ObservableList<Proveedor> list = getProveedoresList();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProveedorDialog.fxml"));
            Parent root = null;
            root = loader.load();
            ProveedorDialogController controlador = loader.getController();
            controlador.inicializapersonas(list, proveedor);
            Scene fxmlFile = new Scene(root);
            Stage window = new Stage();
            window.setScene(fxmlFile);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("LOGISMAS PROVEEDORES");
            window.showAndWait();
        }
    }

    @FXML
    private void actualizarAction(ActionEvent event) {
        showProveedores();
    }

    @FXML
    private void eliminarAction(ActionEvent event) {
        Proveedor proveedor = tablaProveedores.getSelectionModel().getSelectedItem();
        String query = "DELETE FROM `proveedores` WHERE idProveedor = " + proveedor.getIdProveedor() + "";
        System.out.println(query);
        executeQuery(query);
        showProveedores();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Proveedor proveedor = tablaProveedores.getSelectionModel().getSelectedItem();
    }

}
