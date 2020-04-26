package project;

import java.sql.*;

public class DataBase {

    private Connection conn;

    public void sendQuery(String query) {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(rs);
            stmt.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if(conn != NULL) {
                conn.close();
            }
        }
    }

    public DataBase(){
    }

}