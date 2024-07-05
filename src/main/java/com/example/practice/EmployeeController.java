package com.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class EmployeeController implements Initializable {
    public TableView<Employee> employee_tbl;
    public TableColumn<Employee, Integer> eid;
    public TableColumn<Employee, String> name;
    public TableColumn<Employee, Double> salary;
    public TableColumn<Employee, String> phone;
    public TextField uid;
    public TextField uname;
    public TextField usalary;
    public TextField uphone;
    @FXML
    private Label welcomeText;

    ObservableList<Employee> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fetchData();
    }

    @FXML
    private void fetchData() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM employee_tbl";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int eid = resultSet.getInt("eid");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                String phone = resultSet.getString("phone");
                employee_tbl.getItems().add(new Employee(eid, name, salary, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eid.setCellValueFactory(new PropertyValueFactory<>("eid"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        employee_tbl.setItems(list);
    }

    public void InsertData(ActionEvent actionEvent) {
        String name = uname.getText();
        double salary = Double.parseDouble(usalary.getText());
        String phone = uphone.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO employee_tbl (name, salary, phone) VALUES ('" + name + "', '" + salary + "', '" + phone + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        int eid = Integer.parseInt(uid.getText());
        String name = uname.getText();
        double salary = Double.parseDouble(usalary.getText());
        String phone = uphone.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "UPDATE employee_tbl SET name='" + name + "', salary='" + salary + "', phone='" + phone + "' WHERE eid='" + eid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {
        int eid = Integer.parseInt(uid.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "DELETE FROM employee_tbl WHERE eid='" + eid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {
        int eid = Integer.parseInt(uid.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM employee_tbl WHERE eid='" + eid + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                String phone = resultSet.getString("phone");

                uname.setText(name);
                usalary.setText(String.valueOf(salary));
                uphone.setText(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
