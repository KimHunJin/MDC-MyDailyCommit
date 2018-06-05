package junbsub;

import key.Key;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 싱글톤 패턴을 이용.
 * 객체의 생성을 한 번으로 제한함.
 */
public class DatabaseConnection {

    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL = Key.JUNGSUB_DB_URL;
    private static final String U_ID = Key.JUNGSUB_DB_ID;
    private static final String U_PWD = Key.JUNGSUB_DB_PWD;

    private static Connection con = null;

    private DatabaseConnection() { }

    static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, U_ID, U_PWD);
            } catch (ClassNotFoundException e) {
                System.out.println("라이브러리 에러 : " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("sql 에러 : " + e.getMessage());
            }
        }
        return con;
    }

    public static void close() {
        if(con!=null) {
            try {
                if(!con.isClosed()) con.close();
            } catch (Exception e) {
                System.out.println("close 에러 : " + e.getMessage());
            }
        }
        con = null;
    }
}
