package pl.dawidgorecki.dao;

import pl.dawidgorecki.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private final Connection connection;

    public VehicleDao(final Connection connection) {
        this.connection = connection;
    }

    public List<Vehicle> findAllByUserId(long id) throws SQLException {
        String query = "SELECT v.id, v.brand, v.model, u.login, v.insert_time FROM vehicles v " +
                "LEFT JOIN users u on u.login = v.login " +
                "WHERE u.id = ?";

        List<Vehicle> result = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getLong("id"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setLogin(resultSet.getString("login"));
                vehicle.setInsertTime(resultSet.getTimestamp("insert_time").toLocalDateTime());

                result.add(vehicle);
            }
        }

        return result;
    }
}
