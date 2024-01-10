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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import jdk.jfr.internal.tool.Main;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EmpleadosController implements Initializable {

    @FXML
    private TableView<Empleado> tablaEmpleados;
    @FXML
    private TableColumn<Empleado, Integer> numempleadoCol;
    @FXML
    private TableColumn<Empleado, String> estadoCol;
    @FXML
    private TableColumn<Empleado, String> nombrecompletoCol;
    @FXML
    private TableColumn<Empleado, String> puestoCol;
    @FXML
    private TableColumn<Empleado, String> deptoCol;

    @FXML
    private TableColumn<Empleado, String> fingresoCol;
    @FXML
    private TableColumn<Empleado, String> telCol;

    @FXML
    private TableColumn<Empleado, String> curpCol;
    @FXML
    private TableColumn<Empleado, String> rfcCol;
    @FXML
    private TableColumn<Empleado, String> nssCol;
    @FXML
    private TextField nombrecompletoForm;
    @FXML
    private ComboBox<String> puestoForm;
    @FXML
    private ComboBox<String> departamentoForm;
    @FXML
    private ComboBox<String> generoForm;
    @FXML
    private TextField numempleadoForm;
    @FXML
    private TextField curpForm;
    @FXML
    private TextField rfcForm;
    @FXML
    private TextField nssForm;
    @FXML
    private TextField telefonoForm;
    @FXML
    private ImageView imageForm;
    @FXML
    private TextField domicilioForm;
    @FXML
    private DatePicker fechaingresoForm;
    @FXML
    private DatePicker fechanacimientoForm;
    @FXML
    private ComboBox<String> estadoForm;
    @FXML
    private TextField emailForm;

    File file;

    private TextField rutaTF;

    private Empleado emp;
    @FXML
    private Label lblImg;

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

    public ObservableList<Empleado> getEmpleadosList() {

        ObservableList<Empleado> empleadosList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM empleados";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Empleado empleado;
            while (rs.next()) {
                empleado = new Empleado(rs.getInt("numEmpleado"), rs.getString("estado"), rs.getString("nombreCompleto"), rs.getString("puesto"), rs.getString("departamento"), rs.getString("fechaIngreso"), rs.getString("numTelefono"), rs.getString("curp"), rs.getString("nss"), rs.getString("rfc"));
                empleadosList.add(empleado);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return empleadosList;
    }

    public void showEmpleados() {

        ObservableList<Empleado> list = getEmpleadosList();

        estadoCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("estado"));
        numempleadoCol.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("numEmpleado"));
        nombrecompletoCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombreCompleto"));
        puestoCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("puesto"));
        deptoCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("departamento"));
        fingresoCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("fechaIngreso"));
        telCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("numTelefono"));
        curpCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("curp"));
        rfcCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("rfc"));
        nssCol.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nss"));

        tablaEmpleados.setItems(list);

    }

    public ObservableList<Puesto> getPuestosList() {
        ObservableList<Puesto> puestoList = FXCollections.observableArrayList();
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
                puestoList.add(puesto);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return puestoList;
    }

    private List<String> getPuestos() {
        List<String> options = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT nombre FROM puestos";
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

    private List<String> getGeneros() {
        List<String> options = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT genero FROM generos";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                options.add(set.getString("genero"));
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

    private List<String> getEstados() {
        List<String> options = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT estado FROM estados";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                options.add(set.getString("estado"));
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

        showEmpleados();
        puestoForm.setItems(FXCollections.observableArrayList(getPuestos()));
        departamentoForm.setItems(FXCollections.observableArrayList(getDepartamentos()));
        generoForm.setItems(FXCollections.observableArrayList(getGeneros()));
        estadoForm.setItems(FXCollections.observableArrayList(getEstados()));
        estadoForm.getSelectionModel().select("SELECCIONAR");
        generoForm.getSelectionModel().select("SELECCIONAR");
        puestoForm.getSelectionModel().select("SELECCIONAR");
        departamentoForm.getSelectionModel().select("SELECCIONAR");

    }

    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    @FXML
    private void handleMouseAction(MouseEvent event) throws SQLException {
        Empleado empleado = tablaEmpleados.getSelectionModel().getSelectedItem();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;
        try {
            ps = conn.prepareStatement("SELECT foto FROM empleados WHERE numempleado = ?;");
            ps.setInt(1, empleado.getNumEmpleado());
            rs = ps.executeQuery();
            Image img = null;
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);
            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream(new File("fotoemp.jpg"));
            out.write(datosPDF);
            out.close();
            bos.close();
            Image imagex = new Image("file:fotoemp.jpg");
            imageForm.setImage(imagex);

        } catch (IOException | NumberFormatException | SQLException | NullPointerException ex) {
            System.out.println("Error al abrir imagen " + ex.getMessage());
        }
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        ps2 = conn.prepareStatement("SELECT * FROM empleados WHERE numempleado = ?;");
        ps2.setInt(1, empleado.getNumEmpleado());
        rs2 = ps2.executeQuery();
        while (rs2.next()) {
            numempleadoForm.setText(String.valueOf(empleado.getNumEmpleado()));
            estadoForm.getSelectionModel().select(rs2.getString("estado"));
            nombrecompletoForm.setText(rs2.getString("nombreCompleto"));
            generoForm.getSelectionModel().select(rs2.getString("genero"));
            fechanacimientoForm.setValue(LOCAL_DATE(rs2.getString("fechaNacimiento")));
            fechaingresoForm.setValue(LOCAL_DATE(rs2.getString("fechaIngreso")));
            telefonoForm.setText(rs2.getString("numTelefono"));
            curpForm.setText(rs2.getString("curp"));
            rfcForm.setText(rs2.getString("rfc"));
            nssForm.setText(rs2.getString("nss"));
            puestoForm.getSelectionModel().select(rs2.getString("puesto"));
            departamentoForm.getSelectionModel().select(rs2.getString("departamento"));
            domicilioForm.setText(rs2.getString("domicilio"));
            emailForm.setText(rs2.getString("email"));
        }

    }

    @FXML
    private void importarImagen(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        file = chooser.showOpenDialog(null);
        lblImg.setText("Seleccionado");
        Image image = new Image(file.toURI().toString());
        imageForm.setImage(image);
    }

    @FXML
    private void agregaAction(ActionEvent event) throws IOException, SQLException {
        if (estadoForm.getSelectionModel().getSelectedItem().equals("") || generoForm.getSelectionModel().getSelectedItem().equals("")
                || departamentoForm.getSelectionModel().getSelectedItem().equals("") || numempleadoForm.getText().equals("")
                || nombrecompletoForm.getText().equals("") || telefonoForm.getText().equals("") || curpForm.getText().equals("")
                || rfcForm.getText().equals("") || nssForm.getText().equals("") || domicilioForm.getText().equals("") || emailForm.getText().equals("")
                || fechaingresoForm.getValue() == null || fechanacimientoForm.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("ASEGURATE DE LLENAR TOODS LOS CAMPOS");
            a.setTitle("ERROR");
            a.setHeaderText("LOGISMAS");
            a.showAndWait();
        } else {
            if (file == null) {

                String sql = "INSERT INTO empleados (numEmpleado, estado, nombreCompleto, genero, fechaNacimiento, fechaIngreso, numTelefono"
                        + ", curp, rfc, nss, puesto, departamento, domicilio, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement ps = null;
                Connection conn = getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(numempleadoForm.getText()));
                ps.setString(2, estadoForm.getSelectionModel().getSelectedItem());
                ps.setString(3, nombrecompletoForm.getText());
                ps.setString(4, generoForm.getSelectionModel().getSelectedItem());
                ps.setString(5, fechanacimientoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(6, fechaingresoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(7, telefonoForm.getText());
                ps.setString(8, curpForm.getText());
                ps.setString(9, rfcForm.getText());
                ps.setString(10, nssForm.getText());
                ps.setString(11, puestoForm.getSelectionModel().getSelectedItem());
                ps.setString(12, departamentoForm.getSelectionModel().getSelectedItem());
                ps.setString(13, domicilioForm.getText());
                ps.setString(14, emailForm.getText());
                System.out.println(sql);
                ps.executeUpdate();
                showEmpleados();
                limpiar();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("El empleado se agregó satisfactoriamente!");
                a.setTitle("Enhorabuena!");
                a.setHeaderText("LOGISMAS");
                a.showAndWait();
            } else {
                byte[] arch = new byte[(int) file.length()];
                InputStream input = new FileInputStream(file);
                input.read(arch);

                String sql = "INSERT INTO empleados (numEmpleado, estado, nombreCompleto, genero, fechaNacimiento, fechaIngreso, numTelefono"
                        + ", curp, rfc, nss, foto, puesto, departamento, domicilio, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement ps = null;
                Connection conn = getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(numempleadoForm.getText()));
                ps.setString(2, estadoForm.getSelectionModel().getSelectedItem());
                ps.setString(3, nombrecompletoForm.getText());
                ps.setString(4, generoForm.getSelectionModel().getSelectedItem());
                ps.setString(5, fechanacimientoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(6, fechaingresoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(7, telefonoForm.getText());
                ps.setString(8, curpForm.getText());
                ps.setString(9, rfcForm.getText());
                ps.setString(10, nssForm.getText());
                ps.setBytes(11, arch);
                ps.setString(12, puestoForm.getSelectionModel().getSelectedItem());
                ps.setString(13, departamentoForm.getSelectionModel().getSelectedItem());
                ps.setString(14, domicilioForm.getText());
                ps.setString(15, emailForm.getText());
                System.out.println(sql);
                ps.executeUpdate();
                showEmpleados();
                limpiar();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("El empleado se agregó satisfactoriamente!");
                a.setTitle("Enhorabuena!");
                a.setHeaderText("LOGISMAS");
                a.showAndWait();
            }
        }

    }

    @FXML
    private void eliminarAction(ActionEvent event) {
        Empleado empleado = tablaEmpleados.getSelectionModel().getSelectedItem();
        String query = "DELETE FROM `empleados` WHERE numEmpleado= " + empleado.getNumEmpleado() + "";
        System.out.println(query);
        executeQuery(query);
        showEmpleados();
    }

    private void limpiar() {
        estadoForm.getSelectionModel().select("SELECCIONAR");
        generoForm.getSelectionModel().select("SELECCIONAR");
        puestoForm.getSelectionModel().select("SELECCIONAR");
        departamentoForm.getSelectionModel().select("SELECCIONAR");
        numempleadoForm.setText("");
        nombrecompletoForm.setText("");
        telefonoForm.setText("");
        curpForm.setText("");
        rfcForm.setText("");
        nssForm.setText("");
        domicilioForm.setText("");
        emailForm.setText("");
        fechaingresoForm.setValue(null);
        fechanacimientoForm.setValue(null);
        file = null;
        lblImg.setText("Sin seleccionar");
    }

    @FXML
    private void limpiarAction(ActionEvent event) {
        estadoForm.getSelectionModel().select("SELECCIONAR");
        generoForm.getSelectionModel().select("SELECCIONAR");
        puestoForm.getSelectionModel().select("SELECCIONAR");
        departamentoForm.getSelectionModel().select("SELECCIONAR");
        numempleadoForm.setText("");
        nombrecompletoForm.setText("");
        telefonoForm.setText("");
        curpForm.setText("");
        rfcForm.setText("");
        nssForm.setText("");
        domicilioForm.setText("");
        emailForm.setText("");
        fechaingresoForm.setValue(null);
        fechanacimientoForm.setValue(null);
        file = null;
        lblImg.setText("Sin seleccionar");
    }

    @FXML
    private void actualizarAction(ActionEvent event) throws FileNotFoundException, SQLException, IOException {
        Empleado empleado = tablaEmpleados.getSelectionModel().getSelectedItem();
        if (file != null) {
            if (empleado != null) {
                byte[] arch = new byte[(int) file.length()];
                InputStream input = new FileInputStream(file);
                input.read(arch);
                String sql = "UPDATE empleados SET estado = ?, nombreCompleto = ?, genero = ?, fechaNacimiento = ?, fechaIngreso = ?, numTelefono = ?"
                        + ", curp = ?, rfc = ?, nss = ?, foto = ?, puesto = ?, departamento = ?, domicilio = ?, email = ? WHERE numEmpleado = ?";
                PreparedStatement ps = null;
                Connection conn = getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, estadoForm.getSelectionModel().getSelectedItem());
                ps.setString(2, nombrecompletoForm.getText());
                ps.setString(3, generoForm.getSelectionModel().getSelectedItem());
                ps.setString(4, fechanacimientoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(5, fechaingresoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(6, telefonoForm.getText());
                ps.setString(7, curpForm.getText());
                ps.setString(8, rfcForm.getText());
                ps.setString(9, nssForm.getText());
                ps.setBytes(10, arch);
                ps.setString(11, puestoForm.getSelectionModel().getSelectedItem());
                ps.setString(12, departamentoForm.getSelectionModel().getSelectedItem());
                ps.setString(13, domicilioForm.getText());
                ps.setString(14, emailForm.getText());
                ps.setInt(15, empleado.getNumEmpleado());

                System.out.println(sql);
                ps.executeUpdate();

                showEmpleados();
                limpiar();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("El empleado se modificó satisfactoriamente!");
                a.setTitle("Enhorabuena!");
                a.setHeaderText("LOGISMAS");
                a.showAndWait();
            }
        } else {
            if (empleado != null) {
                String sql = "UPDATE empleados SET estado = ?, nombreCompleto = ?, genero = ?, fechaNacimiento = ?, fechaIngreso = ?, numTelefono = ?"
                        + ", curp = ?, rfc = ?, nss = ?, puesto = ?, departamento = ?, domicilio = ?, email = ? WHERE numEmpleado = ?";
                PreparedStatement ps = null;
                Connection conn = getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, estadoForm.getSelectionModel().getSelectedItem());
                ps.setString(2, nombrecompletoForm.getText());
                ps.setString(3, generoForm.getSelectionModel().getSelectedItem());
                ps.setString(4, fechanacimientoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(5, fechaingresoForm.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                ps.setString(6, telefonoForm.getText());
                ps.setString(7, curpForm.getText());
                ps.setString(8, rfcForm.getText());
                ps.setString(9, nssForm.getText());
                ps.setString(10, puestoForm.getSelectionModel().getSelectedItem());
                ps.setString(11, departamentoForm.getSelectionModel().getSelectedItem());
                ps.setString(12, domicilioForm.getText());
                ps.setString(13, emailForm.getText());
                ps.setInt(14, empleado.getNumEmpleado());

                System.out.println(sql);
                ps.executeUpdate();
                showEmpleados();
                limpiar();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("El empleado se modificó satisfactoriamente!");
                a.setTitle("Enhorabuena!");
                a.setHeaderText("LOGISMAS");
                a.showAndWait();
            }

        }
    }

}
