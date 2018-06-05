package gcp;


import key.Key;

import java.sql.*;

public class DBConnect {

    private Connection con;
    private ResultSet rs;
    private Statement st;

    public DBConnect() {
        try {
            con = DriverManager.getConnection(Key.GCP_DB_URL, Key.GCP_DB_ID, Key.GCP_DB_PWD);
            st = con.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void insertNameData(String query) {
        try {
            st.executeUpdate(query);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void close() {
        try {
            rs.close();
            st.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
