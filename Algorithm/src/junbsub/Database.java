package junbsub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Database {

    private Connection con;

    Database() {
        con = DatabaseConnection.getConnection();
    }

    boolean select(Object locationId, Object corDataTime) {

        boolean isInsert = true;

        try (PreparedStatement ps = selectLocation(locationId, corDataTime);
             ResultSet rs = ps.executeQuery()) {

            isInsert = !rs.next();

        } catch (SQLException se) {
            System.out.println("select 에러 : " + se.getMessage());
        }
        return isInsert;
    }

    private PreparedStatement selectLocation(Object locationId, Object corDateTime) throws SQLException {
        String query = "select * from weatherInfo where location_id = ? and cordatetime = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setObject(1, locationId);
        ps.setObject(2, corDateTime);

        return ps;
    }


    private int select(Object weather) { // weather

        int weatherId = 0;

        try (PreparedStatement ps = selectWeather(weather);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                weatherId = rs.getInt("weather_id");
            }

        } catch (SQLException e) {
            System.out.println("select(weather) 에러");
        }

        return weatherId;
    }

    private PreparedStatement selectWeather(Object weather) throws SQLException {
        String query = "select * from weatherStatus where status = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setObject(1, weather);
        return ps;
    }

    void insert(Object locationId, Object cordatetime, Object temp, Object pop, Object pubdatetime,
                Object weather) {

        int weatherId = select(weather);

        try (PreparedStatement ps = insertValue(locationId, cordatetime, temp, pop, pubdatetime, weatherId)) {
            int rows = ps.executeUpdate();
            if(rows<1) {
                System.out.println("삽입 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement insertValue(Object locationId, Object cordatetime, Object temp, Object pop, Object pubdatetime, Object weatherId) throws SQLException {
        String query = "insert into weatherInfo (location_id, weather_id, temperature, pop, cordatetime, pubdatetime) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setObject(1, locationId);
        ps.setObject(2, weatherId);
        ps.setObject(3, temp);
        ps.setObject(4, pop);
        ps.setObject(5, cordatetime);
        ps.setObject(6, pubdatetime);
        return ps;
    }

    void update(Object locationId, Object cordatetime, Object temp, Object pop, Object pubdatetime,
                Object weather) {

        try (PreparedStatement ps = updateValue(locationId, cordatetime, temp, pop, pubdatetime, select(weather))) {

            int rows = ps.executeUpdate();
            if(rows<1) {
                System.out.println("업데이트 실패");
            }

        } catch (SQLException e) {
            System.out.println("update 에러");
        }
    }

    private PreparedStatement updateValue(Object locationId, Object cordatetime, Object temp, Object pop, Object pubdatetime, Object weatherId) throws SQLException {
        String query = "update weatherInfo set weather_id = ?, cordatetime = ? , temperature = ? , pubdatetime = ? where location_id = ? and cordatetime = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setObject(1, weatherId);
        ps.setObject(2, cordatetime);
        ps.setObject(3, temp);
        ps.setObject(4, pubdatetime);
        ps.setObject(5, locationId);
        ps.setObject(6, cordatetime);
        return ps;
    }
}
