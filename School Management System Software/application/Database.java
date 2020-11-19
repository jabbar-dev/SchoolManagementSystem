package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
   public static void main(String[] args) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata", "root", "");
         Statement st = con.createStatement();
         String sql = "SELECT * FROM `students` WHERE `Name` LIKE 'Abdul Jabbar Shah' ";
         st.executeQuery(sql);
      } catch (Exception var5) {
         System.out.print(var5.getMessage());
      }

   }
}
