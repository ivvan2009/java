package tempname;

import java.sql.*;
import java.util.Locale;

public class DataBase {
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    public static void main(String[] args) {
        loadDriver();
        makeConnection();
        //insertData();
        //usePreparedStatement();
        retrieveData();
        closeAll();
    }

    static void loadDriver() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } 
        catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
    }

    static void makeConnection() {
	      Locale.setDefault(Locale.ENGLISH);
	      String host = "127.0.0.1";
	      String dbName = "xe";
	      int port = 1521;
	      String oracleURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;
	      try {
	           con = DriverManager.getConnection(oracleURL, "SYSTEM", "142008");
	      }
	      catch(SQLException ex) {
	           System.err.println("database connection: " + ex.getMessage());
	      }
    }

     static void insertData() {
        try {
        	stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO COFFEES " +  "VALUES ('Colombian', 101, 8, 0, 0)");
            stmt.executeUpdate("INSERT INTO COFFEES " +  "VALUES ('French_Roast', 49, 9, 0, 0)");
            stmt.executeUpdate("INSERT INTO COFFEES " +  "VALUES ('Espresso', 35, 6, 0, 0)");
            stmt.executeUpdate("INSERT INTO COFFEES " +  "VALUES ('Colombian_Decaf', 101, 5, 0, 0)");
            stmt.executeUpdate("INSERT INTO COFFEES " +  "VALUES ('French_Roast_Decaf', 49,7, 0, 0)");

        }catch(SQLException ex) {
            System.err.println("InsertData: " + ex.getMessage());
        }
     }

    static void usePreparedStatement() {
        try {
            PreparedStatement updateSales;
            String updateString = "update COFFEES " +
                      "set SALES = ? where COF_NAME like ?";
            updateSales = con.prepareStatement(updateString);
            int [] salesForWeek = {175, 150, 60, 155, 90};
            String [] coffees = {"Colombian", "French_Roast", "Espresso",
                     "Colombian_Decaf", "French_Roast_Decaf"};
            int len = coffees.length;
            for(int i = 0; i < len; i++) {
                updateSales.setInt(1, salesForWeek[i]);
                updateSales.setString(2, coffees[i]);
                updateSales.executeUpdate();
            }
        }catch(SQLException ex) {
            System.err.println("UsePreparedStatement: " + ex.getMessage());
       }
    }

    static void retrieveData() {
       try {
           String gdta="SELECT * from Shops";
           stmt = con.createStatement();
           rs = stmt.executeQuery(gdta);
           while (rs.next()) {
                String s = rs.getString("ShopId");
                System.out.println(s);
           }
       }catch(SQLException ex) {
           System.err.println("RetrieveData: " + ex.getMessage());
       }
     }

     static void closeAll() {
         try {
            stmt.close();
            con.close();
         } catch(SQLException ex) {
            System.err.println("closeAll: " + ex.getMessage());
         }
    }
}


