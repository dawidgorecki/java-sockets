package pl.dawidgorecki.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vehicle {
    private long id;
    private String login;
    private String brand;
    private String model;
    private List<Insurance> insuranceOffers = new ArrayList<>();
    private LocalDateTime insertTime;
}
