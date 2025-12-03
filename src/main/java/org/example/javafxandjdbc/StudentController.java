package org.example.javafxandjdbc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

        @FXML
        private TableColumn<Student, Integer> ColAge;

        @FXML
        private TableColumn<Student, Double> ColGrade;

        @FXML
        private TableColumn<Student, Integer> ColID;

        @FXML
        private TableColumn<Student, String> ColName;

        @FXML
        private TableView<Student> TableView;

        @FXML
        private Button btnAdd;

        @FXML
        private Button btnClear;

        @FXML
        private Button btnDelete;

        @FXML
        private Button btnExport;

        @FXML
        private Button btnUpdate;

        @FXML
        private TextField txtAge;

        @FXML
        private TextField txtGrade;

        @FXML
        private TextField txtID;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtSMax;

        @FXML
        private TextField txtSMin;

        @FXML
        private TextField txtSearchByName;

        private ObservableList<Student> students;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        students = FXCollections.observableArrayList();

        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        ColGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        TableView.setItems(students);

        TableView.setOnMouseClicked((e) -> {
            Student student = TableView.getSelectionModel().getSelectedItem();
            if (student != null) {
                txtName.setText(student.getName());
                txtID.setText(String.valueOf(student.getId()));
                txtAge.setText(String.valueOf(student.getAge()));
                txtGrade.setText(String.valueOf(student.getGrade()));

            }
        });
    }

    @FXML
    void btnAddAction(ActionEvent event) {
        try{
            Student s = new Student(txtName.getText(), Integer.parseInt(txtID.getText()), Integer.parseInt(txtAge.getText()), Double.parseDouble(txtGrade.getText()) );
            students.add(s);
            clearFields();
        }catch(NumberFormatException ex){
            showAlert("Please provide valid numbers");
        }

    }
    @FXML
    void btnClearAction(ActionEvent event) {
        clearFields();
    }
    @FXML
    void btnDeleteAction(ActionEvent event) {
        Student selected =  TableView.getSelectionModel().getSelectedItem();
        if(selected!=null){
            students.remove(selected);
            clearFields();
        }
    }
    @FXML
    void btnUpdateAction(ActionEvent event) {
        Student selected =  TableView.getSelectionModel().getSelectedItem();
        if(selected!=null){
            try{
                selected.setName(txtName.getText());
                selected.setId(Integer.parseInt(txtID.getText()));
                selected.setAge(Integer.parseInt(txtAge.getText()));
                selected.setGrade(Integer.parseInt(txtGrade.getText()));
            }catch(NumberFormatException ex){
                showAlert("valid numbers must be provided");
            }
        }
    }

    private void clearFields()
    {
        txtName.clear();
        txtID.clear();
        txtAge.clear();
        txtGrade.clear();

    }

    private void showAlert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
