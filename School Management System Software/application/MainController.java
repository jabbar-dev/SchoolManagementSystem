package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController implements Initializable {
   public boolean database = true;
   String user = "";
   @FXML
   private Label conlabel;
   @FXML
   private Label status;
   @FXML
   private TextField uname;
   public String username;
   @FXML
   private TextField password;
   @FXML
   private Label dlabel;

   public void Exit(ActionEvent event) {
      System.exit(0);
   }

   public void Login(ActionEvent event) throws Exception {
      try {
         if (this.database) {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata", "root", "");
            Statement st = con.createStatement();
            String sql = "Select * from login where Username='" + this.uname.getText() + "' and Password='" + this.password.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (this.uname.getText().equals("")) {
               this.uname.setText(" ");
            }

            if (rs.next() & !this.uname.getText().equals(" ")) {
               this.status.setText("Login Successful");
               FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/application/Dashboard.fxml"));
               Parent root = (Parent)loader.load();
               DashboardController sc = (DashboardController)loader.getController();
               sc.setText("WELCOME " + this.uname.getText().toUpperCase());
               Scene scene = new Scene(root);
               Stage primaryStage = new Stage();
               primaryStage.setScene(scene);
               primaryStage.show();
               primaryStage.setResizable(false);
               primaryStage.setTitle("Dashboard School Management System");
               this.uname.clear();
               this.password.clear();
            }
         }

         if (!this.database) {
            this.status.setText("Database is Not Connected");
         }

         if (this.uname.getText().equals(" ")) {
            this.status.setText("Please Enter Username or Password");
         } else {
            this.status.setText("INVALID Username or Password");
         }
      } catch (Exception var11) {
         System.out.print(var11.getMessage());
      }

   }

   public void Register(ActionEvent event) throws Exception {
      try {
         Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/application/Register.fxml"));
         Scene scene = new Scene(root);
         Stage primaryStage = new Stage();
         primaryStage.setScene(scene);
         primaryStage.show();
         primaryStage.setTitle("Register");
      } catch (Exception var5) {
         System.out.print(var5.getMessage());
      }

   }

   public void initialize(URL arg0, ResourceBundle arg1) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata", "root", "");
         this.database = true;
         this.conlabel.setText("Database is Connected*");
      } catch (Exception var4) {
         this.database = false;
         this.conlabel.setText("Database is Disconnected");
      }

   }
}
