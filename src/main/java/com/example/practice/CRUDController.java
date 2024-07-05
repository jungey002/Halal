package com.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;


public class CRUDController implements Initializable {
    public TableView<Admin> login_tbl;
    public TableColumn<Admin,Integer> id;
    public TableColumn <Admin,String> name;
    public TableColumn <Admin,String> email;
    public TableColumn <Admin,String> password;
    public TextField uid;
    public TextField uname;
    public TextField uemail;
    public TextField upassword;
    @FXML
    private Label welcomeText;

    ObservableList<Admin> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fethdata();
    }

    private void fethdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/ lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                login_tbl.getItems().add(new Admin(id, name, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<Admin,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Admin,String>("name"));
        email.setCellValueFactory(new PropertyValueFactory<Admin,String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<Admin,String>("password"));
        login_tbl.setItems(list);


    }

    public void InsertData(ActionEvent actionEvent) {



        String name = uname.getText();
        String email = uemail.getText();
        String password = upassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `user`( `name`, `email`, `password`) VALUES ('"+name+"','"+email+"','"+password+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void UpdateData(ActionEvent actionEvent) {
        String id = uid.getText();
        String name = uname.getText();
        String email = uemail.getText();
        String password = upassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `user` SET `name`='"+name+"',`email`='"+email+"',`password`='"+password+"' WHERE id='"+id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {

        String id = uid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `user` WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String id = uid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                uname.setText(name);
                uemail.setText(email);
                upassword.setText(password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}