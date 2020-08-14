/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        if (username.contains("marcommfti") && (password.contains("marcomm123")))
        {                
                Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuMarcomm.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
                ((Node) event.getSource()).getScene().getWindow().hide();
        }
        else 
            if (username.contains("divisi") && (password.contains("divisi123")))
            {
                Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuDivisi.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
                ((Node) event.getSource()).getScene().getWindow().hide();
            } else {
                label.setText("Username or password invalid");
                tfUsername.setText("");
                tfPassword.setText("");
        }
    }    
    
    @FXML
    private void LPJ(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/DaftarLPJ.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void merchandise(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/IsiStock.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void dataAnggota(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/DaftarAnggota.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();          
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    
    @FXML
    private void dashboard(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void cekLPJ(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/CekLPJ.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();    
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void logout2(MouseEvent event) throws IOException {     
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    
    @FXML
    private void EXIT(ActionEvent event) {
        System.exit(0);
    }
}
