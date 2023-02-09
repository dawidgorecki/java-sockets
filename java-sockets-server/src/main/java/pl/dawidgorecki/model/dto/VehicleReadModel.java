package pl.dawidgorecki.model.dto;

import lombok.Getter;
import pl.dawidgorecki.model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VehicleReadModel {
    private final String brand;
    private final String model;
    private final List<InsuranceReadModel> insuranceOffers;

    public VehicleReadModel(Vehicle vehicle) {
        brand = vehicle.getBrand();
        model = vehicle.getModel();

        insuranceOffers = vehicle.getInsuranceOffers().stream()
                .map(InsuranceReadModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Pojazd: " + brand + " " + model + ", oferty: " + insuranceOffers;
    }
}
