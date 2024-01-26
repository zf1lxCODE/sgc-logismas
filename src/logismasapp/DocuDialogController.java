/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logismasapp;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import com.mysql.cj.jdbc.exceptions.PacketTooBigException;
import static java.awt.Color.blue;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class DocuDialogController implements Initializable {

    @FXML
    private TextField codigoTF;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField revTF;
    @FXML
    private Button btnseleccionar;
    @FXML
    private Label labelHeader;
    @FXML
    private Label labelArchivo;

    private TextField rutaTF;
    private Docu docu;
    private ObservableList<Docu> docus;
    int id;
    File file;
    String aux;
    Alertas a = new Alertas();
    JdbcDao jdbc = new JdbcDao();
    DocusController conk;

    public Docu getDocu() {
        return docu;
    }

    public void inicializaDocus(ObservableList<Docu> docus, Docu docu) {
        this.docus = docus;
        this.docu = docu;
        this.codigoTF.setText(docu.getCodigo());
        this.nombreTF.setText(docu.getNombre());
        this.id = docu.getId();
        this.revTF.setText(docu.getRev());
        labelHeader.setText("Modificar archivo");
    }

    public void control(DocusController controladork) {
        conk = controladork;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (this.docu == null) {
            labelHeader.setText("Guardar archivo");
        } else {
            labelHeader.setText("Modificar archivo");
        }
    }

    @FXML
    private void elegirRuta(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        file = chooser.showOpenDialog(null);
        labelArchivo.setText(file.getPath());
        aux = file.getPath();
        if (aux.contains(".")) {
            aux = aux.substring(aux.lastIndexOf(".") + 1);
        }
        System.out.println("File extension is: " + aux);
    }

    @FXML
    private void guardarProce(ActionEvent event) throws IOException, SQLException {
        if (this.docu == null) {
            if (codigoTF.getText().isEmpty() || revTF.getText().isEmpty() || nombreTF.getText().isEmpty() || file == null) {
                a.errorBlank();
            } else {
                FileInputStream fis = new FileInputStream(file);
                String sql = "INSERT INTO " + data.tbName + " (codigo, nombre, rev, archivo, ext) VALUES(?, ?, ?, ?, ?);";
                PreparedStatement ps = jdbc.getConnection().prepareStatement(sql);
                ps.setString(1, codigoTF.getText());
                ps.setString(2, nombreTF.getText());
                ps.setString(3, revTF.getText());
                ps.setBlob(4, fis);
                ps.setString(5, aux);
                System.out.println(sql);
                int auxc = 0;
                try {
                    ps.executeLargeUpdate();
                } catch (PacketTooBigException | MysqlDataTruncation ex) {
                    auxc = 1;
                    a.bigFile();
                } catch (SQLSyntaxErrorException ex) {
                    auxc = 1;
                    a.noPermitido();
                } finally {
                    if (auxc == 0) {
                        a.infoSuccess();
                    }
                }
                conk.showDocus();
            }
        } else {
            if (a.confirmEdit()) {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    String sql = "UPDATE " + data.tbName + " SET codigo = ?, nombre = ?, rev = ?, archivo = ?, ext = ? WHERE id = ?";
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(sql);
                    ps.setString(1, codigoTF.getText());
                    ps.setString(2, nombreTF.getText());
                    ps.setString(3, revTF.getText());
                    ps.setBlob(4, fis);
                    ps.setString(5, aux);
                    ps.setInt(6, docu.getId());
                    int auxc = 0;
                    try {
                        ps.executeLargeUpdate();
                    } catch (PacketTooBigException ex) {
                        auxc = 1;
                        a.bigFile();
                    } catch (SQLSyntaxErrorException ex) {
                        auxc = 1;
                        a.noPermitido();
                    } finally {
                        if (auxc == 0) {
                            a.infoSuccessEdit();
                        }
                    }
                    conk.showDocus();
                } else {
                    String sql = "UPDATE " + data.tbName + " SET codigo = ?, nombre = ?, rev = ? WHERE id = ?";
                    PreparedStatement ps;
                    ps = jdbc.getConnection().prepareStatement(sql);
                    ps.setString(1, codigoTF.getText());
                    ps.setString(2, nombreTF.getText());
                    ps.setString(3, revTF.getText());
                    ps.setInt(4, docu.getId());
                    int auxc = 0;
                    try {
                        ps.executeLargeUpdate();
                    } catch (PacketTooBigException ex) {
                        auxc = 1;
                        a.bigFile();
                    } catch (SQLSyntaxErrorException ex) {
                        auxc = 1;
                        a.noPermitido();
                    } finally {
                        if (auxc == 0) {
                            a.infoSuccessEdit();
                        }
                    }
                    conk.showDocus();
                }
            }
        }
    }

}
