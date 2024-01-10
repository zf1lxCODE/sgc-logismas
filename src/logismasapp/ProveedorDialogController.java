/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logismasapp;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import logismasapp.Proveedor;
import logismasapp.Proveedor;
import logismasapp.Proveedor;

/**
 * FXML Controller class
 *
 * @author Víctor León
 */
public class ProveedorDialogController implements Initializable {

    @FXML
    private TextField txtNombreproveedor;
    @FXML
    private TextArea txtDescripcionproveedor;
    @FXML
    private TextField txtContactoproveedor;
    @FXML
    private TextField txtTelefonoproveedor;
    @FXML
    private TextField txtCorreoproveedor;
    @FXML
    private TextArea txtComentariosproveedor;

    private Proveedor prov;

    private ObservableList<Proveedor> proveedores;

    int idProveedor;
    private Label rataLBL;

    public Proveedor getProveedor() {
        return prov;
    }

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void guardarProveedor(ActionEvent event) {
        if (this.prov == null) {
            String query = "INSERT INTO `proveedores` (`nombre`, `descripcion`, `contacto`, `telefono`, `email`, `comentarios`) VALUES ('" + txtNombreproveedor.getText() + "','" + txtDescripcionproveedor.getText() + "','" + txtContactoproveedor.getText() + "','"
                    + txtTelefonoproveedor.getText() + "','" + txtCorreoproveedor.getText() + "','" + txtComentariosproveedor.getText() + "')";
            System.out.println(query);
            executeQuery(query);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("El proveedor se agregó satisfactoriamente!");
            a.setTitle("Enhorabuena!");
            a.setHeaderText("LOGISMAS");
            a.showAndWait();
        } else {
            String query = "UPDATE `proveedores` SET `nombre` = '" + txtNombreproveedor.getText() + "', `descripcion` = '" + txtDescripcionproveedor.getText() + "', `contacto` = '"
                    + txtContactoproveedor.getText() + "', `telefono` = '" + txtTelefonoproveedor.getText() + "', `email` = '" + txtCorreoproveedor.getText() + "', `comentarios` = '" + txtComentariosproveedor.getText() + "' WHERE (`idProveedor` = '" + this.prov.getIdProveedor() + "')";
            System.out.println(query);
            executeQuery(query);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("El proveedor se modificó satisfactoriamente!");
            a.setTitle("Enhorabuena!");
            a.setHeaderText("LOGISMAS");
            a.showAndWait();
        }
    }

    public void inicializapersonas(ObservableList<Proveedor> proveedores, Proveedor prov) {
        this.proveedores = proveedores;
        this.prov = prov;
        this.txtNombreproveedor.setText(prov.getNombre());
        this.txtDescripcionproveedor.setText(prov.getDescripcion());
        this.txtContactoproveedor.setText(prov.getContacto());
        this.txtTelefonoproveedor.setText(prov.getTelefono());
        this.txtCorreoproveedor.setText(prov.getEmail());
        this.txtComentariosproveedor.setText(prov.getComentarios());
        this.idProveedor = prov.getIdProveedor();
    }

}
