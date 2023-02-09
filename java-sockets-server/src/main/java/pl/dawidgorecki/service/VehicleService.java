package pl.dawidgorecki.service;

import pl.dawidgorecki.dao.InsuranceDao;
import pl.dawidgorecki.dao.VehicleDao;
import pl.dawidgorecki.jdbc.ConnectionFactory;
import pl.dawidgorecki.model.Insurance;
import pl.dawidgorecki.model.Vehicle;
import pl.dawidgorecki.model.dto.VehicleReadModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {
    public List<VehicleReadModel> findAllByUserId(long id, boolean fetchInsurance) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            VehicleDao vehicleDao = new VehicleDao(connection);
            List<Vehicle> vehicles = vehicleDao.findAllByUserId(id);

            if (fetchInsurance) {
                InsuranceDao insuranceDao = new InsuranceDao(connection);

                for (Vehicle vehicle : vehicles) {
                    List<Insurance> result = insuranceDao.findAllByVehicleId(vehicle.getId());
                    vehicle.setInsuranceOffers(result);
                }
            }

            return vehicles.stream()
                    .map(VehicleReadModel::new)
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
