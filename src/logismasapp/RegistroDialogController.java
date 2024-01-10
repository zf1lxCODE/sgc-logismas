/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logismasapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RegistroDialogController implements Initializable {

    @FXML
    private TextField codigoTF;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField revTF;
    @FXML
    private TextArea descripcionTA;
    @FXML
    private TextField departamentoTF;
    @FXML
    private Button btnseleccionar;

    private TextField rutaTF;

    private Registro reg;

    private ObservableList<Registro> registros;

    int idRegistro;

    File file;

    public Registro getRegistro() {
        return reg;
    }

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

    public void inicializaregistros(ObservableList<Registro> registros, Registro reg) {
        this.registros = registros;
        this.reg = reg;
        this.codigoTF.setText(reg.getCodigo());
        this.nombreTF.setText(reg.getNombre());
        this.descripcionTA.setText(reg.getDescripcion());
        this.departamentoTF.setText(reg.getDepartamento());
        this.idRegistro = reg.getId();
        this.revTF.setText(reg.getRev());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void elegirRuta(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        file = chooser.showOpenDialog(null);
    }

    @FXML
    private void guardarProce(ActionEvent event) throws SQLException, IOException {

        if (this.reg == null) {
            byte[] arch = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(arch);

            String sql = "INSERT INTO registros (codigo, nombre, descripcion, departamento, rev, archivo) VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigoTF.getText());
            ps.setString(2, nombreTF.getText());
            ps.setString(3, descripcionTA.getText());
            ps.setString(4, departamentoTF.getText());
            ps.setString(5, revTF.getText());
            ps.setBytes(6, arch);

            System.out.println(sql);
            ps.executeUpdate();

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("El proveedor se agregó satisfactoriamente!");
            a.setTitle("Enhorabuena!");
            a.setHeaderText("LOGISMAS");
            a.showAndWait();
        } else {
            String query = "UPDATE `registros` SET `codigo` = '" + codigoTF.getText() + "', `nombre` = '" + nombreTF.getText() + "', `descripcion` = '"
                    + descripcionTA.getText() + "', `departamento` = '" + departamentoTF.getText() + "', `ruta` = '" + rutaTF.getText() + "' WHERE (`id` = '" + this.reg.getId() + "')";
            System.out.println(query);
            executeQuery(query);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("El proveedor se modificó satisfactoriamente!");
            a.setTitle("Enhorabuena!");
            a.setHeaderText("LOGISMAS");
            a.showAndWait();
        }

    }

}
