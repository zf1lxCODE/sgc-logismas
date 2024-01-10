/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import logismasapp.Procedimiento;

/**
 * FXML Controller class
 *
 * @author Víctor León
 */
public class ProcedimientosController implements Initializable {

    @FXML
    private TableColumn<Procedimiento, Integer> idCol;
    @FXML
    private TableColumn<Procedimiento, String> nombreCol;
    @FXML
    private TableColumn<Procedimiento, String> deptoCol;
    @FXML
    private TableColumn<Procedimiento, String> descCol;
    @FXML
    private TableColumn<Procedimiento, String> fregistroCol;
    @FXML
    private TableColumn<Procedimiento, String> lastupdateCol;
    @FXML
    private TableView<Procedimiento> tablaProcedimientos;
    @FXML
    private TableColumn<Procedimiento, String> codigoCol;
    @FXML
    private TableColumn<Procedimiento, String> revCol;

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

    public ObservableList<Procedimiento> getProcedimientosList() {
        ObservableList<Procedimiento> procedimientoList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM procedimientos";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Procedimiento procedimiento;
            while (rs.next()) {
                procedimiento = new Procedimiento(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("departamento"), rs.getString("rev"), rs.getString("fecharegistro"), rs.getString("last_update"));
                procedimientoList.add(procedimiento);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return procedimientoList;
    }

    public void showProcedimientos() {
        ObservableList<Procedimiento> list = getProcedimientosList();

        idCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, Integer>("id"));
        codigoCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, String>("codigo"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, String>("nombre"));
        descCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, String>("descripcion"));
        deptoCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, String>("departamento"));
        revCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, String>("rev"));
        fregistroCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, String>("fecharegistro"));
        lastupdateCol.setCellValueFactory(new PropertyValueFactory<Procedimiento, String>("last_update"));

        tablaProcedimientos.setItems(list);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showProcedimientos();
    }

    @FXML
    private void agregaAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProcedimientoDialog.fxml"));
        Scene fxmlFile = new Scene(root);
        Stage window = new Stage();
        window.setScene(fxmlFile);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("LOGISMAS PROVEEDORES");
        window.showAndWait();
    }

    @FXML
    private void editarAction(ActionEvent event) throws IOException {
        if (tablaProcedimientos.getSelectionModel().getSelectedItem() != null) {
            Procedimiento procedimiento = tablaProcedimientos.getSelectionModel().getSelectedItem();
            ObservableList<Procedimiento> list = getProcedimientosList();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProcedimientoDialog.fxml"));
            Parent root = null;
            root = loader.load();
            ProcedimientoDialogController controlador = loader.getController();
            controlador.inicializaprocedimientos(list, procedimiento);
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
        showProcedimientos();
    }

    @FXML
    private void eliminarAction(ActionEvent event) {
        Procedimiento procedimiento = tablaProcedimientos.getSelectionModel().getSelectedItem();
        String query = "DELETE FROM `procedimientos` WHERE id= " + procedimiento.getId() + "";
        System.out.println(query);
        executeQuery(query);
        showProcedimientos();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Procedimiento procedimiento = tablaProcedimientos.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void openSelected(ActionEvent event) {

        Procedimiento procedimiento = tablaProcedimientos.getSelectionModel().getSelectedItem();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = conn.prepareStatement("SELECT archivo FROM procedimientos WHERE id = ?;");
            ps.setInt(1, procedimiento.getId());
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

}
