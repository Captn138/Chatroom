package project;

import java.sql.*;

public class DataBase {

    private Connection conn;

    public void sendQuery(String query) throws Exception {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println(rs);
        stmt.close();
        if(conn != null) {
            conn.close();
        }
    }

    public DataBase(){
    }

}