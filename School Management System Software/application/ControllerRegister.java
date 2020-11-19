package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerRegister {
   Application primaryStage;
   @FXML
   private Label status;
   @FXML
   private TextField euname;
   @FXML
   private TextField epassword;
   @FXML
   private CheckBox check;
   @FXML
   private TextField name;
   @FXML
   private TextArea address;
   @FXML
   private TextField email;
   @FXML
   private TextField cnic;
   @FXML
   private DatePicker dob;

   public void Back(ActionEvent event) throws Exception {
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/application/Login.fxml"));
      Scene scene = new Scene(root);
      Stage primaryStage = new Stage();
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setTitle("Login");
   }

   public void Submit(ActionEvent event) throws Exception {
      String error = "";
      if (this.euname.getText().equals("")) {
         error = error + "Username ";
      }

      if (this.name.getText().equals("")) {
         error = error + "Name ";
      }

      if (this.email.getText().equals("")) {
         error = error + "Email ";
      }

      if (this.epassword.getText().equals("")) {
         error = error + "Password ";
      }

      if (this.cnic.getText().equals("")) {
         error = error + "CNIC ";
      }

      if (this.address.getText().equals("")) {
         error = error + "Address ";
      }

      if (this.dob.getValue() == null) {
         error = error + "Date of Birth ";
      }

      if (!this.check.isSelected()) {
         error = error + " \nPlease Accept Terms and Conditions ";
      }

      String Username;
      if (this.name.getText().equals("") | this.euname.getText().equals("") | this.epassword.getText().equals("") | this.address.getText().equals("") | this.cnic.getText().equals("") | this.email.getText().equals("") | this.dob.getValue() == null) {
         Username = "Please Fill Following Areas: \n" + error;
         this.status.setText(Username);
      } else {
         Username = this.euname.getText();
         String Password = this.epassword.getText();
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata", "root", "");
         Statement st = con.createStatement();
         if (!(this.name.getText().equals("") | this.euname.getText().equals("") | this.epassword.getText().equals("") | this.address.getText().equals("") | this.cnic.getText().equals("") | this.email.getText().equals("") | this.dob.getValue() == null)) {
            String sql2 = "Select * from login where Username='" + this.euname.getText() + "'";
            ResultSet rs = st.executeQuery(sql2);
            if (!rs.next()) {
               String sql = "INSERT INTO login(Username, Password) values (+'" + Username + "'" + "," + "'" + Password + "'" + ") ";
               st.executeUpdate(sql);
               this.status.setText("Congratulations! You are Successfully Registered\nBack to Login");
               this.euname.clear();
               this.epassword.clear();
               this.name.clear();
               this.email.clear();
               this.cnic.clear();
               this.address.clear();
               this.check.setSelected(false);
               this.dob.setValue(null);
            } else {
               this.status.setText("Username Already Exist Please Choose New One");
            }
         }
      }

   }
}
