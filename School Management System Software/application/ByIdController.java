package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ByIdController {
   @FXML
   private Label validate;
   @FXML
   private Label RollNum;
   @FXML
   private Label Name;
   @FXML
   private Label FName;
   @FXML
   private Label Caste;
   @FXML
   private Label Religion;
   @FXML
   private Label ClassName;
   @FXML
   private Label Address;
   @FXML
   private Label GuardianNumber;
   @FXML
   private Label DOB;
   @FXML
   private Label CNIC;
   @FXML
   private Label PlaceOfBirth;
   @FXML
   private Label Nationality;
   @FXML
   private Label LastSchool;
   @FXML
   private TextField searchbar;
   @FXML
   private Button search;

   public void Search(ActionEvent event) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata", "root", "");
         Statement st = con.createStatement();
         String sql = "SELECT * FROM `students` WHERE `RollNumber` LIKE '" + this.searchbar.getText() + "'";
         ResultSet rs = st.executeQuery(sql);
         boolean check = false;

         while(rs.next()) {
            this.Name.setWrapText(true);
            this.Name.setText(rs.getString("Name"));
            this.RollNum.setWrapText(true);
            this.RollNum.setText(rs.getString("RollNumber"));
            this.FName.setWrapText(true);
            this.FName.setText(rs.getString("FatherName"));
            this.Caste.setWrapText(true);
            this.Caste.setText(rs.getString("Caste"));
            this.Religion.setWrapText(true);
            this.Religion.setText(rs.getString("Religion"));
            this.ClassName.setWrapText(true);
            this.ClassName.setText(rs.getString("Class"));
            this.Address.setWrapText(true);
            this.Address.setText(rs.getString("Address"));
            this.GuardianNumber.setWrapText(true);
            this.GuardianNumber.setText(rs.getString("GuardianContact"));
            this.DOB.setWrapText(true);
            this.DOB.setText(rs.getString("DateOfBirth"));
            this.CNIC.setWrapText(true);
            this.CNIC.setText(rs.getString("GuardianCNIC"));
            this.PlaceOfBirth.setWrapText(true);
            this.PlaceOfBirth.setText(rs.getString("PlaceOfBirth"));
            this.Nationality.setWrapText(true);
            this.Nationality.setText(rs.getString("Nationality"));
            this.LastSchool.setWrapText(true);
            this.LastSchool.setText(rs.getString("LastSchool"));
            check = true;
            this.validate.setText("");
         }

         if (this.searchbar.getText().equals("")) {
            this.validate.setText("Search Bar Cannot Be Empty");
         }

         if (!check) {
            this.validate.setText("No Such Student Found");
         }
      } catch (Exception var7) {
         System.out.print(var7.getMessage());
      }

   }
}
