package org.example.javafxandjdbc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TextField txtEmail;
    public TableColumn<Student, String> ColEmail;
    @FXML
        private TableColumn<Student, Integer> ColAge;

        @FXML
        private TableColumn<Student, String> ColCourse;

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
        private TextField txtCourse;

        @FXML
        private TextField txtSMax;

        @FXML
        private TextField txtSMin;

        @FXML
        private TextField txtSearchByName;

        private ObservableList<Student> students;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtID.setEditable(false);
        students = FXCollections.observableArrayList();

        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        ColGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        ColCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        ColEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableView.setItems(students);

        TableView.setOnMouseClicked((e) -> {
            Student student = TableView.getSelectionModel().getSelectedItem();
            if (student != null) {
                txtName.setText(student.getName());
                txtID.setText(String.valueOf(student.getId()));
                txtAge.setText(String.valueOf(student.getAge()));
                txtGrade.setText(String.valueOf(student.getGrade()));
                txtCourse.setText(String.valueOf(student.getCourse()));
                txtEmail.setText(String.valueOf(student.getEmail()));

            }
        });
        loadTable();

    }


    @FXML
    void btnAddAction(ActionEvent event) {
        String sql = "INSERT INTO students (name,age,grade,course, email) VALUES (?,?,?,?,?)";

        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtName.getText());
            pstmt.setInt(2, Integer.parseInt(txtAge.getText()));
            pstmt.setString(3, txtGrade.getText());
            pstmt.setString(4, txtCourse.getText());
            pstmt.setString(5, txtEmail.getText());
            pstmt.executeUpdate();
            clearFields();
            loadTable();

        }catch(Exception ex){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
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
                selected.setAge(Integer.parseInt(txtAge.getText().trim()));
                selected.setGrade(Integer.parseInt(txtGrade.getText().trim()));
                selected.setCourse(txtCourse.getText());
                selected.setEmail(txtEmail.getText());
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
        txtCourse.clear();
        txtEmail.clear();

    }

    private void showAlert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void loadTable()
    {
        String sql = "SELECT * FROM students";
        students.clear();
        try(Connection conn = DBConnection.getConnection();){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                students.add(new Student(rs.getString("Name"), rs.getInt("ID"), rs.getInt("Age"),rs.getDouble("Grade"), rs.getString("Course"), rs.getString("Email") ));

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
