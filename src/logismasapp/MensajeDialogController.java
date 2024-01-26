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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import jdk.jfr.internal.tool.Main;

public class MensajeDialogController implements Initializable {

    @FXML
    private Label labelHeader;
    private Label labelArchivo;
    private Mensaje msj;
    private ObservableList<Mensaje> msjs;
    int id;
    
    Alertas a = new Alertas();
    JdbcDao jdbc = new JdbcDao();
    MensajesController conk;
    
    @FXML
    private ComboBox<String> destinatarioCombo;
    @FXML
    private TextField asuntoTF;
    @FXML
    private TextArea mensajeTF;
    @FXML
    private Button enviarBtn;

    public Mensaje getMensaje() {
        return msj;
    }

    public void control(MensajesController controladork) {
        conk = controladork;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        destinatarioCombo.setItems(FXCollections.observableArrayList(getUsuarios()));
    }
    
        private List<String> getUsuarios() {
        List<String> options = new ArrayList<>();
        try {
            Connection conn = jdbc.getConnection();
            String query = "SELECT usuario FROM usuarios";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                options.add(set.getString("usuario"));
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

    @FXML
    private void enviarAction(ActionEvent event) throws SQLException {
        if (asuntoTF.getText().isEmpty() || mensajeTF.getText().isEmpty() || destinatarioCombo.getSelectionModel().getSelectedItem().equals("")) {
            a.errorBlank();
        } else {
            String sql = "INSERT INTO mensajes (remitente, destinatario, asunto, mensaje) VALUES(?, ?, ?, ?);";
            PreparedStatement ps = jdbc.getConnection().prepareStatement(sql);
            ps.setString(1, data.username);
            ps.setString(2, destinatarioCombo.getSelectionModel().getSelectedItem());
            ps.setString(3, asuntoTF.getText());
            ps.setString(4, mensajeTF.getText());
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
                    a.infoSuccessMsj();
                }
            }
        }
    }
    
    

}
