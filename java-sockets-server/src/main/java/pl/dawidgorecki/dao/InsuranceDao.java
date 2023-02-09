package pl.dawidgorecki.dao;

import pl.dawidgorecki.model.Insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsuranceDao {
    private final Connection connection;

    public InsuranceDao(final Connection connection) {
        this.connection = connection;
    }

    public List<Insurance> findAllByVehicleId(long id) throws SQLException {
        String query = "SELECT * FROM insurance_offers io WHERE io.vehicle_id = ?";

        List<Insurance> result = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Insurance insurance = new Insurance();
                insurance.setId(resultSet.getLong("id"));
                insurance.setVehicleId(resultSet.getLong("vehicle_id"));
                insurance.setInsurer(resultSet.getString("insurer"));
                insurance.setPrice(resultSet.getBigDecimal("price"));
                insurance.setInsertTime(resultSet.getTimestamp("insert_time").toLocalDateTime());

                result.add(insurance);
            }
        }

        return result;
    }
}
