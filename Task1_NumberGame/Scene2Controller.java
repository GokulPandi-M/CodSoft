package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Scene2Controller {

    @FXML
    private Label label;

    @FXML
    public TextField numfield;

    @FXML
    private int random = (int) (Math.random() * 100) + 1;

    @FXML
    private int chancesLeft = 5;
    private boolean chance;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/hello-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void NumberGuess(ActionEvent e) {
        if (chance || chancesLeft <= 0) {
            label.setText("Game over! Click reset to try again.");
            return;
        }

        try {
            int numuser = Integer.parseInt(numfield.getText());
            System.out.println("Random: " + random);

            if (numuser == random) {
                label.setText("Your guess is correct! You win! 🎉");
                chance = true;
            } else {
                chancesLeft--;
                if (chancesLeft == 0) {
                    label.setText("No more chances! You lost. Number was " + random);
                } else if (numuser < random && numuser > 0) {
                    label.setText("Too low! Chances left: " + chancesLeft);
                } else if (numuser < 0) {
                    label.setText("Enter positive number! Chances left : " + chancesLeft);
                } else {
                    label.setText("Too high! Chances left: " + chancesLeft);
                } 
            }
        } catch (NumberFormatException ex) {
            showAlert("Error", "Please enter a valid number.");
        }
    }

    @FXML
    public void ResetNum(ActionEvent e){
        random = (int) (Math.random() * 100) + 1;
        chancesLeft = 5;
        chance = false;
        label.setText("New game started! You have 5 chances.");
        numfield.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void ExitButton (ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Button");
        alert.setHeaderText("Are you sure you want to close?");
        alert.setContentText("You're getting out of the game");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    public void ButtonClick2(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Button");
        alert.setHeaderText("Are you sure you want to close?");
        alert.setContentText("You're getting out of the game!");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}