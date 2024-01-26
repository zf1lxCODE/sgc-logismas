/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logismasapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import logismasapp.JdbcDao;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextField textoUsuario;
    @FXML
    private PasswordField textoPass;
    @FXML
    private Button loginBtn;
    @FXML
    private CheckBox login_checkbox;
    @FXML
    private TextField textoPassVis;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Entrar(ActionEvent event) throws IOException {
        data.userDB="rootdos";
        data.passDB="root";
        data.hostDB="isidro-qcpc";
        data.portDB="3306";
        data.dbDB="logismasdatabase";
        
        Window owner = textoUsuario.getScene().getWindow();
        
        data.username = textoUsuario.getText();
        
        System.out.println(data.username);
        System.out.println(data.username);
        
        if (textoUsuario.getText().isEmpty()||textoPass.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Por favor, llena todos los campos", "Form error!");
        }

        String username = textoUsuario.getText();
        String password = textoPass.getText();

        JdbcDao jdbcDao = new JdbcDao();
        
        boolean flag = jdbcDao.validate(username, password);
        
        if (!flag) {
            infoBox("Favor de ingresar usario y contraseña correctos", null, "failed");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DashboardMain.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("LOGISMAS | Dashboard");
                stage.setScene(new Scene(root));
                stage.show();
                loginBtn.getScene().getWindow().hide();
            } catch (IOException ex) {
            }
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.initOwner(owner);
        alert.showAndWait();
    }

    @FXML
    public void loginShowPassword() {
        if (login_checkbox.isSelected()) {
            textoPassVis.setText(textoPass.getText());
            textoPassVis.setVisible(true);
            textoPass.setVisible(false);
        } else {
            textoPass.setText(textoPassVis.getText());
            textoPassVis.setVisible(false);
            textoPass.setVisible(true);
        }
    }

}
