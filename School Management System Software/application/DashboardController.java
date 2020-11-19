package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardController implements Initializable {
   @FXML
   private Label dlabel;
   MainController mc = new MainController();

   public void SearchById() throws Exception {
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/application/SearchById.fxml"));
      Scene scene = new Scene(root);
      Stage primaryStage = new Stage();
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setTitle("Search By Id");
   }

   public void AboutUs() throws Exception {
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/application/AboutUs.fxml"));
      Scene scene = new Scene(root);
      Stage primaryStage = new Stage();
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setTitle("About Us");
   }

   public void SearchByName() throws Exception {
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/application/StudentByName.fxml"));
      Scene scene = new Scene(root);
      Stage primaryStage = new Stage();
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setTitle("Search By Name");
   }

   public void SearchByClass() throws Exception {
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/application/SearchClass.fxml"));
      Scene scene = new Scene(root);
      Stage primaryStage = new Stage();
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setTitle("Search By Class");
   }

   public void initialize(URL arg0, ResourceBundle arg1) {
   }

   public void logout(ActionEvent event) throws Exception {
      this.mc.Exit(event);
   }

   public void setText(String user) {
      this.dlabel.setText(user);
   }

   public void AddStudent(ActionEvent event) throws IOException {
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/application/AddStudent.fxml"));
      Scene scene = new Scene(root);
      Stage primaryStage = new Stage();
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setTitle("Add Student's Record");
   }
}
