package com.example.practice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DashboardController {


    public Button logout;

    public Button admin;
    public Button employee;

    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Admin(ActionEvent actionEvent) {
        try {

            Parent secondScene = FXMLLoader.load(getClass().getResource("CRUD.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("CRUD Scene");
            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) admin.getScene().getWindow();
            firstSceneStage.close();



            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Employee(ActionEvent actionEvent) {

        try {

            Parent secondScene = FXMLLoader.load(getClass().getResource("Employee.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Employee Scene");
            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) employee.getScene().getWindow();
            firstSceneStage.close();



            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Logout(ActionEvent actionEvent) {
        try {

            Parent secondScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Admin Scene");
            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) logout.getScene().getWindow();
            firstSceneStage.close();



            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
