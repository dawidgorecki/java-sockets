package pl.dawidgorecki.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Insurance {
    private long id;
    private long vehicleId;
    private String insurer;
    private BigDecimal price;
    private LocalDateTime insertTime;
}
