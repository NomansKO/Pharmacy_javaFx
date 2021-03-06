package controller.addNew;

import com.jfoenix.controls.JFXTextField;
import controller.table.employeeTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

import java.sql.*;
import java.util.List;

public class addEmployee {
    @FXML
    private JFXTextField empID;
    @FXML
    private JFXTextField empName;
    @FXML
    private JFXTextField empLastName;
    @FXML
    private JFXTextField empMobile;
    @FXML
    private JFXTextField empPassword;
    @FXML
    private TableView employeeView;
    @FXML
    private TableColumn<employeeTable, String> empIDColumn;
    @FXML
    private TableColumn<employeeTable, String> empNameColumn;
    @FXML
    private TableColumn<employeeTable, String> empLastNameColumn;
    @FXML
    private TableColumn<employeeTable, String> empMobileColumn;
    @FXML
    private TableColumn<employeeTable, String> empEmailColumn;
    @FXML
    private TableColumn<employeeTable, String> empPasswordColumn;
    @FXML
    private JFXTextField empEmail;

    public void initialize() {

        renderTable();
    }

    public void saveEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        String EMPID = this.empID.getText();
        String firstname = this.empName.getText();
        String LASTNAME = this.empLastName.getText();
        String MOBILE = this.empMobile.getText();
        String EMAIL = this.empEmail.getText();
        String PASSWORD = this.empPassword.getText();

        if (validateEmployeeData()) {
            employeeTable employeeTable = new employeeTable(EMPID, firstname, LASTNAME, MOBILE, EMAIL, PASSWORD);
            employeeTable.saveEmployee();
            employeeView.getItems().clear();
            clearView();
            renderTable();
            System.out.println(employeeTable.getAll());


        }



    }

    public void renderTable() {
        List<employeeTable> employee = employeeTable.getAll();
        this.empIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.empNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.empLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.empMobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        this.empEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.empPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        employeeView.getItems().addAll(employee);
        System.out.println(employeeView);
        System.out.println(employee);

    }

    private void clearView() {
        empID.clear();
        empName.clear();
        empLastName.clear();
        empMobile.clear();
        empEmail.clear();
        empPassword.clear();
    }

    private   boolean validateEmployeeData() {
        if (empID.getText().isEmpty()){
            alert("enter id") ;
            return false;
        }
        else if (empName.getText().isEmpty()){
            alert("Enter Name");
            return false;
        }
        else if (empLastName.getText().isEmpty()){
            alert("Enter empLastName");
            return false;
        }
        else if (empMobile.getText().isEmpty()){
            alert("Enter empMobile");
            return false;
        }
        else if (empEmail.getText().isEmpty()){
            alert("Enter empEmail");
            return false;
        }
        else if (empPassword.getText().isEmpty()){
            alert("Enter empPassword");
            return false;
        }
         return true;

    }

    public void alert(String title) {
        Notifications.create()
                .title("Employee")
                .text(title)
                .showWarning();
    }

}









