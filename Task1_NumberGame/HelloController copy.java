package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {

    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/scene2.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void ExitButton1 (ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Button");
        alert.setHeaderText("Are you sure you want to close?");
        alert.setContentText("You're getting out of the game!");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void ButtonClick(ActionEvent event) throws IOException {
        System.out.println("true");
        switchToScene2(event);
    }

}