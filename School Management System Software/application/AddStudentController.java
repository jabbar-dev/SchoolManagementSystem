package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddStudentController implements Initializable {
   ObservableList list = FXCollections.observableArrayList();
   @FXML
   private DatePicker DOB;
   @FXML
   private TextField RollNumber;
   @FXML
   private TextField StudentName;
   @FXML
   private TextField FatherName;
   @FXML
   private TextField Caste;
   @FXML
   private ChoiceBox<?> Gender;
   @FXML
   private TextField Religion;
   @FXML
   private TextField GuardianNumber;
   @FXML
   private TextField PlaceOfBirth;
   @FXML
   private TextField GCNIC;
   @FXML
   private TextField Nationality;
   @FXML
   private TextArea Address;
   @FXML
   private TextField LastInstitute;
   @FXML
   private CheckBox StudentCheck;
   @FXML
   private Button SubmitStudent;
   @FXML
   private Label StudentStatus;
   @FXML
   private TextField ClassName;

   public void SubmitStudent(ActionEvent event) throws Exception {
      String Error = "";
      if (this.DOB.getValue() == null) {
         Error = Error + "Date of Birth ";
      }

      if (this.RollNumber.getText().equals("")) {
         Error = Error + "Roll Number \n";
      }

      if (this.StudentName.getText().equals("")) {
         Error = Error + "Student Name ";
      }

      if (this.FatherName.getText().equals("")) {
         Error = Error + "Father Name \n";
      }

      if (this.Caste.getText().equals("")) {
         Error = Error + "Caste ";
      }

      if (this.Gender.getValue() == null) {
         Error = Error + "Gender \n";
      }

      if (this.Religion.getText().equals("")) {
         Error = Error + "Religion ";
      }

      if (this.ClassName.getText().equals("")) {
         Error = Error + "Class \n";
      }

      if (this.Address.getText().equals("")) {
         Error = Error + "Address ";
      }

      if (this.GuardianNumber.getText().equals("")) {
         Error = Error + "Guardian Number: \n ";
      }

      if (this.GCNIC.getText().equals("")) {
         Error = Error + "Guardian CNIC ";
      }

      if (this.PlaceOfBirth.getText().equals("")) {
         Error = Error + "Place of Birth  \n";
      }

      if (this.Nationality.getText().equals("")) {
         Error = Error + "Nationality ";
      }

      if (this.LastInstitute.getText().equals("")) {
         Error = Error + "Last Insititute \n";
      }

      if (!this.StudentCheck.isSelected()) {
         Error = Error + "\nPlease Accept the Terms and Conditions";
      }

      if (this.RollNumber.getText().equals("") | this.StudentName.getText().equals("") | this.FatherName.getText().equals("") | this.Caste.getText().equals("") | this.Address.getText().equals("") | this.GuardianNumber.getText().equals("") | this.DOB.getValue() == null | this.GCNIC.getText().equals("") | this.PlaceOfBirth.getText().equals("") | this.Nationality.getText().equals("") | this.LastInstitute.getText().equals("") | !this.StudentCheck.isSelected()) {
         String BigError = "Please Fill Following Fields to Continue: \n" + Error;
         this.StudentStatus.setText(BigError);
      } else {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata", "root", "");
         Statement st = con.createStatement();
         String sql3 = "Select * from students where RollNumber='" + this.RollNumber.getText() + "'";
         ResultSet rs = st.executeQuery(sql3);
         if (!rs.next()) {
            String sql = "INSERT INTO students (RollNumber, Name, FatherName, Caste, Gender, Religion, Class, Address, GuardianContact, DateOfBirth, GuardianCNIC, PlaceOfBirth, Nationality, LastSchool)values(+'" + this.RollNumber.getText() + "'" + "," + "'" + this.StudentName.getText() + "'" + "," + "'" + this.FatherName.getText() + "'" + "," + "'" + this.Caste.getText() + "'" + "," + "'" + this.Gender.getValue().toString() + "'" + "," + "'" + this.Religion.getText() + "'" + "," + "'" + this.ClassName.getText() + "'" + "," + "'" + this.Address.getText() + "'" + "," + "'" + this.GuardianNumber.getText() + "'" + "," + "'" + ((LocalDate)this.DOB.getValue()).toString() + "'" + "," + "'" + this.GCNIC.getText() + "'" + "," + "'" + this.PlaceOfBirth.getText() + "'" + "," + "'" + this.Nationality.getText() + "'" + "," + "'" + this.LastInstitute.getText() + "'" + ")";
            st.executeUpdate(sql);
            this.StudentStatus.setText("Registration was Successfull");
            this.RollNumber.clear();
            this.StudentName.clear();
            this.FatherName.clear();
            this.Caste.clear();
            this.Gender.setValue(null);
            this.Religion.clear();
            this.ClassName.clear();
            this.Address.clear();
            this.GuardianNumber.clear();
            this.DOB.setValue(null);
            this.GCNIC.clear();
            this.PlaceOfBirth.clear();
            this.Nationality.clear();
            this.LastInstitute.clear();
         } else {
            this.StudentStatus.setText("Roll Number Already Exist \n Choose New One");
         }
      }

   }

   public void loadData() {
      this.list.removeAll(this.list);
      String Male = "Male";
      String Female = "Female";
      String non = "Non Specified";
      this.list.addAll(new Object[]{Male, Female, non});
      this.Gender.getItems().addAll(this.list);
   }

   public void initialize(URL arg0, ResourceBundle arg1) {
      this.loadData();
   }
}
