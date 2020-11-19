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

public class SearchClassController {
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
         String sql = "SELECT * FROM `students` WHERE `Class` LIKE '" + this.searchbar.getText() + "'";
         ResultSet rs = st.executeQuery(sql);
         boolean check = false;
         String N = "";
         String R = "";
         String F = "";
         String C = "";
         String RL = "";
         String CN = "";
         String A = "";
         String GN = "";
         String D = "";
         String CNI = "";
         String P = "";
         String NE = "";
         String LI = "";

         while(rs.next()) {
            N = N + rs.getString("Name") + "\n\n";
            this.Name.setWrapText(true);
            this.Name.setText(N);
            this.RollNum.setWrapText(true);
            R = R + rs.getString("RollNumber") + "\n\n";
            this.RollNum.setText(R);
            this.FName.setWrapText(true);
            F = F + rs.getString("FatherName") + "\n\n";
            this.FName.setText(F);
            this.Caste.setWrapText(true);
            C = C + rs.getString("Caste") + "\n\n";
            this.Caste.setText(C);
            this.Religion.setWrapText(true);
            RL = RL + rs.getString("Religion") + "\n\n";
            this.Religion.setText(RL);
            this.ClassName.setWrapText(true);
            CN = CN + rs.getString("Class") + "\n\n";
            this.ClassName.setText(CN);
            this.Address.setWrapText(true);
            A = A + rs.getString("Address") + "\n\n";
            this.Address.setText(A);
            this.GuardianNumber.setWrapText(true);
            GN = GN + rs.getString("GuardianContact") + "\n\n";
            this.GuardianNumber.setText(GN);
            this.DOB.setWrapText(true);
            D = D + rs.getString("DateOfBirth") + "\n\n";
            this.DOB.setText(D);
            this.CNIC.setWrapText(true);
            CNI = CNI + rs.getString("GuardianCNIC") + "\n\n";
            this.CNIC.setText(CNI);
            this.PlaceOfBirth.setWrapText(true);
            P = P + rs.getString("PlaceOfBirth") + "\n\n";
            this.PlaceOfBirth.setText(P);
            this.Nationality.setWrapText(true);
            NE = NE + rs.getString("Nationality") + "\n\n";
            this.Nationality.setText(NE);
            this.LastSchool.setWrapText(true);
            LI = LI + rs.getString("LastSchool") + "\n\n";
            this.LastSchool.setText(LI);
            check = true;
            this.validate.setText("");
         }

         if (this.searchbar.getText().equals("")) {
            this.validate.setText("Search Bar Cannot Be Empty");
         }

         if (!check) {
            this.validate.setText("No Such Student Found");
         }
      } catch (Exception var20) {
         System.out.print(var20.getMessage());
      }

   }
}
