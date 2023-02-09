package pl.dawidgorecki.model.dto;

import lombok.Getter;
import pl.dawidgorecki.model.Insurance;

import java.math.BigDecimal;

@Getter
public class InsuranceReadModel {
    private final String insurer;
    private final BigDecimal price;

    public InsuranceReadModel(Insurance insurance) {
        insurer = insurance.getInsurer();
        price = insurance.getPrice();
    }

    @Override
    public String toString() {
        return insurer + ", " + price + "pln";
    }
}
