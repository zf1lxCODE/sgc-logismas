/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logismasapp.Procedimiento;
import logismasapp.Procedimiento;
import logismasapp.Procedimiento;

/**
 * FXML Controller class
 *
 * @author Víctor León
 */
public class ProcedimientoDialogController implements Initializable {

    @FXML
    private TextField codigoTF;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField departamentoTF;

    @FXML
    private TextArea descripcionTA;
    @FXML
    private TextField revTF;
    @FXML
    private Button btnseleccionar;

    private TextField rutaTF;

    private Procedimiento proc;

    private ObservableList<Procedimiento> procedimientos;

    int idProcedimiento;

    File file;

    public Procedimiento getProcedimiento() {
        return proc;
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void inicializaprocedimientos(ObservableList<Procedimiento> procedimientos, Procedimiento proc) {
        this.procedimientos = procedimientos;
        this.proc = proc;
        this.codigoTF.setText(proc.getCodigo());
        this.nombreTF.setText(proc.getNombre());
        this.descripcionTA.setText(proc.getDescripcion());
        this.departamentoTF.setText(proc.getDepartamento());
        this.idProcedimiento = proc.getId();
        this.revTF.setText(proc.getRev());
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
    private void guardarProce(ActionEvent event) throws IOException, SQLException {
        if (this.proc == null) {
            byte[] arch = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(arch);

            String sql = "INSERT INTO procedimientos (codigo, nombre, descripcion, departamento, rev, archivo) VALUES(?, ?, ?, ?, ?, ?);";
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
            String query = "UPDATE `procedimientos` SET `codigo` = '" + codigoTF.getText() + "', `nombre` = '" + nombreTF.getText() + "', `descripcion` = '"
                    + descripcionTA.getText() + "', `departamento` = '" + departamentoTF.getText() + "', `ruta` = '" + rutaTF.getText() + "' WHERE (`id` = '" + this.proc.getId() + "')";
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
