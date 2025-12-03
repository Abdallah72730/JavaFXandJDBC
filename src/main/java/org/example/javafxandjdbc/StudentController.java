package org.example.javafxandjdbc;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentController {

        @FXML
        private TableColumn<?, ?> ColAge;

        @FXML
        private TableColumn<?, ?> ColGrade;

        @FXML
        private TableColumn<?, ?> ColID;

        @FXML
        private TableColumn<?, ?> ColName;

        @FXML
        private TableView<?> TableView;

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


}
