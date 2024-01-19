/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logismasapp;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import jdk.jfr.internal.tool.Main;
import static logismasapp.JdbcDao.DATABASE_PASSWORD;
import static logismasapp.JdbcDao.DATABASE_URL;
import static logismasapp.JdbcDao.DATABASE_USERNAME;
import static logismasapp.JdbcDao.printSQLException;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PuestosController implements Initializable {

    @FXML
    private Label lblImg;
    @FXML
    private TextField nombreTF;
    @FXML
    private ComboBox<String> departamentoBox;
    @FXML
    private TextField codigoTF;
    @FXML
    private TableView<Puesto> tablaPuestos;

    File file;

    private TextField rutaTF;
    @FXML
    private TableColumn<Puesto, Integer> idCol;
    @FXML
    private TableColumn<Puesto, String> codigoCol;
    @FXML
    private TableColumn<Puesto, String> nombreCol;
    @FXML
    private TableColumn<Puesto, String> departamentoCol;
    @FXML
    private TableColumn<Puesto, String> revCol;
    @FXML
    private TableColumn<Puesto, String> fregistroCol;
    @FXML
    private TableColumn<Puesto, String> lastupdateCol;
    @FXML
    private TextField revTF;
    @FXML
    private AnchorPane puestosPane;

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            return connection;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
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

    public ObservableList<Puesto> getPuestosList() {
        ObservableList<Puesto> puestosList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM puestos";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Puesto puesto;
            while (rs.next()) {
                puesto = new Puesto(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("departamento"), rs.getString("rev"), rs.getString("recorded"), rs.getString("last_update"));
                puestosList.add(puesto);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return puestosList;
    }

    public void showPuestos() {
        ObservableList<Puesto> list = getPuestosList();

        idCol.setCellValueFactory(new PropertyValueFactory<Puesto, Integer>("id"));
        codigoCol.setCellValueFactory(new PropertyValueFactory<Puesto, String>("codigo"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<Puesto, String>("nombre"));
        departamentoCol.setCellValueFactory(new PropertyValueFactory<Puesto, String>("departamento"));
        revCol.setCellValueFactory(new PropertyValueFactory<Puesto, String>("rev"));
        fregistroCol.setCellValueFactory(new PropertyValueFactory<Puesto, String>("recorded"));
        lastupdateCol.setCellValueFactory(new PropertyValueFactory<Puesto, String>("last_update"));

        tablaPuestos.setItems(list);

    }

    private List<String> getDepartamentos() {
        List<String> options = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT nombre FROM departamentos";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                options.add(set.getString("nombre"));
            }
            statement.close();
            set.close();
            // Return the List
            return options;
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPuestos();
        departamentoBox.setItems(FXCollections.observableArrayList(getDepartamentos()));
    }

    @FXML
    private void handleMouseAction(MouseEvent event) throws SQLException {

        Puesto puesto = tablaPuestos.getSelectionModel().getSelectedItem();
        Connection conn = getConnection();
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        ps2 = conn.prepareStatement("SELECT * FROM puestos WHERE id = ?;");
        ps2.setInt(1, puesto.getId());
        rs2 = ps2.executeQuery();
        while (rs2.next()) {
            departamentoBox.getSelectionModel().select(rs2.getString("departamento"));
            revTF.setText(rs2.getString("rev"));
            nombreTF.setText(rs2.getString("nombre"));
            codigoTF.setText(rs2.getString("codigo"));
        }

    }

    @FXML
    private void agregaAction(ActionEvent event) throws IOException, SQLException {
        if (departamentoBox.getSelectionModel().getSelectedItem().equals("") || nombreTF.getText().equals("")
                || codigoTF.getText().equals("") || file == null || revTF.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("ASEGURATE DE LLENAR TOODS LOS CAMPOS");
            a.setTitle("ERROR");
            a.setHeaderText("LOGISMAS");
            a.showAndWait();
        } else {
            byte[] arch = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(arch);

            String sql = "INSERT INTO puestos (codigo, nombre, departamento, descripcion, rev) VALUES(?, ?, ?, ?, ?);";

            PreparedStatement ps = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigoTF.getText());
            ps.setString(2, nombreTF.getText());
            ps.setString(3, departamentoBox.getSelectionModel().getSelectedItem());
            ps.setBytes(4, arch);
            ps.setString(5, revTF.getText());

            System.out.println(sql);
            ps.executeUpdate();
            showPuestos();
            limpiar();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("El puesto se agregó satisfactoriamente!");
            a.setTitle("Enhorabuena!");
            a.setHeaderText("LOGISMAS");
            a.showAndWait();
        }
    }

    @FXML
    private void eliminarAction(ActionEvent event) {
        Puesto puesto = tablaPuestos.getSelectionModel().getSelectedItem();
        String query = "DELETE FROM `puestos` WHERE id= " + puesto.getId() + "";
        System.out.println(query);
        executeQuery(query);
        showPuestos();
    }

    private void limpiar() {
        departamentoBox.getSelectionModel().select("SELECCIONAR");
        file = null;
        revTF.setText("");
        nombreTF.setText("");
        codigoTF.setText("");
    }

    @FXML
    private void limpiarAction(ActionEvent event) {
        departamentoBox.getSelectionModel().select("SELECCIONAR");
        file = null;
        revTF.setText("");
        nombreTF.setText("");
        codigoTF.setText("");
        lblImg.setText("Sin seleccionar");
    }

    @FXML
    private void actualizarAction(ActionEvent event) throws FileNotFoundException, SQLException, IOException {
        Puesto puesto = tablaPuestos.getSelectionModel().getSelectedItem();
        if (file != null) {
            if (puesto != null) {
                byte[] arch = new byte[(int) file.length()];
                InputStream input = new FileInputStream(file);
                input.read(arch);
                String sql = "UPDATE puestos SET codigo = ?, nombre = ?, rev = ?, descripcion = ?, departamento = ? WHERE id = ?";
                PreparedStatement ps = null;
                Connection conn = getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, codigoTF.getText());
                ps.setString(2, nombreTF.getText());
                ps.setString(3, revTF.getText());
                ps.setBytes(4, arch);
                ps.setString(5, departamentoBox.getSelectionModel().getSelectedItem());

                System.out.println(sql);
                ps.executeUpdate();

                showPuestos();
                limpiar();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("El puesto se modificó satisfactoriamente!");
                a.setTitle("Enhorabuena!");
                a.setHeaderText("LOGISMAS");
                a.showAndWait();
            }
        } else {
            if (puesto != null) {
                String sql = "UPDATE puestos SET codigo = ?, nombre = ?, rev = ?, departamento = ? WHERE id = ?";
                PreparedStatement ps = null;
                Connection conn = getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, codigoTF.getText());
                ps.setString(2, nombreTF.getText());
                ps.setString(3, revTF.getText());
                ps.setString(4, departamentoBox.getSelectionModel().getSelectedItem());

                System.out.println(sql);
                ps.executeUpdate();
                showPuestos();
                limpiar();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("El puesto se modificó satisfactoriamente!");
                a.setTitle("Enhorabuena!");
                a.setHeaderText("LOGISMAS");
                a.showAndWait();
            }

        }
    }

    @FXML
    private void seleccionarArchivo(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        file = chooser.showOpenDialog(null);
        lblImg.setText("Seleccionado");
    }

    @FXML
    private void abrirSeleccionado(ActionEvent event) {
        Puesto puesto = tablaPuestos.getSelectionModel().getSelectedItem();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = conn.prepareStatement("SELECT descripcion FROM puestos WHERE id = ?;");
            ps.setInt(1, puesto.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.docx");
            out.write(datosPDF);
            //abrir archivo
            out.close();
            bos.close();
            Desktop.getDesktop().open(new File("new.docx"));

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }

    @FXML
    private void mostrarEmpleados(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Empleados.fxml"));
        puestosPane.getChildren().setAll(pane);
    }

}
