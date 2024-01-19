/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logismasapp;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Alertas {

    JdbcDao jdbc = new JdbcDao();

    public boolean confirmDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cuadro de confirmación");
        alert.setHeaderText("Alerta");
        alert.setContentText("¿Estás seguro de borrar el elemento seleccionado?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }

    }
    
        public boolean confirmEdit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cuadro de confirmación");
        alert.setHeaderText("Alerta");
        alert.setContentText("¿Estás seguro de modificar el elemento seleccionado?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }

    }

    public void errorBlank() {
        Alert sa = new Alert(Alert.AlertType.ERROR);
        sa.setContentText("LLENA TODOS LOS CAMPOS");
        sa.setTitle("ERROR");
        sa.setHeaderText("LOGISMAS");
        sa.showAndWait();
    }

    public void infoSuccess() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("El archivo se agregó correctamente!");
        a.setTitle("Enhorabuena!");
        a.setHeaderText("LOGISMAS");
        a.showAndWait();
    }
    
        public void infoSuccessEdit() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("El archivo se modificó correctamente!");
        a.setTitle("Enhorabuena!");
        a.setHeaderText("LOGISMAS");
        a.showAndWait();
    }
        
        public void noSelection() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Por favor, selecciona algún elemento de la tabla");
        a.setTitle("ERROR");
        a.setHeaderText("LOGISMAS");
        a.showAndWait();
    }
        
     public void bigFile() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("El archivo es demasiado grande. Intenta subirlo en partes.");
        a.setTitle("ERROR");
        a.setHeaderText("LOGISMAS");
        a.showAndWait();
    }

    public void openWindow(Parent root) {
        Scene fxmlFile = new Scene(root);
        Stage window = new Stage();
        window.setScene(fxmlFile);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("LOGISMAS");
        window.showAndWait();
    }

    public void openFile(Docu docu) {
        String fileName = null, fileExt = null;
        PreparedStatement ps;
        ResultSet rs;
        byte[] b = null;
        try { 
            ps = jdbc.getConnection().prepareStatement("SELECT * FROM " + data.tbName + " WHERE id = ?;");
            ps.setInt(1, docu.getId());
            System.out.println(ps);
            rs = ps.executeQuery();

            while (rs.next()) {
                b = rs.getBytes("archivo");
                fileName =rs.getString("nombre").trim()+" - Rev "+rs.getString("rev").trim()+" - ARCHIVO TEMPORAL - ";
                fileExt = rs.getString("ext");
            }
            fileExt="."+fileExt;
            InputStream bos = new ByteArrayInputStream(b);
            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);
            OutputStream out = new FileOutputStream(fileName+fileExt);
            out.write(datosPDF);
            System.out.println(fileName + fileExt);
            out.close();
            bos.close();
            Desktop.getDesktop().open(new File(fileName+fileExt));
        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo" + ex.getMessage());
        }

    }

    public ObservableList<Docu> getDocuList() {
        ObservableList<Docu> docuList = FXCollections.observableArrayList();
        String query = "SELECT id, codigo, nombre, rev, fecharegistro, last_update FROM " + data.tbName + "";
        System.out.println(query);
        Statement st;
        ResultSet rs;
        try {
            st = jdbc.getConnection().createStatement();
            rs = st.executeQuery(query);
            Docu docu;
            while (rs.next()) {
                docu = new Docu(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("rev"), rs.getString("fecharegistro"), rs.getString("last_update"));
                docuList.add(docu);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return docuList;
    }

}
